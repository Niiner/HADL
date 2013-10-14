package pattern;

import java.util.ArrayList;
import java.util.List;

import elements.Port;
import elements.Properties;
import elements.Service;

public class Component implements IComponentType {
	
	private String name;
	private List<Properties> properties = new ArrayList<Properties>();
	
	private List<Port> ports = new ArrayList<Port>();
	private List<Service> services = new ArrayList<Service>();
	

}
