package ports;

import elements.ports.Port;
import elements.ports.SynchronPort;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

public class SendRequestP extends SynchronPort{
	
	public SendRequestP(String name){
		// TODO: Demander comment sont determinees les visibilites des composants ?
		super(name, InterfaceType.Provided, VisibilityType.Public);
	}
	
	public void receiveRequest(String msg){
		this.sendRequest(msg);
	}
	
	public void sendRequest(String msg){
		// TODO Quoi ki fait lui ???
	}
}
