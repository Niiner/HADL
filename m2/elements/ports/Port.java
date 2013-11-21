package elements.ports;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

public abstract class Port extends PhysicalInterface {

	public Port(String name, InterfaceType interfaceT, VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
	}

	public void receiveData(Object msg){
		System.out.println("On arrive dans le port " + this.name);
	}
}
