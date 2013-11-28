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

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param fromPortComp
	 * @param toRoleConn
	 * @throws NewAttachmentNotAllowed
	 */
	public A2(String name, ReceiveRequestP fromPortComp, Called toRoleConn)
			throws NewAttachmentNotAllowed {
		super(name, fromPortComp, toRoleConn);
	}
}