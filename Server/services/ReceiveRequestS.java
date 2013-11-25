package services;

import elements.physicalInterface.services.Service;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class provided an implementation for the ReceiveRequestS class
 * ReceiveRequestS is the required service of the Server
 *
 */
public class ReceiveRequestS extends Service {
	
	/**
	 * Constructor
	 * @param name the name of the service ReceiveRequestS
	 */
	public ReceiveRequestS(String name){
		super(name, InterfaceType.Required, VisibilityType.Public);
	}

}
