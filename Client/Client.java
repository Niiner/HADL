import elements.Properties;
import pattern.Component;
import properties.SourceCode;
import properties.Visualization;


public class Client extends Component{
	
	public Client(Properties visualization, Properties sc){
		super();
		this.name = "Client";
		this.properties.add(new Visualization());
		this.properties.add(new SourceCode());
	}
}
