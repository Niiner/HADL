package connectorPackage.connector;

import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;

import java.util.Observable;
import java.util.Observer;

import message.Message;
import configurationPackage.configuration.SystemClientServer;
import connectorPackage.glues.Glue1;
import connectorPackage.glues.Glue5;
import connectorPackage.roles.Called;
import connectorPackage.roles.CalledResponse;
import connectorPackage.roles.Caller;
import connectorPackage.roles.CallerResponse;
import containers.PrimitiveConnector;

/**
 * This class provides an implementation for the RPC, a PrimitivConnector which
 * allow the communication between the server and the client
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class RPC extends PrimitiveConnector implements Observer {

	private Glue1 glue1;
	private Glue5 glue5;
	private Caller caller;
	private Called called;
	private CalledResponse calledResponse;
	private CallerResponse callerResponse;

	/**
	 * Constructor
	 * 
	 * @param config
	 * @param name
	 * @throws NoSuchRoleException
	 * @throws WrongInterfaceRoleException
	 */
	public RPC(SystemClientServer config, String name)
			throws NoSuchRoleException, WrongInterfaceRoleException {
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
	 * @return the glue1
	 */
	public Glue1 getGlue1() {
		return glue1;
	}

	/**
	 * @param glue1
	 *            the glue1 to set
	 */
	public void setGlue1(Glue1 glue1) {
		this.glue1 = glue1;
	}

	/**
	 * @return the glue5
	 */
	public Glue5 getGlue5() {
		return glue5;
	}

	/**
	 * @param glue5
	 *            the glue5 to set
	 */
	public void setGlue5(Glue5 glue5) {
		this.glue5 = glue5;
	}

	/**
	 * @return the caller
	 */
	public Caller getCaller() {
		return caller;
	}

	/**
	 * @param caller
	 *            the caller to set
	 */
	public void setCaller(Caller caller) {
		this.caller = caller;
	}

	/**
	 * @return the called
	 */
	public Called getCalled() {
		return called;
	}

	/**
	 * @param called
	 *            the called to set
	 */
	public void setCalled(Called called) {
		this.called = called;
	}

	/**
	 * @return the calledResponse
	 */
	public CalledResponse getCalledResponse() {
		return calledResponse;
	}

	/**
	 * @param calledResponse
	 *            the calledResponse to set
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
	 * @param callerResponse
	 *            the callerResponse to set
	 */
	public void setCallerResponse(CallerResponse callerResponse) {
		this.callerResponse = callerResponse;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- RPC notify ----- ]");
		if (observable instanceof Called) {
			((SystemClientServer) this.configuration).transfertData(observable,
					(Message) object);
		} else if (observable instanceof CalledResponse) {
			((SystemClientServer) this.configuration).transfertData(observable,
					(Message) object);
		}
	}
}
