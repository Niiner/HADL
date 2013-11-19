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


public class Server extends Component{
	
	private ServerDetail serverDetail;
	private B1 b1;
	
	public Server(Configuration config, String name) throws NoSuchPortException, WrongInterfacePortException, NoSuchServiceException, WrongInterfaceServiceException, NoSuchRoleException, WrongInterfaceRoleException{
		super(config, name);
		serverDetail = new ServerDetail("ServerDetail");
		Port receiveRequestP = new ReceiveRequestP("ReceiveRequestP");
		Port sendRequestP2 = new SendRequestP2("ReceiveRequestP"); 
		Service receiveRequestS = new ReceiveRequestS("ReceiveRequestS");
		this.addRequiredPort(receiveRequestP);
		this.addProvidedPort(sendRequestP2);
		this.addRequiredService(receiveRequestS);
		receiveRequestS.addPort(receiveRequestP);
		this.b1 = new B1("B1", this.getReceiveRequestP() , serverDetail.getConnectionManager().getExternalSocket());
	}
	
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
