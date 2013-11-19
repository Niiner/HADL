package securityquery.securityquery;

import securityquery.roles.Requestor;
import securityquery.roles.SecurityManagerR;
import containers.PrimitiveConnector;
import elements.ports.Role;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;

public class SecurityQuery extends PrimitiveConnector{

	public SecurityQuery(String name) throws NoSuchRoleException, WrongInterfaceRoleException {
		super(name);
		this.addProvidedRole(new SecurityManagerR("SecurityManagerR"));
		this.addRequiredRole(new Requestor("Requestor"));
	}
	
	public SecurityManagerR getSecurityManagerR(){
		SecurityManagerR p = null;
		for (Role role : providedRole){
			if (role instanceof SecurityManagerR){
				p = (SecurityManagerR) role;
			}
		}
		return p;
	}

	public Requestor getRequestor(){
		Requestor p = null;
		for (Role role : requiredRole){
			if (role instanceof Requestor){
				p = (Requestor) role;
			}
		}
		return p;
	}
	
}
