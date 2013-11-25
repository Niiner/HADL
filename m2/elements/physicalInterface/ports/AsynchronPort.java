package elements.physicalInterface.ports;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class provides an implementation for an Asynchron Port
 * @author Niiner-PC
 *
 */
public class AsynchronPort extends Port{

	/**
	 * Constructor
	 * @param name the name of the asynchron port
	 * @param interfaceT the {@link InterfaceType} of the port
	 * @param visibilityT the {@link VisibilityType} of the port
	 */
	public AsynchronPort(String name, InterfaceType interfaceT, VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
	}

}
