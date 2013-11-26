package roles;

import elements.physicalInterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class CalledResponse extends Role {

	public CalledResponse(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	public void receiveRequest(Object msg) {
		System.out.println("[ENTRY] in role " + this.name);
		setChanged();
		notifyObservers();
	}
}
