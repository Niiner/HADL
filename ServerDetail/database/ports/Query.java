package database.ports;

import elements.physicalinterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


// Change port type ! 

public class Query extends SynchronPort {

	public Query(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

}
