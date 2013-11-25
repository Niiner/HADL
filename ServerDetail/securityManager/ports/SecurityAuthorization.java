package securityManager.ports;

import elements.physicalinterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class SecurityAuthorization extends SynchronPort{

	public SecurityAuthorization(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	

}
