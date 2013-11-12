package clearanceRequest.roles;

import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Grantor extends Role{
	
	public Grantor(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
}
