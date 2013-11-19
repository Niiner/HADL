package services;

import ports.SendRequestP;
import elements.ports.Port;
import elements.ports.Service;
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