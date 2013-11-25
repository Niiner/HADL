package glues;

import roles.Called;
import elements.physicalinterface.glues.Glue;
import elements.physicalinterface.roles.Role;

public class Glue1 extends Glue{
	
	public Glue1(String name){
		super(name);
	}
	
	public void receiveRequest(Object msg){
		System.out.println("Entrer dans la glue " + this.name);
		for (Role role : this.getRoles()){
			if (role instanceof Called){
				((Called) role).receiveRequest(msg);
			}
		}
	}
}
