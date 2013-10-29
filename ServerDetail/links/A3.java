package links;

import sqlquery.roles.Caller;
import connectionManager.ports.DbQuery;

/**
 * This class provides an implementation for an attachment link A3
 * It establishes a link between the ConnectionManager Component 
 * and SQLQuery PrimitivConnector
 * @author Niiner
 *
 */
public class A3 extends AttachmentLink{

	/**
	 * Constructor
	 * @param name The name of the Attachment link
	 * @param fromPortComp The port component
	 * @param toRoleConn The role connector
	 */
	public A3(String name, DbQuery fromPortComp, Caller toRoleConn) {
		super(name, fromPortComp, toRoleConn);
		// TODO Auto-generated constructor stub
	}

}
