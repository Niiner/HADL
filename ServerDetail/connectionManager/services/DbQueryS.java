package connectionManager.services;

import connectionManager.ports.DbQuery;
import elements.ports.Port;
import elements.ports.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class DbQueryS extends Service {
	
	public DbQueryS(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	public void sendRequest(Object msg){
		System.out.println("Appel au service");
		DbQuery usedPort = null;
		for (Port port: this.getUsedPorts()){
			if (port instanceof DbQuery){
				usedPort = (DbQuery) port;
			}
		}
		usedPort.receiveRequest(msg);
	}

}