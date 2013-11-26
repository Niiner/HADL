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

	public SecurityCheck(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers();
	}
}
