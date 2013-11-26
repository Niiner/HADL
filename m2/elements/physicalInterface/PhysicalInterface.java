package elements.physicalInterface;

import java.util.Observable;

import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * An abstract class which represents a PhysicalInterface which can be a Role, a
 * Service or a Port
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public abstract class PhysicalInterface extends Observable {

	protected VisibilityType visibilityType;
	protected InterfaceType interfaceType;
	protected String name;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            The name of the {@link PhysicalInterface}
	 * @param interfaceT
	 *            The {@link InterfaceType} of the {@link PhysicalInterface}
	 * @param visibilityT
	 *            The {@link VisibilityType} of the {@link PhysicalInterface}
	 */
	public PhysicalInterface(String name, InterfaceType interfaceT,
			VisibilityType visibilityT) {
		this.name = name;
		this.interfaceType = interfaceT;
		this.visibilityType = visibilityT;
	}

	/**
	 * @return the visibilityType
	 */
	public VisibilityType getVisibilityType() {
		return visibilityType;
	}

	/**
	 * @param visibilityType
	 *            the visibilityType to set
	 */
	public void setVisibilityType(VisibilityType visibilityType) {
		this.visibilityType = visibilityType;
	}

	/**
	 * @return the interfaceType
	 */
	public InterfaceType getInterfaceType() {
		return interfaceType;
	}

	/**
	 * @param interfaceType
	 *            the interfaceType to set
	 */
	public void setInterfaceType(InterfaceType interfaceType) {
		this.interfaceType = interfaceType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return true if the element is provided, false otherwise
	 */
	public boolean isProvided() {
		return this.interfaceType == InterfaceType.Provided;
	}

	/**
	 * @return true if the element is required, false otherwise
	 */
	public boolean isRequired() {
		return this.interfaceType == InterfaceType.Required;
	}
}