package links;

import ports.ReceiveResponseP;
import roles.Caller;
import roles.CallerResponse;
import elements.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

public class A9 extends AttachmentLink{
	
	public A9(String name, ReceiveResponseP fromPortComp, CallerResponse callerResponse) throws NewAttachmentNotAllowed{
		super(name, fromPortComp, callerResponse);
	}
}