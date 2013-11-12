package sqlquery.sqlquery;

import sqlquery.roles.Callee;
import sqlquery.roles.Caller;
import containers.PrimitivConnector;
import elements.ports.Role;

public class SQLQuery extends PrimitivConnector{

	/**
	 * Constructor
	 * @param name Name of the SQLQuery object
	 */
	public SQLQuery(String name) {
		super(name);
	}
	
	public Caller getCaller(){
		Caller p = null;
		for (Role role : roles){
			if (role instanceof Caller){
				p = (Caller) role;
			}
		}
		return p;
	}

	public Callee getCallee(){
		Callee p = null;
		for (Role role : roles){
			if (role instanceof Callee){
				p = (Callee) role;
			}
		}
		return p;
	}
}
