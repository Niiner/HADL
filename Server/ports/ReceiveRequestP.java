package ports;

import elements.physicalInterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class provided an implementation for the ReceiveRequestP class
 * ReceiveRequestP is the required synchron port of the Server
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class ReceiveRequestP extends SynchronPort {

	/**
	 * 
	 * Constructor
	 * 
	 * @param name
	 */
	public ReceiveRequestP(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	/**
	 * Called when the role must receive some data
	 * 
	 * @param msg
	 *            The data
	 */
	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in port" + this.name);
		setChanged();
		notifyObservers(msg);
	}
}
