package links;

import ports.ReceiveRequestP;
import roles.Called;
import elements.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

public class A2 extends AttachmentLink{
	
	public A2(String name, ReceiveRequestP fromPortComp, Called toRoleConn) throws NewAttachmentNotAllowed{
		super(name, fromPortComp, toRoleConn);
	}
}