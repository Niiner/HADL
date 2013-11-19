package securityquery.roles;

import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Requestor extends Role{

	public Requestor(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

}
