package securityquery.glues;

import securityquery.roles.SecurityManagerR;
import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;

public class Glue3 extends Glue{

	public Glue3(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void receiveRequest(Object msg){
		System.out.println("[ENTRY] in glue " + this.name);
		for (Role role : this.getRoles()){
			if (role instanceof SecurityManagerR){
				((SecurityManagerR) role).receiveRequest(msg);
			}
		}
	}

}
