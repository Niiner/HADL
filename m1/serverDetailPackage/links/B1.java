package serverDetailPackage.links;

import serverDetailPackage.connectionManager.ports.ExternalSocket;
import serverPackage.ports.ReceiveRequestP;
import elements.links.BindingLink;
import exceptions.NewBindingNotAllowed;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class B1 extends BindingLink {

	/**
	 * Constructor
	 * 
	 * @param name
	 *            The name of the Binding link
	 * @param fromPortComp
	 *            The port component
	 * @param toRoleConn
	 *            The role connector
	 * @throws NewBindingNotAllowed
	 */
	public B1(String name, ReceiveRequestP fromPortComp,
			ExternalSocket toPortComp) throws NewBindingNotAllowed {
		super(name, fromPortComp, toPortComp);
	}
}
