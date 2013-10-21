package ports;

import elements.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SendRequestP extends SynchronPort{
	
	public SendRequestP(String name){
		// TODO: Demander comment sont determinees les visibilites des composants ?
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
}
