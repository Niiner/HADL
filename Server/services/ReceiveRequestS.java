package services;

import elements.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class ReceiveRequestS extends Service {
	
	public ReceiveRequestS(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

}
