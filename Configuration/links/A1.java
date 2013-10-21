package links;

import ports.SendRequestP;
import roles.Caller;

public class A1 extends AttachmentLink{
	
	public A1(String name, SendRequestP fromPortComp, Caller toRoleConn){
		super(name, fromPortComp, toRoleConn);
	}
}
