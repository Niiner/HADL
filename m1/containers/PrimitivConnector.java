package containers;

import java.util.ArrayList;
import java.util.List;

import elements.ports.Glue;
import elements.ports.Properties;
import elements.ports.Role;

public class PrimitivConnector implements IConnectorType {
	
	protected String name;
	
	protected List<Properties> properties = new ArrayList<Properties>();	
	protected List<Role> roles = new ArrayList<Role>();	
	protected List<Glue> glues = new ArrayList<Glue>();
	
	public PrimitivConnector(String name){
		this.name = name;
	}

}
