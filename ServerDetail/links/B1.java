package links;

import ports.ReceiveRequestP;
import connectionManager.ports.ExternalSocket;

public class B1 extends BindingLink{
	
	public B1(String name, ReceiveRequestP fromPortComp, ExternalSocket toPortComp){
		super(name, fromPortComp, toPortComp);
	}
}
