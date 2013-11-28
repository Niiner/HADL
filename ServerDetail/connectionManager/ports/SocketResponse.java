package connectionManager.ports;

import elements.physicalInterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class SocketResponse extends SynchronPort {

	/**
	 * Constructor
	 * @param name
	 */
	public SocketResponse(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	/**
	 * Allow the port to receive a request
	 * 
	 * @param msg
	 *            The message to receive
	 */
	public void receiveRequest(Object msg) {
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers(msg);
	}
}
