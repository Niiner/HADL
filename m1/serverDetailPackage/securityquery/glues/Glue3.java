package serverDetailPackage.securityquery.glues;

import message.Message;
import serverDetailPackage.securityquery.roles.SecurityManagerR;
import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Glue3 extends Glue {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Glue3(String name) {
		super(name);
	}

	/**
	 * Receive a request
	 * 
	 * @param msg
	 */
	public void receiveRequest(Object msg) {
		System.out.println("[ENTRY] in glue " + this.name);
		for (Role role : this.getRoles()) {
			if (role instanceof SecurityManagerR) {
				((SecurityManagerR) role).receiveRequest((Message) msg);
			}
		}
	}

}
