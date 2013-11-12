package elements;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

public abstract class Role extends PhysicalInterface{

	public Role(String name, InterfaceType interfaceT, VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
	}

}
