package connector;
import elements.ports.Role;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;
import glues.Glue1;

import java.util.Observable;
import java.util.Observer;

import roles.Called;
import roles.Caller;
import configuration.SystemClientServer;
import containers.PrimitiveConnector;


public class RPC extends PrimitiveConnector implements Observer{

	private Glue1 glue1;
	private Caller caller;
	private Called called;

	public RPC(SystemClientServer config, String name) throws NoSuchRoleException, WrongInterfaceRoleException{
		super(config, name);
		// Instantiate Role and Glue
		called = new Called("Called");
		caller = new Caller("Caller");
		glue1 = new Glue1("Glue1");
		// RPC listen the Called
		called.addObserver(this);
		// Add Role to the Glue and vice versa
		glue1.addRole(called);
		glue1.addRole(caller);
		// Add Role and Glue to RPC
		this.addProvidedRole(called);
		this.addRequiredRole(caller);
		this.glues.add(glue1);
	}

	/**
	 * @return the role {@link Caller} of {@link RPC} 
	 */
	public Caller getCaller(){
		Caller r = null;
		for (Role role : requiredRole){
			if (role instanceof Caller){
				r = (Caller) role;
			}
		}
		return r;
	}

	/**
	 * @return the role {@link Called} of {@link RPC}
	 */
	public Called getCalled(){
		Called r = null;
		for (Role role : providedRole){
			if (role instanceof Called){
				r = (Called) role;
			}
		}
		return r;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("RPC notify");
		if (observable instanceof Called){
			((SystemClientServer) this.configuration).transfertData(observable, object);
		}
	}
}
