package links;

import ports.SendRequestP;
import roles.Caller;
import elements.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class A1 extends AttachmentLink {

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param fromPortComp
	 * @param toRoleConn
	 * @throws NewAttachmentNotAllowed
	 */
	public A1(String name, SendRequestP fromPortComp, Caller toRoleConn)
			throws NewAttachmentNotAllowed {
		super(name, fromPortComp, toRoleConn);
	}
}
