package sqlquery.roles;

import elements.physicalinterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Caller extends Role{

	public Caller(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

}
