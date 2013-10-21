package links;

import elements.Port;

public class BindingLink extends Link{
	
	private Port fromPortConfig;
	private Port toPortComp;
	
	public BindingLink(String name, Port fromPortConfig, Port toPortComp){
		super(name);
		this.fromPortConfig = fromPortConfig;
		this.toPortComp = toPortComp;
	}
}
