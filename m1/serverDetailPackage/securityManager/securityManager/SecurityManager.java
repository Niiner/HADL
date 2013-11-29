package serverDetailPackage.securityManager.securityManager;

import java.util.Observable;
import java.util.Observer;

import message.Message;
import serverDetailPackage.securityManager.ports.CredentialQuery;
import serverDetailPackage.securityManager.ports.SecurityAuthorization;
import serverDetailPackage.securityManager.services.SecurityAuthorizationS;
import serverDetailPackage.serverDetail.ServerDetail;
import containers.Component;
import containers.Configuration;
import exceptions.NoSuchPortException;
import exceptions.WrongInterfacePortException;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class SecurityManager extends Component implements Observer {

	private SecurityAuthorization securityAuthorization;
	private SecurityAuthorizationS securityAuthorizationS;
	private CredentialQuery credentialQuery;

	/**
	 * 
	 * @param config
	 * @param name
	 * @throws NoSuchPortException
	 * @throws WrongInterfacePortException
	 */
	public SecurityManager(Configuration config, String name)
			throws NoSuchPortException, WrongInterfacePortException {
		super(config, name);

		// Instanciation
		securityAuthorization = new SecurityAuthorization(
				"SecurityAuthorization");
		securityAuthorizationS = new SecurityAuthorizationS(
				"SecurityAuthorizationS");
		credentialQuery = new CredentialQuery("CredentialQuery");

		// Add ports and services
		this.addRequiredPort(credentialQuery);
		this.addProvidedPort(securityAuthorization);
		this.securityAuthorizationS.addPort(securityAuthorization);

		// Add Observers
		credentialQuery.addObserver(this);
		securityAuthorization.addObserver(this);
	}

	/**
	 * @return the securityAuthorization
	 */
	public SecurityAuthorization getSecurityAuthorization() {
		return securityAuthorization;
	}

	/**
	 * @param securityAuthorization
	 *            the securityAuthorization to set
	 */
	public void setSecurityAuthorization(
			SecurityAuthorization securityAuthorization) {
		this.securityAuthorization = securityAuthorization;
	}

	/**
	 * @return the credentialQuery
	 */
	public CredentialQuery getCredentialQuery() {
		return credentialQuery;
	}

	/**
	 * @param credentialQuery
	 *            the credentialQuery to set
	 */
	public void setCredentialQuery(CredentialQuery credentialQuery) {
		this.credentialQuery = credentialQuery;
	}

	/**
	 * @return the securityAuthorizationS
	 */
	public SecurityAuthorizationS getSecurityAuthorizationS() {
		return securityAuthorizationS;
	}

	/**
	 * @param securityAuthorizationS
	 *            the securityAuthorizationS to set
	 */
	public void setAuthorizationS(SecurityAuthorizationS securityAuthorizationS) {
		this.securityAuthorizationS = securityAuthorizationS;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- SecurityManager notify ----- ]");
		if (observable instanceof CredentialQuery) {
			this.getSecurityAuthorizationS().sendRequest((Message) object);
		} else if (observable instanceof SecurityAuthorization) {
			((ServerDetail) this.configuration).transfertData(observable,
					(Message) object);
		}
	}
}
