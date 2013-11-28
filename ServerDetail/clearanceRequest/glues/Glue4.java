package clearanceRequest.glues;

import message.Message;
import clearanceRequest.roles.Requestor;
import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Glue4 extends Glue {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Glue4(String name) {
		super(name);
	}

	/**
	 * 
	 * Receiving the data from a role
	 * 
	 * @param msg
	 */
	public void receiveRequest(Object msg) {
		System.out.println("[ENTRY] in glue " + this.name);
		for (Role role : this.getRoles()) {
			if (role instanceof Requestor) {
				((Requestor) role).receiveRequest((Message) msg);
			}
		}
	}
}