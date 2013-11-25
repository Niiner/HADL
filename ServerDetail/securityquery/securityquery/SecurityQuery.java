package securityquery.securityquery;

import java.util.Observable;
import java.util.Observer;

import securityquery.glues.Glue3;
import securityquery.roles.Requestor;
import securityquery.roles.SecurityManagerR;
import serverDetail.ServerDetail;
import sqlquery.roles.Callee;
import containers.Configuration;
import containers.PrimitiveConnector;
import elements.ports.Role;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;

public class SecurityQuery extends PrimitiveConnector implements Observer{

	private SecurityManagerR securityManagerR;
	private Requestor requestor;
	private Glue3 glue3;

	public SecurityQuery(Configuration config, String name) throws NoSuchRoleException, WrongInterfaceRoleException {
		super(config, name);
		
		// Instantiate Role and Glue
		securityManagerR = new SecurityManagerR("SecurityManagerR");
		requestor = new Requestor("Requestor");
		glue3 = new Glue3("Glue3");
				
		// Add Role to the Glue and vice versa
		glue3.addRole(securityManagerR);
		glue3.addRole(requestor);
		
		securityManagerR.addObserver(this);
		
		// Add Role and Glue to RPC
		this.addProvidedRole(securityManagerR);
		this.addRequiredRole(requestor);
		this.glues.add(glue3);		
	}

	/**
	 * @returns the role {@link SecurityManagerR} of {@link SecurityQuery}
	 */
	public SecurityManagerR getSecurityManagerR(){
		SecurityManagerR p = null;
		for (Role role : providedRole){
			if (role instanceof SecurityManagerR){
				p = (SecurityManagerR) role;
			}
		}
		return p;
	}

	/**
	 * @return the role {@link Requestor} of {@link SecurityQuery}
	 */
	public Requestor getRequestor(){
		Requestor p = null;
		for (Role role : requiredRole){
			if (role instanceof Requestor){
				p = (Requestor) role;
			}
		}
		return p;
	}
	
	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- SecurityQuery notify ----- ]");
		if (observable instanceof SecurityManagerR){
			((ServerDetail) this.configuration).transfertData(observable, object);
		}
	}


}
