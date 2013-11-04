package connectionManager.ports;

import elements.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;


public class ExternalSocket extends SynchronPort{

	public ExternalSocket(String name) {
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	

}