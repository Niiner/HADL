package serverDetailPackage.connectionManager.services;

import message.Message;
import serverDetailPackage.connectionManager.ports.SocketResponse;
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

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public SocketResponseS(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

	/**
	 * Allow the service to send a request
	 * 
	 * @param msg
	 *            The message to receive
	 */
	public void sendRequest(Object msg) {
		System.out.println("[ CALLING SERVICE ]");
		SocketResponse usedPort = null;
		for (Port port : this.getUsedPorts()) {
			if (port instanceof SocketResponse) {
				usedPort = (SocketResponse) port;
			}
		}
		usedPort.receiveRequest((Message) msg);
	}

}