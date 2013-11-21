package roles;

import elements.ports.Glue;
import elements.ports.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;
import glues.Glue1;

public class Caller extends Role{
	
	public Caller(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	public void receiveData(Object msg){
		System.out.println("On arrive dans le role caller");
		for (Glue glue : this.getGlues()){
			if (glue instanceof Glue1){
				((Glue1) glue).receiveRequest(msg);
			}
		}
	}
}
