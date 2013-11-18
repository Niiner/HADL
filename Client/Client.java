import ports.ReceiveRequestP;
import ports.SendRequestP;
import properties.SourceCode;
import properties.Visualization;
import services.ReceiveRequestS;
import services.SendRequestS;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;
import elements.ports.Service;
import exceptions.NoSuchPortException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceServiceException;

public class Client extends Component{
	
	public Client(Configuration config, String name) throws NoSuchPortException, WrongInterfacePortException, NoSuchServiceException, WrongInterfaceServiceException{
		super(config, name);
		
		Port receiveRequestP = new ReceiveRequestP("SendRequestP");
		Service receiveRequestS = new ReceiveRequestS("SendRequestS");
		
		// Adding services and ports to the Client
		this.properties.add(new Visualization("Visualization"));
		this.properties.add(new SourceCode("SourceCode"));
		this.addProvidedPort(receiveRequestP);
		this.addRequiredService(receiveRequestS);
		receiveRequestS.addPort(receiveRequestP);
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

	public void sendRequest(String msg){
		SendRequestS useService = null;
		for (Service s : this.getProvidedServices()){
			if (s instanceof SendRequestS){
				useService = (SendRequestS) s;
			}
		}
		useService.receiveRequest(msg);
	}
	
}
