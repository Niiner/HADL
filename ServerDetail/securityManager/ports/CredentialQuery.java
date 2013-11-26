package securityManager.ports;

import elements.physicalInterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class CredentialQuery extends SynchronPort {

	public CredentialQuery(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers();
	}
}
