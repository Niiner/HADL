package ports;

import elements.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SendRequestP2 extends SynchronPort{
	
	public SendRequestP2(String name){
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
}
