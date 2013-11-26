package connector;

import elements.physicalInterface.roles.Role;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;
import glues.Glue1;
import glues.Glue5;

import java.util.Observable;
import java.util.Observer;

import roles.Called;
import roles.CalledResponse;
import roles.Caller;
import roles.CallerResponse;
import configuration.SystemClientServer;
import containers.PrimitiveConnector;

/**
 * This class provides an implementation for the RPC, a PrimitivConnector
 * which allow the communication between the server and the client
 * @author Niiner-PC
 *
 */
public class RPC extends PrimitiveConnector implements Observer{

	private Glue1 glue1;
	private Glue5 glue5;
	private Caller caller;
	private Called called;
	private CalledResponse calledResponse;
	private CallerResponse callerResponse;

	public RPC(SystemClientServer config, String name) throws NoSuchRoleException, WrongInterfaceRoleException{
		super(config, name);
		
		// Instantiate Role and Glue
		called = new Called("Called");
		caller = new Caller("Caller");
		calledResponse = new CalledResponse("CalledResponse");
		callerResponse = new CallerResponse("CallerResponse");
		glue1 = new Glue1("Glue1");
		glue5 = new Glue5("Glue5");
		
		// RPC listen the Called
		called.addObserver(this);
		calledResponse.addObserver(this);
		
		// Add Role to the Glue and vice versa
		glue1.addRole(called);
		glue1.addRole(caller);
		glue5.addRole(calledResponse);
		glue5.addRole(callerResponse);
		
		// Add Role and Glue to RPC
		this.addProvidedRole(called);
		this.addRequiredRole(caller);
		this.addProvidedRole(calledResponse);
		this.addRequiredRole(callerResponse);
		this.glues.add(glue1);
		this.glues.add(glue5);
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
	
	

	/**
	 * @return the calledResponse
	 */
	public CalledResponse getCalledResponse() {
		return calledResponse;
	}

	/**
	 * @param calledResponse the calledResponse to set
	 */
	public void setCalledResponse(CalledResponse calledResponse) {
		this.calledResponse = calledResponse;
	}

	/**
	 * @return the callerResponse
	 */
	public CallerResponse getCallerResponse() {
		return callerResponse;
	}

	/**
	 * @param callerResponse the callerResponse to set
	 */
	public void setCallerResponse(CallerResponse callerResponse) {
		this.callerResponse = callerResponse;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("RPC notify");
		if (observable instanceof Called){
			((SystemClientServer) this.configuration).transfertData(observable, object);
		}
		else if (observable instanceof CalledResponse){
			((SystemClientServer) this.configuration).transfertData(observable, object);
		}
	}
}
