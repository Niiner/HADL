package links;

import sqlquery.roles.Callee;
import database.ports.Query;

/** 
 * This class provides an implementation for an attachment link A4
 * It establishes a link between the Database Component 
 * and SQLQuery PrimitivConnector
 * @author Niiner
 *
 */
public class A4 extends AttachmentLink{

	/**
	 * Constructor
	 * @param name The name of the Attachment link
	 * @param fromPortComp The port component
	 * @param toRoleConn The role connector
	 */
	public A4(String name, Query fromPortComp, Callee toRoleConn) {
		super(name, fromPortComp, toRoleConn);
		// TODO Auto-generated constructor stub
	}

}
