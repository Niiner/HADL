package roles;

import message.Message;
import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;
import glues.Glue5;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class CallerResponse extends Role {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public CallerResponse(String name) {
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
			if (glue instanceof Glue5) {
				((Glue5) glue).receiveRequest((Message) msg);
			}
		}
	}
}
