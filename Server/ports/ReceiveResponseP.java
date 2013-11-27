package ports;

import message.Message;
import database.model.Person;
import elements.physicalInterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class provided an implementation for the SendRequestP2 class
 * SendRequestP2 is the provided synchron port of the Server
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 */
public class ReceiveResponseP extends SynchronPort {

	/**
	 * Constructor
	 * 
	 * @param name
	 *            the name of the service SendRequestP2
	 */
	public ReceiveResponseP(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in port" + this.name);
		setChanged();
		notifyObservers(msg);
	}

}
