package connectorPackage.glues;

import connectorPackage.roles.Called;
import message.Message;
import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Glue1 extends Glue {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Glue1(String name) {
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
			if (role instanceof Called) {
				((Called) role).receiveRequest((Message) msg);
			}
		}
	}
}
