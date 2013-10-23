package links;

import securityManager.ports.SecurityAuthorization;
import clearanceRequest.roles.Grantor;

public class A7 extends AttachmentLink{
	
	public A7(String name, SecurityAuthorization fromPortComp, Grantor toRoleConn){
		super(name, fromPortComp, toRoleConn);
	}
}
