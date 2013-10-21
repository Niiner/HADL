import roles.Called;
import roles.Caller;
import containers.PrimitivConnector;
import elements.Glue;
import elements.Role;


public class RPC extends PrimitivConnector{
	
	public RPC(String name){
		super(name);
		this.roles.add(new Called("Called"));
		this.roles.add(new Caller("Caller"));
		this.glues.add(new Glue("Glue1"));
	}
	
	public Caller getCaller(){
		Caller r = null;
		for (Role role : roles){
			if (role instanceof Caller){
				r = (Caller) role;
			}
		}
		return r;
	}
	
	public Called getCalled(){
		Called r = null;
		for (Role role : roles){
			if (role instanceof Called){
				r = (Called) role;
			}
		}
		return r;
	}
}
