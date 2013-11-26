package elements.physicalInterface.services;

import java.util.ArrayList;
import java.util.List;

import elements.physicalInterface.PhysicalInterface;
import elements.physicalInterface.ports.Port;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This is an abstract class which represents a Service
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public abstract class Service extends PhysicalInterface {

	List<Port> usedPorts;

	/**
	 * 
	 * @param name
	 *            the name of the service
	 * @param interfaceT
	 *            the {@link VisibilityType} of the service
	 * @param visibilityT
	 *            the {@link VisibilityType} of the service
	 */
	public Service(String name, InterfaceType interfaceT,
			VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
		usedPorts = new ArrayList<Port>();
	}

	/**
	 * Allow to add a port to a service
	 * 
	 * @param p
	 *            the {@link Port} to add
	 */
	public void addPort(Port p) {
		this.usedPorts.add(p);
	}

	/**
	 * @return the usedPorts
	 */
	public List<Port> getUsedPorts() {
		return usedPorts;
	}

	/**
	 * @param usedPorts
	 *            the usedPorts to set
	 */
	public void setUsedPorts(List<Port> usedPorts) {
		this.usedPorts = usedPorts;
	}

}
