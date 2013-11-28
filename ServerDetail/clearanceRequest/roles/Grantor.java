package clearanceRequest.roles;

import message.Message;
import clearanceRequest.glues.Glue4;
import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Grantor extends Role {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Grantor(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	/**
	 * Receive data from a glue
	 * 
	 * @param msg
	 */
	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in role " + this.name);
		for (Glue glue : this.getGlues()) {
			if (glue instanceof Glue4) {
				((Glue4) glue).receiveRequest((Message) msg);
			}
		}
	}
}
