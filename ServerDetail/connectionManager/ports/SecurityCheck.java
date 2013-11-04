package connectionManager.ports;

import elements.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class SecurityCheck extends SynchronPort{

	public SecurityCheck(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	

}