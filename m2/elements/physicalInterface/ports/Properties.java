package elements.physicalInterface.ports;

/**
 * This class provides an implementation for Properties
 * @author Niiner-PC
 *
 */
public class Properties {
	
	private String name;
	
	/**
	 * Constructor
	 * @param name the name of the properties
	 */
	public Properties(String name){
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
