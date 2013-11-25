package connectionManager.ports;

import elements.physicalinterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class DbQuery extends SynchronPort{

	public DbQuery(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	

}
