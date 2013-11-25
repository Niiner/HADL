package services;

import ports.SendRequestP2;
import elements.physicalInterface.ports.Port;
import elements.physicalInterface.services.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SendRequestS2 extends Service {
	
	public SendRequestS2(String name){
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void sendRequest(Object msg){
		System.out.println("[ Calling service from Server to send the request ]");
		SendRequestP2 usedPort = null;
		for (Port port: this.getUsedPorts()){
			if (port instanceof SendRequestP2){
				usedPort = (SendRequestP2) port;
			}
		}
		usedPort.receiveRequest(msg);
	}

}
