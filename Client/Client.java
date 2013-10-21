import properties.SourceCode;
import properties.Visualization;
import containers.Component;
import elements.Properties;


public class Client extends Component{
	
	public Client(Properties visualization, Properties sc){
		super("Client");
		this.properties.add(new Visualization());
		this.properties.add(new SourceCode());
	}
}
