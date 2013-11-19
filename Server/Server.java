import links.B1;
import ports.ReceiveRequestP;
import ports.SendRequestP;
import ports.SendRequestP2;
import services.ReceiveRequestS;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;
import elements.ports.Service;
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
public class Server extends Component{
	
	private ServerDetail serverDetail;
	private Port receiveRequestP;
	private Port sendRequestP2; 
	private Service receiveRequestS;
	private B1 b1;
	
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
	 */
	public Server(Configuration config, String name) throws NoSuchPortException, WrongInterfacePortException, NoSuchServiceException, WrongInterfaceServiceException, NoSuchRoleException, WrongInterfaceRoleException{
		super(config, name);
		
		// Instanciation 
		this.serverDetail = new ServerDetail("ServerDetail");
		this.receiveRequestP = new ReceiveRequestP("ReceiveRequestP");
		this.sendRequestP2 = new SendRequestP2("ReceiveRequestP"); 
		this.receiveRequestS = new ReceiveRequestS("ReceiveRequestS");
		
		// Adding ports and services
		this.addRequiredPort(receiveRequestP);
		this.addProvidedPort(sendRequestP2);
		this.addRequiredService(receiveRequestS);
		this.receiveRequestS.addPort(receiveRequestP);
		
		// Create a new Binding link 
		this.b1 = new B1("B1", this.getReceiveRequestP() , serverDetail.getConnectionManager().getExternalSocket());
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
}
