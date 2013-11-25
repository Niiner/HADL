package connectionManager.ports;

import elements.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class DbQuery extends SynchronPort{

	public DbQuery(String name) {
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
	
	public void receiveRequest(Object msg){
		System.out.println("Entrer dans le port " + this.name);
		setChanged();
		notifyObservers();
	}
}
