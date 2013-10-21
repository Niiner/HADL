package database.ports;

import elements.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


// Change port type ! 

public class Query extends SynchronPort {

	public Query(String name, InterfaceType interfaceT,
			VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
		// TODO Auto-generated constructor stub
	}

}
