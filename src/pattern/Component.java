package pattern;

import java.util.ArrayList;
import java.util.List;

import elements.Port;
import elements.Properties;
import elements.Service;

public class Component implements IComponentType {
	
	protected String name;
	protected List<Properties> properties = new ArrayList<Properties>();
	
	protected List<Port> ports = new ArrayList<Port>();
	protected List<Service> services = new ArrayList<Service>();
	

}
