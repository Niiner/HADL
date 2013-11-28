package sqlquery.roles;

import elements.physicalInterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Callee extends Role {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Callee(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	/**
	 * Receive a request
	 * 
	 * @param msg
	 */
	public void receiveRequest(Object msg) {
		System.out.println("[ENTRY] in role " + this.name);
		setChanged();
		notifyObservers(msg);
	}

}
