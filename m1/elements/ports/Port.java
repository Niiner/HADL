package elements;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

public abstract class Port extends PhysicalInterface {

	public Port(String name, InterfaceType interfaceT, VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
	}

}
