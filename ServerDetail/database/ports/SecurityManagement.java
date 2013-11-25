package database.ports;

import elements.physicalinterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SecurityManagement extends SynchronPort {

	public SecurityManagement(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

}
