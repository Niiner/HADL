package serverDetailPackage.sqlquery.roles;

import serverDetailPackage.sqlquery.glues.Glue2;
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
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	/**
	 * Receive data
	 * 
	 * @param msg
	 */
	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in role " + this.name);
		for (Glue glue : this.getGlues()) {
			if (glue instanceof Glue2) {
				((Glue2) glue).receiveRequest(msg);
			}
		}
	}

}
