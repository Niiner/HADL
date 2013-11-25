import java.util.Observable;
import java.util.Observer;

import links.B1;
import ports.ReceiveRequestP;
import ports.SendRequestP;
import ports.SendRequestP2;
import services.ReceiveRequestS;
import services.SendRequestS2;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;
import elements.ports.Service;
import exceptions.NewAttachmentNotAllowed;
import exceptions.NewBindingNotAllowed;
import exceptions.NoSuchPortException;
import exceptions.NoSuchRoleException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceRoleException;
import exceptions.WrongInterfaceServiceException;

/**
 * This class provides an implementation for the Class Server which is an implementation of a component
 * @author BulFag
 *
 */
public class Server extends Component implements Observer{
	
	private ServerDetail serverDetail;
	private Port receiveRequestP;
	private Port sendRequestP2; 
	private Service receiveRequestS;
	private Service sendRequestS2;
//	private B1 b1;
	
	/**
	 * Constructor
	 * @param config The parent of the component, the {@link Configuration}
	 * @param name The name of the Server
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
			throws NoSuchPortException, WrongInterfacePortException, NoSuchServiceException, 
			WrongInterfaceServiceException, NoSuchRoleException, WrongInterfaceRoleException, 
			NewAttachmentNotAllowed, NewBindingNotAllowed{
		super(config, name);
		
		// Instanciation 
		this.serverDetail = new ServerDetail(this, "ServerDetail");
		this.receiveRequestP = new ReceiveRequestP("ReceiveRequestP");
		this.sendRequestP2 = new SendRequestP2("ReceiveRequestP"); 
		this.receiveRequestS = new ReceiveRequestS("ReceiveRequestS");
		this.sendRequestS2 = new SendRequestS2("SendRequestS2");
		
		// Server listen the receiveRequestP
		receiveRequestP.addObserver(this);
		
		// Adding ports and services
		this.addRequiredPort(receiveRequestP);
		this.addProvidedPort(sendRequestP2);
		this.addRequiredService(receiveRequestS);
		this.addProvidedService(sendRequestS2);
		this.receiveRequestS.addPort(receiveRequestP);
		this.sendRequestS2.addPort(sendRequestP2);
		
		// Create a new Binding link 
//		this.b1 = new B1("B1", this.getReceiveRequestP() , serverDetail.getConnectionManager().getExternalSocket());
	}
	
	/**
	 * Getter
	 * @return {@link ReceiveRequestP} The receiver port of the server
	 */
	public ReceiveRequestP getReceiveRequestP(){
		ReceiveRequestP p = null;
		for (Port port : requiredPorts){
			if (port instanceof ReceiveRequestP){
				p = (ReceiveRequestP) port;
			}
		}
		return p;
	}
	
	/**
	 * Getter
	 * @return {@link SendRequestP2} The sendRequest service of the server
	 */
	public SendRequestS2 getSendRequestS2(){
		SendRequestS2 s = null;
		for (Service service : providedServices){
			if (service instanceof SendRequestS2){
				s = (SendRequestS2) service;
			}
		}
		return s;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("Server notify");
		if (observable instanceof ReceiveRequestP){
			// Call the provided service in server
			this.getSendRequestS2().sendRequest(object);
		}
		if (observable instanceof SendRequestP2){
			// Call the configuration to find the binding link
			this.serverDetail.transfertData(observable, object);
		}
	}
}
