package elements;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

public abstract class Service extends PhysicalInterface{

	public Service(String name, InterfaceType interfaceT, VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
	}

}
