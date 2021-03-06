package serverDetailPackage.securityquery.roles;

import message.Message;
import serverDetailPackage.securityquery.glues.Glue3;
import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Requestor extends Role {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Requestor(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	/**
	 * Receive data
	 * 
	 * @param msg
	 */
	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in role " + this.name);
		for (Glue glue : this.getGlues()) {
			if (glue instanceof Glue3) {
				((Glue3) glue).receiveRequest((Message) msg);
			}
		}
	}
}
