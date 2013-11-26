package client;
import java.util.Observable;
import java.util.Observer;

import ports.ReceiveResponseP2;
import ports.SendRequestP;
import properties.SourceCode;
import properties.Visualization;
import services.SendRequestS;
import configuration.SystemClientServer;
import containers.Component;
import elements.physicalInterface.ports.Port;
import elements.physicalInterface.services.Service;
import exceptions.NoSuchPortException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceServiceException;

/**
 * This class provides an implementation for the Client
 * @author Niiner-PC
 *
 */
public class Client extends Component implements Observer{
	
	private ReceiveResponseP2 receiveResponseP2;
	
	/**
	 * Constructor
	 * @param config the {@link Configuration} of the Client
	 * @param name the name of the client
	 * @throws NoSuchPortException
	 * @throws WrongInterfacePortException
	 * @throws NoSuchServiceException
	 * @throws WrongInterfaceServiceException
	 */
	public Client(SystemClientServer config, String name) throws NoSuchPortException, WrongInterfacePortException, NoSuchServiceException, WrongInterfaceServiceException{
		super(config, name);
		Port sendRequestP = new SendRequestP("SendRequestP");
		Service sendRequestS = new SendRequestS("SendRequestS");
		receiveResponseP2 = new ReceiveResponseP2("ReceiveResponseP2");
		
		// Client listen the sendRequestP
		sendRequestP.addObserver(this);
		receiveResponseP2.addObserver(this);
		
		// Adding services and ports to the Client
		this.properties.add(new Visualization("Visualization"));
		this.properties.add(new SourceCode("SourceCode"));
		this.addProvidedPort(sendRequestP);
		this.addProvidedService(sendRequestS);
		this.addRequiredPort(receiveResponseP2);
		sendRequestS.addPort(sendRequestP);
	}
	
	/**
	 * @return the port {@link SendRequestP} of {@link Client}
	 */
	public SendRequestP getSendRequestP(){
		SendRequestP p = null;
		for (Port port : providedPorts){
			if (port instanceof SendRequestP){
				p = (SendRequestP) port;
			}
		}
		return p;
	}
	
	/**
	 * @return the service {@link SendRequestS} of {@link Client}
	 */
	public SendRequestS getSendRequestS(){
		SendRequestS s = null;
		for (Service service : providedServices){
			if (service instanceof SendRequestS){
				s = (SendRequestS) service;
			}
		}
		return s;
	}
	

	/**
	 * @return the receiveResponseP2
	 */
	public ReceiveResponseP2 getReceiveResponseP2() {
		return receiveResponseP2;
	}

	/**
	 * @param receiveResponseP2 the receiveResponseP2 to set
	 */
	public void setReceiveResponseP2(ReceiveResponseP2 receiveResponseP2) {
		this.receiveResponseP2 = receiveResponseP2;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- Client notify ----- ]");
		if (observable instanceof SendRequestP){
			((SystemClientServer) this.configuration).transfertData(observable, object);
		}
		else if (observable instanceof ReceiveResponseP2){
			System.out.println("C'est bon tu as la reponse petit Client");
		}
	}
}
