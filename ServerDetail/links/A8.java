package links;

import clearanceRequest.roles.Requestor;
import connectionManager.ports.SecurityCheck;

public class A8 extends AttachmentLink{
	
	public A8(String name, SecurityCheck fromPortComp, Requestor toRoleConn){
		super(name, fromPortComp, toRoleConn);
	}
}
