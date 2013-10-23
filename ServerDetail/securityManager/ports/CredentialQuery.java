package securityManager.ports;

import elements.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class CredentialQuery extends SynchronPort{

	public CredentialQuery(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	

}
