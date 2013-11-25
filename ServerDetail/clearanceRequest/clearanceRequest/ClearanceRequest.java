package clearanceRequest.clearanceRequest;
import clearanceRequest.glues.Glue4;
import clearanceRequest.roles.Grantor;
import clearanceRequest.roles.Requestor;
import containers.Configuration;
import containers.PrimitiveConnector;
import elements.physicalinterface.roles.Role;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;


public class ClearanceRequest extends PrimitiveConnector{

	private Grantor grantor;
	private Requestor requestor;
	private Glue4 glue4;

	public ClearanceRequest(Configuration config, String name) throws NoSuchRoleException, WrongInterfaceRoleException{
		super(config, name);
		// Instantiate Role and Glue
		grantor = new Grantor("Grantor");
		requestor = new Requestor("Requestor");
		glue4 = new Glue4("Glue4");
		// Add Role to the Glue and vice versa
		glue4.addRole(grantor);
		glue4.addRole(requestor);
		// Add Role and Glue to RPC
		this.addRequiredRole(grantor);
		this.addProvidedRole(requestor);
		this.glues.add(glue4);
	}

	/**
	 * @return the role {@link Grantor} of {@link ClearanceRequest}
	 */
	public Grantor getGrantor(){
		Grantor r = null;
		for (Role role : requiredRole){
			if (role instanceof Grantor){
				r = (Grantor) role;
			}
		}
		return r;
	}

	/**
	 * @return the role {@link Requestor} of {@link ClearanceRequest}
	 */
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
