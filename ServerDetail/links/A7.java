package links;

import securityManager.ports.SecurityAuthorization;
import clearanceRequest.roles.Grantor;
import elements.links.AttachmentLink;

/**
 * This class provides an implementation for an attachment link A7
 * It establishes a link between the ClearanceRequest PrimitivConnector 
 * and SecurityManager Component
 * @author Niiner
 *
 */
public class A7 extends AttachmentLink{
	
	/**
	 * Constructor
	 * @param name The name of the Attachment link
	 * @param fromPortComp The port component
	 * @param toRoleConn The role connector
	 */
	public A7(String name, SecurityAuthorization fromPortComp, Grantor toRoleConn){
		super(name, fromPortComp, toRoleConn);
	}
}
