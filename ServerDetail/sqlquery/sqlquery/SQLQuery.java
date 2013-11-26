package sqlquery.sqlquery;

import java.util.Observable;
import java.util.Observer;

import serverDetail.ServerDetail;
import sqlquery.glues.Glue2;
import sqlquery.roles.Callee;
import sqlquery.roles.Caller;
import containers.Configuration;
import containers.PrimitiveConnector;
import elements.physicalInterface.roles.Role;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;

public class SQLQuery extends PrimitiveConnector implements Observer{

	private Caller caller;
	private Callee callee;
	private Glue2 glue2;

	/**
	 * Constructor
	 * @param name Name of the SQLQuery object
	 * @throws WrongInterfaceRoleException 
	 * @throws NoSuchRoleException 
	 */
	public SQLQuery(Configuration config, String name) throws NoSuchRoleException, WrongInterfaceRoleException {
		super(config, name);
		
		// Instantiate Role and Glue
		caller = new Caller("Caller");
		callee = new Callee("Callee");
		glue2 = new Glue2("Glue2");
		
		// Add Role to the Glue and vice versa
		glue2.addRole(callee);
		glue2.addRole(caller);
		
		// SQLQUery listen the Callee
		callee.addObserver(this);
		
		// Add Role and Glue to RPC
		this.addProvidedRole(caller);
		this.addRequiredRole(callee);
		this.glues.add(glue2);
	}

	/**
	 * @return the caller
	 */
	public Caller getCaller() {
		return caller;
	}

	/**
	 * @param caller the caller to set
	 */
	public void setCaller(Caller caller) {
		this.caller = caller;
	}

	/**
	 * @return the callee
	 */
	public Callee getCallee() {
		return callee;
	}

	/**
	 * @param callee the callee to set
	 */
	public void setCallee(Callee callee) {
		this.callee = callee;
	}

	/**
	 * @return the glue2
	 */
	public Glue2 getGlue2() {
		return glue2;
	}

	/**
	 * @param glue2 the glue2 to set
	 */
	public void setGlue2(Glue2 glue2) {
		this.glue2 = glue2;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- SqlQuery notify ----- ]");
		if (observable instanceof Callee){
			((ServerDetail) this.configuration).transfertData(observable, object);
		}
	}
}
