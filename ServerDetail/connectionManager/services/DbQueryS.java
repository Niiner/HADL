package connectionManager.services;

import ports.SendRequestP;
import elements.ports.Port;
import elements.ports.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class DbQueryS extends Service {
	
	public DbQueryS(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
//	public void sendRequest(String msg){
//		System.out.println("Appel au service");
//		SendRequestP usedPort = null;
//		for (Port port: this.getUsedPorts()){
//			if (port instanceof SendRequestP){
//				usedPort = (SendRequestP) port;
//			}
//		}
//		usedPort.receiveRequest(msg);
//	}

}