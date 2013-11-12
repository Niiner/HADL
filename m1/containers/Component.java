package containers;

import java.util.ArrayList;
import java.util.List;

import elements.ports.Port;
import elements.ports.Properties;
import elements.ports.Service;


public class Component implements IComponentType {
	
	protected String name;
	
	protected List<Properties> properties = new ArrayList<Properties>();	
	protected List<Port> ports = new ArrayList<Port>();
	protected List<Service> services = new ArrayList<Service>();
	
	public Component(String name/*, List<Port> portList*/){
		
		boolean oneProvided;
		
		/*for(Port port : portList){
			if(port.getInterfaceType() == InterfaceType.Provided){
				oneProvided = true;
			}
		}*/
		
		// Créer sa propre exception : instancier si au moins un port provided 
		// this.name = name;
	
	}

	/**
	 * Adding a {@link Port} into the ports' list of the {@link Component}
	 * @param port The {@link Port} to add
	 */
	public void addPort(Port port){
		this.ports.add(port);
	}
	
	/**
	 * Adding a {@link Service} into the ports' list of the {@link Component}
	 * @param port The {@link Service} to add
	 */
	public void addService(Service service){
		try{
			this.services.add(service);
		}
		catch(Wr)
		
	}

	public List<Port> getPorts() {
		return ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

}
