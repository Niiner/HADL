package connectionManager.ports;

import elements.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class ExternalSocket extends SynchronPort{

	public ExternalSocket(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void receiveData(Object msg){
		System.out.println("[ENTRY] in port " + this.name);
		setChanged();
		notifyObservers();
	}
	
}