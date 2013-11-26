package links;

import ports.ReceiveRequestP;
import roles.Called;
import elements.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class A2 extends AttachmentLink {

	public A2(String name, ReceiveRequestP fromPortComp, Called toRoleConn)
			throws NewAttachmentNotAllowed {
		super(name, fromPortComp, toRoleConn);
	}
}