package sqlquery.roles;

import elements.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Callee extends Role{

	public Callee(String name, InterfaceType interfaceT,
			VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
	}

}
