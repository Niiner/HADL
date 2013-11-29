package connectorPackage.roles;

import connectorPackage.glues.Glue1;
import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Caller extends Role {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Caller(String name) {
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
			if (glue instanceof Glue1) {
				((Glue1) glue).receiveRequest(msg);
			}
		}
	}
}
