package securityquery.securityquery;

import java.util.Observable;
import java.util.Observer;

import message.Message;
import securityquery.glues.Glue3;
import securityquery.roles.Requestor;
import securityquery.roles.SecurityManagerR;
import serverDetail.ServerDetail;
import containers.Configuration;
import containers.PrimitiveConnector;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class SecurityQuery extends PrimitiveConnector implements Observer {

	private SecurityManagerR securityManagerR;
	private Requestor requestor;
	private Glue3 glue3;

	/**
	 * Constructor
	 * 
	 * @param config
	 * @param name
	 * @throws NoSuchRoleException
	 * @throws WrongInterfaceRoleException
	 */
	public SecurityQuery(Configuration config, String name)
			throws NoSuchRoleException, WrongInterfaceRoleException {
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
	 * @return the securityManagerR
	 */
	public SecurityManagerR getSecurityManagerR() {
		return securityManagerR;
	}

	/**
	 * @param securityManagerR
	 *            the securityManagerR to set
	 */
	public void setSecurityManagerR(SecurityManagerR securityManagerR) {
		this.securityManagerR = securityManagerR;
	}

	/**
	 * @return the requestor
	 */
	public Requestor getRequestor() {
		return requestor;
	}

	/**
	 * @param requestor
	 *            the requestor to set
	 */
	public void setRequestor(Requestor requestor) {
		this.requestor = requestor;
	}

	/**
	 * @return the glue3
	 */
	public Glue3 getGlue3() {
		return glue3;
	}

	/**
	 * @param glue3
	 *            the glue3 to set
	 */
	public void setGlue3(Glue3 glue3) {
		this.glue3 = glue3;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- SecurityQuery notify ----- ]");
		if (observable instanceof SecurityManagerR) {
			((ServerDetail) this.configuration).transfertData(observable,
					(Message) object);
		}
	}
}
