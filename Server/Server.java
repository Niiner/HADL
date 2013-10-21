import ports.ReceiveRequestP;
import ports.SendRequestP;
import ports.SendRequestP2;
import services.ReceiveRequestS;
import containers.Component;
import elements.Port;


public class Server extends Component{
	
	public Server(String name){
		super(name);
		this.ports.add(new ReceiveRequestP("ReceiveRequestP"));
		this.ports.add(new SendRequestP2("ReceiveRequestP"));
		this.services.add(new ReceiveRequestS("ReceiveRequestS"));
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
