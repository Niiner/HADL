package links;

import clearanceRequest.roles.Requestor;
import connectionManager.ports.SecurityCheck;

/**
 * This class provides an implementation for an attachment link A8
 * It establishes a link between the ConnectionManager Component 
 * and ClearanceRequest PrimitivConnector
 * @author Niiner
 *
 */
public class A8 extends AttachmentLink{
	
	/**
	 * Constructor
	 * @param name The name of the Attachment link
	 * @param fromPortComp The port component
	 * @param toRoleConn The role connector
	 */
	public A8(String name, SecurityCheck fromPortComp, Requestor toRoleConn){
		super(name, fromPortComp, toRoleConn);
	}
}
