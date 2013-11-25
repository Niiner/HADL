package securityquery.roles;

import elements.physicalinterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SecurityManagerR extends Role{

	public SecurityManagerR(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

}
