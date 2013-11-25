package links;

import securityquery.roles.Requestor;
import database.ports.SecurityManagement;
import elements.physicalinterface.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

/**
 * This class provides an implementation for an attachment link A5
 * It establishes a link between the Database Component 
 * and SecurityQuery PrimitivConnector
 *
 */
public class A5 extends AttachmentLink{

	/**
	 * Constructor
	 * @param name The name of the Attachment link
	 * @param fromPortComp The port component
	 * @param toRoleConn The role connector
	 * @throws NewAttachmentNotAllowed 
	 */
	public A5(String name, SecurityManagement fromPortComp, Requestor toRoleConn) throws NewAttachmentNotAllowed {
		super(name, fromPortComp, toRoleConn);
		// TODO Auto-generated constructor stub
	}

}
