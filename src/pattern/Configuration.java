package pattern;

import java.util.ArrayList;
import java.util.List;

import links.Link;
import elements.Port;
import elements.Properties;
import elements.Role;
import elements.Service;

public class Configuration implements IComponentType, IConnectorType {
	
	private List<IComponentType> childComponent = new ArrayList<IComponentType>();
	private List<IConnectorType> childConnector = new ArrayList<IConnectorType>();
	
	private String name;
	private List<Properties> properties = new ArrayList<Properties>();
	
	private List<Port> ports = new ArrayList<Port>();
	private List<Service> services = new ArrayList<Service>();
	
	private List<Role> roles = new ArrayList<Role>();
	
	private List<Link> links = new ArrayList<Link>();

}
