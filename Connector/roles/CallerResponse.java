package roles;

import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;
import glues.Glue5;

public class CallerResponse extends Role{
	
	public CallerResponse(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	public void receiveData(Object msg){
		System.out.println("[ENTRY] in role " + this.name);
		for (Glue glue : this.getGlues()){
			if (glue instanceof Glue5){
				((Glue5) glue).receiveRequest(msg);
			}
		}
	}
}
