package links;

import ports.ReceiveResponseP2;
import roles.CalledResponse;
import elements.links.AttachmentLink;
import exceptions.NewAttachmentNotAllowed;

public class A10 extends AttachmentLink{
	
	public A10(String name, ReceiveResponseP2 fromPortComp, CalledResponse calledResponse) throws NewAttachmentNotAllowed{
		super(name, fromPortComp, calledResponse);
	}
}