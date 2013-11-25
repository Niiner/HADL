package services;

import ports.SendRequestP;
import elements.physicalinterface.ports.Port;
import elements.physicalinterface.services.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SendRequestS extends Service {
	
	public SendRequestS(String name){
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void sendRequest(String msg){
		System.out.println("Appel au service");
		SendRequestP usedPort = null;
		for (Port port: this.getUsedPorts()){
			if (port instanceof SendRequestP){
				usedPort = (SendRequestP) port;
			}
		}
		usedPort.receiveRequest(msg);
	}

}