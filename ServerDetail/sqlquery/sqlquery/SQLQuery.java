package sqlquery.sqlquery;

import sqlquery.roles.Callee;
import sqlquery.roles.Caller;
import containers.PrimitiveConnector;
import elements.ports.Role;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;

public class SQLQuery extends PrimitiveConnector{

	/**
	 * Constructor
	 * @param name Name of the SQLQuery object
	 * @throws WrongInterfaceRoleException 
	 * @throws NoSuchRoleException 
	 */
	public SQLQuery(String name) throws NoSuchRoleException, WrongInterfaceRoleException {
		super(name);
		this.addRequiredRole(new Callee("Callee"));
		this.addProvidedRole(new Caller("Caller"));
	}
	
	public Caller getCaller(){
		Caller p = null;
		for (Role role : providedRole){
			if (role instanceof Caller){
				p = (Caller) role;
			}
		}
		return p;
	}

	public Callee getCallee(){
		Callee p = null;
		for (Role role : requiredRole){
			if (role instanceof Callee){
				p = (Callee) role;
			}
		}
		return p;
	}
}
