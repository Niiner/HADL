package roles;

import elements.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Caller extends Role{
	
	public Caller(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
}
