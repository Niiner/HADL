package serverPackage.ports;

import elements.physicalInterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class provided an implementation for the SendRequestP2 class
 * SendRequestP2 is the provided synchron port of the Server
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 */
public class SendRequestP2 extends SynchronPort {

	/**
	 * Constructor
	 * 
	 * @param name
	 *            the name of the service SendRequestP2
	 */
	public SendRequestP2(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	/**
	 * Allow the service to receive a request
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
