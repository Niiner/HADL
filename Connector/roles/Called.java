package roles;

import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Called extends Role{
	
	public Called(String name){
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void receiveRequest(Object msg){
		System.out.println("Entrer dans le role " + this.name);
		setChanged();
		notifyObservers();
	}
}
