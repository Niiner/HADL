import ports.ReceiveRequestP;
import properties.SourceCode;
import properties.Visualization;
import services.ReceiveRequestS;
import containers.Component;
import elements.Properties;


public class Client extends Component{
	
	public Client(String name){
		super(name);
		this.properties.add(new Visualization("Visualization"));
		this.properties.add(new SourceCode("SourceCode"));
		this.ports.add(new ReceiveRequestP("SendRequestP"));
		this.services.add(new ReceiveRequestS("SendRequestS"));
	}
}
