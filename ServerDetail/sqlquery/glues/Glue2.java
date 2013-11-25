package sqlquery.glues;

import sqlquery.roles.Callee;
import elements.ports.Glue;
import elements.ports.Role;

public class Glue2 extends Glue{

	public Glue2(String name) {
		super(name);
	}
	
	public void receiveRequest(Object msg){
		System.out.println("Entrer dans la glue " + this.name);
		for (Role role : this.getRoles()){
			if (role instanceof Callee){
				((Callee) role).receiveRequest(msg);
			}
		}
	}

}
