package links;

import ports.ReceiveRequestP;
import connectionManager.ports.ExternalSocket;

public class B1 extends BindingLink{
	
	/**
	 * Constructor
	 * @param name The name of the Binding link
	 * @param fromPortComp The port component
	 * @param toRoleConn The role connector
	 */
	public B1(String name, ReceiveRequestP fromPortComp, ExternalSocket toPortComp){
		super(name, fromPortComp, toPortComp);
	}
}
