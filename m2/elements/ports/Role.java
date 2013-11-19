package elements.ports;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

public abstract class Role extends PhysicalInterface{

	public Role(String name, InterfaceType interfaceT, VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
	}

	public void receiveData(Object msg){
		System.out.println("On arrive dans le role");
	}
}
