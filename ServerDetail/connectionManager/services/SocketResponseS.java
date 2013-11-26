package connectionManager.services;

import connectionManager.ports.SocketResponse;
import elements.physicalInterface.ports.Port;
import elements.physicalInterface.services.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class SocketResponseS extends Service {

	public SocketResponseS(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	public void sendRequest(Object msg) {
		System.out.println("[ CALLING SERVICE ]");
		SocketResponse usedPort = null;
		for (Port port : this.getUsedPorts()) {
			if (port instanceof SocketResponse) {
				usedPort = (SocketResponse) port;
			}
		}
		usedPort.receiveRequest(msg);
	}

}