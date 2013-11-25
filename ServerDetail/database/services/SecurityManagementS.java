package database.services;

import database.ports.SecurityManagement;
import elements.ports.Port;
import elements.ports.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SecurityManagementS extends Service {
	
	public SecurityManagementS(String name){
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void sendRequest(Object msg){
		System.out.println("[ Calling service from Securitymanagement to send the request]");
		SecurityManagement usedPort = null;
		for (Port port: this.getUsedPorts()){
			if (port instanceof SecurityManagement){
				usedPort = (SecurityManagement) port;
			}
		}
		usedPort.receiveRequest(msg);
	}

}
