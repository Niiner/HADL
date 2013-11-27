package services;

import message.Message;
import ports.SendRequestP;
import elements.physicalInterface.ports.Port;
import elements.physicalInterface.services.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class provided an implementation for the SendRequestS class SendRequestS
 * is the provided service of the Client
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class SendRequestS extends Service {

	/**
	 * Constructor
	 * 
	 * @param name
	 *            the name of the service SendRequestS
	 */
	public SendRequestS(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	/**
	 * Allow the service to send a request
	 * 
	 * @param msg
	 */
	public void sendRequest(Object msg) {
		System.out.println("[ Calling service from Client to send the request ]");
		SendRequestP usedPort = null;
		for (Port port : this.getUsedPorts()) {
			if (port instanceof SendRequestP) {
				usedPort = (SendRequestP) port;
			}
		}
		usedPort.receiveRequest(msg);
	}

}