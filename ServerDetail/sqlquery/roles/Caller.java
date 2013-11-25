package sqlquery.roles;

import sqlquery.glues.Glue2;
import elements.ports.Glue;
import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Caller extends Role{

	public Caller(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void receiveData(Object msg){
		System.out.println("On arrive dans le role caller");
		for (Glue glue : this.getGlues()){
			if (glue instanceof Glue2){
				((Glue2) glue).receiveRequest(msg);
			}
		}
	}

}
