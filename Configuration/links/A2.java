package links;

import elements.physicalinterface.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;
import ports.ReceiveRequestP;
import roles.Called;

public class A2 extends AttachmentLink{
	
	public A2(String name, ReceiveRequestP fromPortComp, Called toRoleConn) throws NewAttachmentNotAllowed{
		super(name, fromPortComp, toRoleConn);
	}
}
