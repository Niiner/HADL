package clearanceRequest.clearanceRequest;

import java.util.Observable;
import java.util.Observer;

import message.Message;
import serverDetail.ServerDetail;
import clearanceRequest.glues.Glue4;
import clearanceRequest.roles.Grantor;
import clearanceRequest.roles.Requestor;
import containers.Configuration;
import containers.PrimitiveConnector;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class ClearanceRequest extends PrimitiveConnector implements Observer {

	private Grantor grantor;
	private Requestor requestor;
	private Glue4 glue4;

	/**
	 * Constructor
	 * 
	 * @param config
	 * @param name
	 * @throws NoSuchRoleException
	 * @throws WrongInterfaceRoleException
	 */
	public ClearanceRequest(Configuration config, String name)
			throws NoSuchRoleException, WrongInterfaceRoleException {
		super(config, name);

		// Instantiate Role and Glue
		grantor = new Grantor("Grantor");
		requestor = new Requestor("Requestor");
		glue4 = new Glue4("Glue4");

		// Add Role to the Glue and vice versa
		glue4.addRole(grantor);
		glue4.addRole(requestor);

		// Observer
		requestor.addObserver(this);

		// Add Role and Glue to RPC
		this.addRequiredRole(grantor);
		this.addProvidedRole(requestor);
		this.glues.add(glue4);
	}

	/**
	 * @return the grantor
	 */
	public Grantor getGrantor() {
		return grantor;
	}

	/**
	 * @param grantor
	 *            the grantor to set
	 */
	public void setGrantor(Grantor grantor) {
		this.grantor = grantor;
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
	 * @return the glue4
	 */
	public Glue4 getGlue4() {
		return glue4;
	}

	/**
	 * @param glue4
	 *            the glue4 to set
	 */
	public void setGlue4(Glue4 glue4) {
		this.glue4 = glue4;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- ClearanceRequest notify ----- ]");
		if (observable instanceof Requestor) {
			((ServerDetail) this.configuration).transfertData(observable,
					(Message) object);
		}
	}
}
