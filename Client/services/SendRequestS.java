package services;

import elements.ports.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SendRequestS extends Service {
	
	public SendRequestS(String name){
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void receive(String msg) {
//		if (this.)
	}

}
