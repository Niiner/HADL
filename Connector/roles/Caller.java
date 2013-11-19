package roles;

import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Caller extends Role{
	
	public Caller(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	public void receiveData(Object msg){
		System.out.println("On arrive dans le role caller");
	}
}
