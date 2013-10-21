package ports;

import elements.SynchronPort;
import enumerations.InterfaceType;

public class SendRequestP extends SynchronPort{
	
	public SendRequestP(){
		super();
		this.m_interface = InterfaceType.Provided;
	}
}
