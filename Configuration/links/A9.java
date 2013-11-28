package links;

import ports.ReceiveResponseP;
import roles.CallerResponse;
import elements.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class A9 extends AttachmentLink {

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param fromPortComp
	 * @param callerResponse
	 * @throws NewAttachmentNotAllowed
	 */
	public A9(String name, ReceiveResponseP fromPortComp,
			CallerResponse callerResponse) throws NewAttachmentNotAllowed {
		super(name, fromPortComp, callerResponse);
	}
}