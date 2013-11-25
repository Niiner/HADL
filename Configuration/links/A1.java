package links;

import elements.physicalinterface.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;
import ports.SendRequestP;
import roles.Caller;

public class A1 extends AttachmentLink{
	
	public A1(String name, SendRequestP fromPortComp, Caller toRoleConn) throws NewAttachmentNotAllowed{
		super(name, fromPortComp, toRoleConn);
	}
}
