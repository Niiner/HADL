package securityquery.roles;

import securityquery.glues.Glue3;
import elements.ports.Glue;
import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Requestor extends Role{

	public Requestor(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	public void receiveData(Object msg){
		System.out.println("[ENTRY] in role " + this.name);
		for (Glue glue : this.getGlues()){
			if (glue instanceof Glue3){
				((Glue3) glue).receiveRequest(msg);
			}
		}
	}
}
