package elements.ports;

import java.util.ArrayList;
import java.util.List;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

public abstract class Service extends PhysicalInterface{

	List<Port> usedPorts;
	
	public Service(String name, InterfaceType interfaceT, VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
		usedPorts = new ArrayList<Port>();
	}
	
	public List<Port> getUsedPorts() {
		return usedPorts;
	}

	public void setUsedPorts(List<Port> usedPorts) {
		this.usedPorts = usedPorts;
	}


	public void addPort(Port p){
		this.usedPorts.add(p);
	}

}
