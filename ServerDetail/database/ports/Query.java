package database.ports;

import elements.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


// Change port type ! 

public class Query extends SynchronPort {

	public Query(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}

	public void receiveData(Object msg){
		System.out.println("Entrer dans le port " + this.name);
		setChanged();
		notifyObservers();
	}
}
