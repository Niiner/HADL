package elements.ports;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

public abstract class PhysicalInterface {
	
	protected VisibilityType visibilityType;
	protected InterfaceType interfaceType;
	protected String name;
	
	public PhysicalInterface(String name, InterfaceType interfaceT, VisibilityType visibilityT){
		this.name = name;
		this.interfaceType = interfaceT;
		this.visibilityType = visibilityT;
	}
	
	public VisibilityType getVisibilityType() {
		return visibilityType;
	}
	
	public void setVisibilityType(VisibilityType visibility) {
		this.visibilityType = visibility;
	}
	
	public InterfaceType getInterfaceType() {
		return interfaceType;
	}
	
	public void setInterfaceType(InterfaceType interfaceT) {
		this.interfaceType = interfaceT;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}