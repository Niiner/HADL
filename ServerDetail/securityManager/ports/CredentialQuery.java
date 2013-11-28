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

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public CredentialQuery(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	/**
	 * Receive data
	 * 
	 * @param msg
	 */
	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers(msg);
	}
}
