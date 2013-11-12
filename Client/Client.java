import ports.ReceiveRequestP;
import ports.SendRequestP;
import properties.SourceCode;
import properties.Visualization;
import services.ReceiveRequestS;
import containers.Component;
import elements.ports.Port;

public class Client extends Component{
	
	public Client(String name){
		super(name);
		
		// Adding services and ports to the Client
		this.properties.add(new Visualization("Visualization"));
		this.properties.add(new SourceCode("SourceCode"));
		this.addPort(new ReceiveRequestP("SendRequestP"));
		this.addService(new ReceiveRequestS("SendRequestS"));
	}
	
	public SendRequestP getSendRequestP(){
		SendRequestP p = null;
		for (Port port : ports){
			if (port instanceof SendRequestP){
				p = (SendRequestP) port;
			}
		}
		return p;
	}
}
