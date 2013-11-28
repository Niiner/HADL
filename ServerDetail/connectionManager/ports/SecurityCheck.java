package connectionManager.ports;

import elements.physicalInterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class SecurityCheck extends SynchronPort {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public SecurityCheck(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	/**
	 * Called when the role must receive some data
	 * 
	 * @param msg
	 *            The data
	 */
	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers(msg);
	}
}
