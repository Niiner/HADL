package ports;

import elements.physicalInterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class provided an implementation for the SendRequestP class SendRequestP
 * is the provided synchron port of the Client
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class SendRequestP extends SynchronPort {

	/**
	 * Constructor
	 * 
	 * @param name
	 *            the name of SendRequestP
	 */
	public SendRequestP(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	/**
	 * Allow the port to receive a request
	 * 
	 * @param msg
	 */
	public void receiveRequest(String msg) {
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers();
	}

}
