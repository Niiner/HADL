package connectionManager.ports;

import elements.physicalinterface.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class ExternalSocket extends SynchronPort{

	public ExternalSocket(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void receiveData(Object msg){
		System.out.println("Entrer dans le port " + this.name);
		setChanged();
		notifyObservers();
	}
	
}
