package securityManager.ports;

import elements.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class CredentialQuery extends SynchronPort{

	public CredentialQuery(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	

}
