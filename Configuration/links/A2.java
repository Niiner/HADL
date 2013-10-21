package links;

import ports.ReceiveRequestP;
import roles.Called;

public class A2 extends AttachmentLink{
	
	public A2(String name, ReceiveRequestP fromPortComp, Called toRoleConn){
		super(name, fromPortComp, toRoleConn);
	}
}
