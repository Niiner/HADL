package services;

import elements.Service;
import enumerations.InterfaceType;

public class SendRequestS extends Service {
	public InterfaceType m_interface;
	
	public SendRequestS(){
		this.m_interface = InterfaceType.Provided;
	}

}
