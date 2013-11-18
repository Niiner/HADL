import links.B1;
import ports.ReceiveRequestP;
import ports.SendRequestP;
import ports.SendRequestP2;
import services.ReceiveRequestS;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;
import elements.ports.Service;


public class Server extends Component{
	
	private ServerDetail serverDetail = new ServerDetail("ServerDetail");
	private B1 b1;
	
	public Server(Configuration config, String name){
		super(config, name);
		Port receiveRequestP = new ReceiveRequestP("ReceiveRequestP");
		Port sendRequestP2 = new SendRequestP2("ReceiveRequestP"); 
		Service receiveRequestS = new ReceiveRequestS("ReceiveRequestS");
		this.ports.add(receiveRequestP);
		this.ports.add(sendRequestP2);
		this.services.add(receiveRequestS);
		receiveRequestS.addPort(receiveRequestP);
		this.b1 = new B1("B1", this.getReceiveRequestP() , serverDetail.getConnectionManager().getExternalSocket());
	}
	
	public ReceiveRequestP getReceiveRequestP(){
		ReceiveRequestP p = null;
		for (Port port : ports){
			if (port instanceof SendRequestP){
				p = (ReceiveRequestP) port;
			}
		}
		return p;
	}
}
