package services;

import ports.SendRequestP2;
import elements.ports.Port;
import elements.ports.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SendRequestS2 extends Service {
	
	public SendRequestS2(String name){
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void sendRequest(Object msg){
		System.out.println("Appel au service fourni du server pour renvoyer la requete");
		SendRequestP2 usedPort = null;
		for (Port port: this.getUsedPorts()){
			if (port instanceof SendRequestP2){
				usedPort = (SendRequestP2) port;
			}
		}
		usedPort.receiveRequest(msg);
	}

}
