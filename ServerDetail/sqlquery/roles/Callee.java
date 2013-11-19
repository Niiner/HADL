package sqlquery.roles;

import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Callee extends Role{

	public Callee(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

}
