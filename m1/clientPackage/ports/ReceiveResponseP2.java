package clientPackage.ports;

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
public class ReceiveResponseP2 extends SynchronPort {

	/**
	 * Constructor
	 * 
	 * @param name
	 *            the name of SendRequestP
	 */
	public ReceiveResponseP2(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	/**
	 * Allow the port to receive a data
	 * 
	 * @param msg
	 */
	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers(msg);
	}

}
