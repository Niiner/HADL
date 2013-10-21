package pattern;

import java.util.ArrayList;
import java.util.List;

import links.Link;
import elements.Port;
import elements.Properties;
import elements.Role;
import elements.Service;

public class Configuration implements IComponentType, IConnectorType {
	
	protected List<IComponentType> childComponent = new ArrayList<IComponentType>();
	protected List<IConnectorType> childConnector = new ArrayList<IConnectorType>();
	
	protected String name;
	protected List<Properties> properties = new ArrayList<Properties>();
	
	protected List<Port> ports = new ArrayList<Port>();
	protected List<Service> services = new ArrayList<Service>();
	
	protected List<Role> roles = new ArrayList<Role>();
	
	protected List<Link> links = new ArrayList<Link>();

}
