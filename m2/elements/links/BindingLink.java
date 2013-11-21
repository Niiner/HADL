package elements.links;

import elements.ports.Port;
import exceptions.NewBindingNotAllowed;

/**
 * This class provides an implementation for an BindingLink.
 * A Binding link allows to "plug" two ports between them.
 * @author E096393A
 *
 */
public class BindingLink extends Link{
	
	private Port fromPortConfig;
	private Port toPortComp;
	
	/**
	 * Constructor
	 * @param name The name of the BindingLink
	 * @param fromPortConfig The {@link Port} to connect with
	 * @param toPortComp The {@link Port} to connect with
	 * @throws NewBindingNotAllowed 
	 */
	public BindingLink(String name, Port fromPortConfig, Port toPortComp) throws NewBindingNotAllowed{
		super(name);
		if(fromPortConfig.isRequired() && toPortComp.isProvided()){
			this.fromPortConfig = fromPortConfig;
			this.toPortComp = toPortComp;
		}
		else{
			throw new NewBindingNotAllowed("Un BindingLink doit posséder absolument un Port Requis " +
					" et un Port Fourni");
		}
	}

	/**
	 * @return the fromPortConfig
	 */
	public Port getFromPortConfig() {
		return fromPortConfig;
	}

	/**
	 * @param fromPortConfig the fromPortConfig to set
	 */
	public void setFromPortConfig(Port fromPortConfig) {
		this.fromPortConfig = fromPortConfig;
	}

	/**
	 * @return the toPortComp
	 */
	public Port getToPortComp() {
		return toPortComp;
	}

	/**
	 * @param toPortComp the toPortComp to set
	 */
	public void setToPortComp(Port toPortComp) {
		this.toPortComp = toPortComp;
	}
	
}
