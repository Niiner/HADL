package clearanceRequest.clearanceRequest;
import clearanceRequest.glues.Glue4;
import clearanceRequest.roles.Grantor;
import clearanceRequest.roles.Requestor;
import containers.PrimitiveConnector;
import elements.ports.Role;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;


public class ClearanceRequest extends PrimitiveConnector{
	
	public ClearanceRequest(String name) throws NoSuchRoleException, WrongInterfaceRoleException{
		super(name);
		this.addRequiredRole(new Grantor("Grantor"));
		this.addProvidedRole(new Requestor("Requestor"));
		this.glues.add(new Glue4("Glue4"));
	}
	
	public Grantor getGrantor(){
		Grantor r = null;
		for (Role role : requiredRole){
			if (role instanceof Grantor){
				r = (Grantor) role;
			}
		}
		return r;
	}
	
	public Requestor getRequestor(){
		Requestor r = null;
		for (Role role : providedRole){
			if (role instanceof Requestor){
				r = (Requestor) role;
			}
		}
		return r;
	}
}
