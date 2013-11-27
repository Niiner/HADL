package server;

import java.util.Observable;
import java.util.Observer;

import message.Message;
import ports.ReceiveRequestP;
import ports.ReceiveResponseP;
import ports.SendRequestP2;
import serverDetail.ServerDetail;
import services.ReceiveRequestS;
import services.SendRequestS2;
import configuration.SystemClientServer;
import containers.Component;
import containers.Configuration;
import database.model.Person;
import elements.physicalInterface.ports.Port;
import elements.physicalInterface.services.Service;
import exceptions.NewAttachmentNotAllowed;
import exceptions.NewBindingNotAllowed;
import exceptions.NoSuchPortException;
import exceptions.NoSuchRoleException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceRoleException;
import exceptions.WrongInterfaceServiceException;

/**
 * This class provides an implementation for the Class Server which is an
 * implementation of a component
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Server extends Component implements Observer {

	private ServerDetail serverDetail;
	private Port receiveRequestP;
	private Port sendRequestP2;
	private Service receiveRequestS;
	private Service sendRequestS2;
	private ReceiveResponseP receiveResponseP;

	/**
	 * Constructor
	 * 
	 * @param config
	 *            The parent of the component, the {@link Configuration}
	 * @param name
	 *            The name of the Server
	 * @throws NoSuchPortException
	 * @throws WrongInterfacePortException
	 * @throws NoSuchServiceException
	 * @throws WrongInterfaceServiceException
	 * @throws NoSuchRoleException
	 * @throws WrongInterfaceRoleException
	 * @throws NewAttachmentNotAllowed
	 * @throws NewBindingNotAllowed
	 */
	public Server(Configuration config, String name)
			throws NoSuchPortException, WrongInterfacePortException,
			NoSuchServiceException, WrongInterfaceServiceException,
			NoSuchRoleException, WrongInterfaceRoleException,
			NewAttachmentNotAllowed, NewBindingNotAllowed {
		super(config, name);

		// Instantiation
		this.receiveRequestP = new ReceiveRequestP("ReceiveRequestP");
		this.sendRequestP2 = new SendRequestP2("SendRequestP2");
		this.receiveRequestS = new ReceiveRequestS("ReceiveRequestS");
		this.sendRequestS2 = new SendRequestS2("SendRequestS2");
		this.receiveResponseP = new ReceiveResponseP("ReceiveResponseP");

		// Server listen the receiveRequestP
		receiveRequestP.addObserver(this);
		sendRequestP2.addObserver(this);
		receiveResponseP.addObserver(this);

		// Adding ports and services
		this.addRequiredPort(receiveRequestP);
		this.addProvidedPort(sendRequestP2);
		this.addRequiredService(receiveRequestS);
		this.addProvidedService(sendRequestS2);
		this.addProvidedPort(receiveResponseP);
		this.receiveRequestS.addPort(receiveRequestP);
		this.sendRequestS2.addPort(sendRequestP2);

		// Create the configuration after implement this component
		this.serverDetail = new ServerDetail(this, "ServerDetail");
	}

	/**
	 * Getter
	 * 
	 * @return {@link ReceiveRequestP} The receiver port of the server
	 */
	public ReceiveRequestP getReceiveRequestP() {
		ReceiveRequestP p = null;
		for (Port port : requiredPorts) {
			if (port instanceof ReceiveRequestP) {
				p = (ReceiveRequestP) port;
			}
		}
		return p;
	}

	/**
	 * Getter
	 * 
	 * @return {@link SendRequestP2} The sendRequest service of the server
	 */
	public SendRequestS2 getSendRequestS2() {
		SendRequestS2 s = null;
		for (Service service : providedServices) {
			if (service instanceof SendRequestS2) {
				s = (SendRequestS2) service;
			}
		}
		return s;
	}

	/**
	 * @return the receiveResponseP
	 */
	public ReceiveResponseP getReceiveResponseP() {
		return receiveResponseP;
	}

	/**
	 * @param receiveResponseP
	 *            the receiveResponseP to set
	 */
	public void setReceiveResponseP(ReceiveResponseP receiveResponseP) {
		this.receiveResponseP = receiveResponseP;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- Server notify ----- ]");
		if (observable instanceof ReceiveRequestP) {
			// Call the provided service in server
			this.getSendRequestS2().sendRequest(object);
		} else if (observable instanceof SendRequestP2) {
			// Call the configuration to find the binding link
			this.serverDetail.transfertData(observable, object);
		} else if (observable instanceof ReceiveResponseP) {
			((SystemClientServer) this.configuration).transfertData(observable,
					object);
		}
	}
}
