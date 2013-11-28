package glues;

import message.Message;
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
	 * Constructor
	 * 
	 * @param name
	 */
	public Glue5(String name) {
		super(name);
	}

	/**
	 * Receiving the data from a role
	 * 
	 * @param msg
	 */
	public void receiveRequest(Object msg) {
		System.out.println("[ENTRY] in glue " + this.name);
		for (Role role : this.getRoles()) {
			if (role instanceof CalledResponse) {
				((CalledResponse) role).receiveRequest((Message) msg);
			}
		}
	}
}
