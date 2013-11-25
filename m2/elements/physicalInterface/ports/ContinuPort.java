package elements.physicalInterface.ports;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class provides an implementation for a Continu Port
 * @author Niiner-PC
 *
 */
public class ContinuPort extends Port{

	/**
	 * Constructor
	 * @param name the name of the Continu port
	 * @param interfaceT the {@link InterfaceType} of the port
	 * @param visibilityT the {@link VisibilityType} of the port
	 */
	public ContinuPort(String name, InterfaceType interfaceT, VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
	}

}
