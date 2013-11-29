package serverDetailPackage.database.services;

import serverDetailPackage.database.ports.SecurityManagement;
import elements.physicalInterface.ports.Port;
import elements.physicalInterface.services.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class SecurityManagementS extends Service {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public SecurityManagementS(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	/**
	 * Send a request
	 * 
	 * @param msg
	 */
	public void sendRequest(Object msg) {
		System.out
				.println("[ Calling service from Securitymanagement to send the request]");
		SecurityManagement usedPort = null;
		for (Port port : this.getUsedPorts()) {
			if (port instanceof SecurityManagement) {
				usedPort = (SecurityManagement) port;
			}
		}
		usedPort.receiveRequest(msg);
	}

}
