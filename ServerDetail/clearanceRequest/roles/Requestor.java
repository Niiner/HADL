package clearanceRequest.roles;

import clearanceRequest.glues.Glue4;
import sqlquery.glues.Glue2;
import elements.physicalInterface.glues.Glue;
import elements.physicalInterface.roles.Role;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class Requestor extends Role{
	
	public Requestor(String name){
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void receiveRequest(Object msg){
		System.out.println("[ENTRY] in role  " + this.name);
		setChanged();
		notifyObservers();
	}

}
