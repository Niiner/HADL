package pattern;

import java.util.ArrayList;
import java.util.List;

public class Configuration implements IComponentType, IConnectorType {
	
	private List<IComponentType> childComponent = new ArrayList<IComponentType>();
	private List<IConnectorType> childConnector = new ArrayList<IConnectorType>();
	
	private String name;
	private List<Properties> properties = new ArrayList<Properties>();
	
	private List<Port> ports = new ArrayList<Port>();
	private List<Service> services = new ArrayList<Service>();
	
	private List<Role> roles = new ArrayList<Role>();
	
	private List<Links> links = new ArrayList<Links>();

}
