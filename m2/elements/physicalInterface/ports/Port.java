package elements.physicalInterface.ports;

import elements.physicalInterface.PhysicalInterface;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * An abstract class which represents a port. A port can be asynchron, synchron or continu.
 * @author Niiner-PC
 *
 */
public abstract class Port extends PhysicalInterface {

	/**
	 * Constructor
	 * @param name the name of the port
	 * @param interfaceT the {@link InterfaceType} of the port
	 * @param visibilityT the {@link VisibilityType} of the port
	 */
	public Port(String name, InterfaceType interfaceT, VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
	}

	/**
	 * Allow the port to receive data
	 * @param msg the message to receive
	 */
	public void receiveData(Object msg){
		System.out.println("Actual.toBeOverridden()");
	}
}
