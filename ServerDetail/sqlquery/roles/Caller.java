package sqlquery.roles;

import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Caller extends Role{

	public Caller(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

}
