package serverDetailPackage.links;

import serverDetailPackage.connectionManager.ports.DbQuery;
import serverDetailPackage.sqlquery.roles.Caller;
import elements.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

/**
 * This class provides an implementation for an attachment link A3 It
 * establishes a link between the ConnectionManager Component and SQLQuery
 * PrimitivConnector
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class A3 extends AttachmentLink {

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
	public A3(String name, DbQuery fromPortComp, Caller toRoleConn)
			throws NewAttachmentNotAllowed {
		super(name, fromPortComp, toRoleConn);
	}

}
