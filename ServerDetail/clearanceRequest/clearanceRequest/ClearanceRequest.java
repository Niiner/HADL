package clearanceRequest.clearanceRequest;
import clearanceRequest.glues.Glue4;
import clearanceRequest.roles.Grantor;
import clearanceRequest.roles.Requestor;
import containers.PrimitivConnector;
import elements.ports.Role;


public class ClearanceRequest extends PrimitivConnector{
	
	public ClearanceRequest(String name){
		super(name);
		this.roles.add(new Grantor("Grantor"));
		this.roles.add(new Requestor("Requestor"));
		this.glues.add(new Glue4("Glue4"));
	}
	
	public Grantor getGrantor(){
		Grantor r = null;
		for (Role role : roles){
			if (role instanceof Grantor){
				r = (Grantor) role;
			}
		}
		return r;
	}
	
	public Requestor getRequestor(){
		Requestor r = null;
		for (Role role : roles){
			if (role instanceof Requestor){
				r = (Requestor) role;
			}
		}
		return r;
	}
}
