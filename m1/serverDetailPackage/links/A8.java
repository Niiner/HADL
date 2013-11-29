package serverDetailPackage.links;

import serverDetailPackage.clearanceRequest.roles.Requestor;
import serverDetailPackage.connectionManager.ports.SecurityCheck;
import elements.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

/**
 * This class provides an implementation for an attachment link A8 It
 * establishes a link between the ConnectionManager Component and
 * ClearanceRequest PrimitivConnector
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class A8 extends AttachmentLink {

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
	public A8(String name, SecurityCheck fromPortComp, Requestor toRoleConn)
			throws NewAttachmentNotAllowed {
		super(name, fromPortComp, toRoleConn);
	}
}
