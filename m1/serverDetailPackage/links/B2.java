package serverDetailPackage.links;

import serverDetailPackage.connectionManager.ports.SocketResponse;
import serverPackage.ports.ReceiveResponseP;
import elements.links.BindingLink;
import exceptions.NewBindingNotAllowed;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class B2 extends BindingLink {

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
	public B2(String name, SocketResponse fromPortComp,
			ReceiveResponseP toPortComp) throws NewBindingNotAllowed {
		super(name, fromPortComp, toPortComp);
	}
}
