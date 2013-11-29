package serverPackage.services;

import message.Message;
import serverPackage.ports.SendRequestP2;
import elements.physicalInterface.ports.Port;
import elements.physicalInterface.services.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class provided an implementation for the SendRequestS2 class
 * SendRequestS2 is the provided service of the Server
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class SendRequestS2 extends Service {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public SendRequestS2(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	/**
	 * Send the data to the associate port
	 * 
	 * @param msg
	 *            The data
	 */
	public void sendRequest(Object msg) {
		System.out
				.println("[ Calling service from Server to send the request ]");
		SendRequestP2 usedPort = null;
		for (Port port : this.getUsedPorts()) {
			if (port instanceof SendRequestP2) {
				usedPort = (SendRequestP2) port;
			}
		}
		usedPort.receiveRequest((Message) msg);
	}

}
