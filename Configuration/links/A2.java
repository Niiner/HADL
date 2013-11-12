package links;

import elements.links.AttachmentLink;
import ports.ReceiveRequestP;
import roles.Called;

public class A2 extends AttachmentLink{
	
	public A2(String name, ReceiveRequestP fromPortComp, Called toRoleConn){
		super(name, fromPortComp, toRoleConn);
	}
}
