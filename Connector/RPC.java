import roles.Called;
import roles.Caller;
import containers.PrimitiveConnector;
import elements.ports.Role;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;
import glues.Glue1;


public class RPC extends PrimitiveConnector{
	
	public RPC(String name) throws NoSuchRoleException, WrongInterfaceRoleException{
		super(name);
		this.addProvidedRole(new Called("Called"));
		this.addRequiredRole(new Caller("Caller"));
		this.glues.add(new Glue1("Glue1"));
	}
	
	public Caller getCaller(){
		Caller r = null;
		for (Role role : requiredRole){
			if (role instanceof Caller){
				r = (Caller) role;
			}
		}
		return r;
	}
	
	public Called getCalled(){
		Called r = null;
		for (Role role : providedRole){
			if (role instanceof Called){
				r = (Called) role;
			}
		}
		return r;
	}
}
