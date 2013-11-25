package clearanceRequest.roles;

import clearanceRequest.glues.Glue4;
import elements.ports.Glue;
import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Grantor extends Role{
	
	public Grantor(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	public void receiveData(Object msg){
		System.out.println("[ENTRY] in role " + this.name);
		for (Glue glue : this.getGlues()){
			if (glue instanceof Glue4){
				((Glue4) glue).receiveRequest(msg);
			}
		}
	}
}
