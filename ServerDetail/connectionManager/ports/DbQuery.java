package connectionManager.ports;

import elements.physicalInterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class DbQuery extends SynchronPort{

	public DbQuery(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	public void receiveRequest(Object msg){
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers();
	}
}
