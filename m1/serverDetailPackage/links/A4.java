package serverDetailPackage.links;

import serverDetailPackage.database.ports.Query;
import serverDetailPackage.sqlquery.roles.Callee;
import elements.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

/**
 * This class provides an implementation for an attachment link A4 It
 * establishes a link between the Database Component and SQLQuery
 * PrimitivConnector
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class A4 extends AttachmentLink {

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
	public A4(String name, Query fromPortComp, Callee toRoleConn)
			throws NewAttachmentNotAllowed {
		super(name, fromPortComp, toRoleConn);
	}

}
