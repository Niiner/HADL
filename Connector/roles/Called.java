package roles;

import elements.physicalInterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Called extends Role{
	
	public Called(String name){
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void receiveRequest(Object msg){
		System.out.println("[ENTRY] in role " + this.name);
		setChanged();
		notifyObservers();
	}
}
