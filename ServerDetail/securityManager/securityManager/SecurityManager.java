package securityManager.securityManager;
import java.util.Observable;
import java.util.Observer;

import securityManager.ports.CredentialQuery;
import securityManager.ports.SecurityAuthorization;
import securityManager.services.SecurityAuthorizationS;
import serverDetail.ServerDetail;
import containers.Component;
import containers.Configuration;
import database.ports.SecurityManagement;
import database.services.SecurityManagementS;
import elements.ports.Port;
import exceptions.NoSuchPortException;
import exceptions.WrongInterfacePortException;

/**
 * 
 * @author Niiner-PC
 *
 */
public class SecurityManager extends Component implements Observer{
	
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
	public SecurityManager(Configuration config, String name) throws NoSuchPortException, WrongInterfacePortException{
		super(config, name);
		
		// Instanciation
		securityAuthorization = new SecurityAuthorization("SecurityAuthorization");
		securityAuthorizationS = new SecurityAuthorizationS("SecurityAuthorizationS");
		credentialQuery = new CredentialQuery("CredentialQuery");	
		
		// Add ports and services
		this.addRequiredPort(credentialQuery);
		this.addProvidedPort(securityAuthorization);	
		this.securityAuthorizationS.addPort(securityAuthorization);
		
		// Add Observers
		credentialQuery.addObserver(this);
		securityAuthorization.addObserver(this);		
		
		System.out.println(securityAuthorization);
		System.out.println(securityAuthorizationS);
		System.out.println(credentialQuery);
		
	}
	
	/**
	 * 
	 * @return
	 */
	public CredentialQuery getCredentialQuery(){
		CredentialQuery p = null;
		for (Port port : requiredPorts){
			if (port instanceof CredentialQuery){
				p = (CredentialQuery) port;
			}
		}
		return p;
	}
	
	/**
	 * 
	 * @return
	 */
	public SecurityAuthorization getSecurityAuthorization(){
		SecurityAuthorization p = null;
		for (Port port : providedPorts){
			if (port instanceof SecurityAuthorization){
				p = (SecurityAuthorization) port;
			}
		}
		return p;
	}


	/**
	 * @return the securityAuthorizationS
	 */
	public SecurityAuthorizationS getSecurityAuthorizationS() {
		return securityAuthorizationS;
	}

	/**
	 * @param securityAuthorizationS the securityAuthorizationS to set
	 */
	public void setAuthorizationS(SecurityAuthorizationS securityAuthorizationS) {
		this.securityAuthorizationS = securityAuthorizationS;
	}
	
	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- SecurityManager notify ----- ]");
		if (observable instanceof CredentialQuery){
			this.getSecurityAuthorizationS().sendRequest(object);
		}
		else if (observable instanceof SecurityAuthorization){
			((ServerDetail) this.configuration).transfertData(observable, object);
		}
	}
}
