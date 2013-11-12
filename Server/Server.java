import links.B1;
import ports.ReceiveRequestP;
import ports.SendRequestP;
import ports.SendRequestP2;
import services.ReceiveRequestS;
import containers.Component;
import elements.ports.Port;


public class Server extends Component{
	
	private ServerDetail serverDetail = new ServerDetail("ServerDetail");
	private B1 b1;
	
	public Server(String name){
		super(name);
		this.ports.add(new ReceiveRequestP("ReceiveRequestP"));
		this.ports.add(new SendRequestP2("ReceiveRequestP"));
		this.services.add(new ReceiveRequestS("ReceiveRequestS"));
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
