package links;

import securityManager.ports.CredentialQuery;
import securityquery.roles.SecurityManagerR;
import elements.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

/**
 * This class provides an implementation for an attachment link A6 It
 * establishes a link between the SecurityQuery PrimitivConnector and
 * SecurityManager Component
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class A6 extends AttachmentLink {

	/**
	 * Constructor
	 * 
	 * @param name
	 *            The name of the Attachment link
	 * @param fromPortComp
	 *            The port component
	 * @param toRoleConn
	 *            The role connector
	 * @throws NewAttachmentNotAllowed
	 */
	public A6(String name, CredentialQuery fromPortComp,
			SecurityManagerR toRoleConn) throws NewAttachmentNotAllowed {
		super(name, fromPortComp, toRoleConn);
	}

}
