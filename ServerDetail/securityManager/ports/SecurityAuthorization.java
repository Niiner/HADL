package securityManager.ports;

import elements.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class SecurityAuthorization extends SynchronPort{

	public SecurityAuthorization(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	

}
