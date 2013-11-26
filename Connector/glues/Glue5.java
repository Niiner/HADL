package glues;

import roles.CalledResponse;
import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Glue5 extends Glue {

	/**
	 * 
	 * @param name
	 */
	public Glue5(String name) {
		super(name);
	}

	/**
	 * 
	 * @param msg
	 */
	public void receiveRequest(Object msg) {
		System.out.println("[ENTRY] in glue " + this.name);
		for (Role role : this.getRoles()) {
			if (role instanceof CalledResponse) {
				((CalledResponse) role).receiveRequest(msg);
			}
		}
	}
}
