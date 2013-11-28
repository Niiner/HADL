package roles;

import elements.physicalInterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Called extends Role {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Called(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	/**
	 * Receive a request from a component
	 * 
	 * @param msg
	 */
	public void receiveRequest(Object msg) {
		System.out.println("[ENTRY] in role " + this.name);
		setChanged();
		notifyObservers(msg);
	}
}
