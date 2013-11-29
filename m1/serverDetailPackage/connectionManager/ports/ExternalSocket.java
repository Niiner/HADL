package serverDetailPackage.connectionManager.ports;

import elements.physicalInterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class ExternalSocket extends SynchronPort {

	/**
	 * Constructor
	 * @param name
	 */
	public ExternalSocket(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	/**
	 * Called when the port must receive some data
	 * 
	 * @param msg
	 *            The data
	 */
	public void receiveData(Object msg) {
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers(msg);
	}

}