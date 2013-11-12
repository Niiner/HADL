package ports;

import elements.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class ReceiveRequestP extends SynchronPort{
	
	public ReceiveRequestP(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}
}
