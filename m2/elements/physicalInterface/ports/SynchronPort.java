package elements.physicalInterface.ports;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class provides an implementation for a Synchron Port
 * @author Niiner-PC
 *
 */
public class SynchronPort extends Port{

	/**
	 * Constructor
	 * @param name the name of the Synchron port
	 * @param interfaceT the {@link InterfaceType} of the port
	 * @param visibilityT the {@link VisibilityType} of the port
	 */
	public SynchronPort(String name, InterfaceType interfaceT, VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
	}

}
