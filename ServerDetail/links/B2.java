package links;

import ports.ReceiveResponseP;
import connectionManager.ports.SocketResponse;
import elements.links.BindingLink;
import exceptions.NewBindingNotAllowed;

public class B2 extends BindingLink{
	
	/**
	 * Constructor
	 * @param name The name of the Binding link
	 * @param fromPortComp The port component
	 * @param toRoleConn The role connector
	 * @throws NewBindingNotAllowed 
	 */
	public B2(String name, SocketResponse fromPortComp, ReceiveResponseP toPortComp) throws NewBindingNotAllowed{
		super(name, fromPortComp, toPortComp);
	}
}
