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

	public SocketResponse(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	public void receiveRequest(Object msg) {
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers();
	}
}
