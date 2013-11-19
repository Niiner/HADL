package securityquery.roles;

import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SecurityManagerR extends Role{

	public SecurityManagerR(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

}
