package securityManager.securityManager;
import securityManager.ports.CredentialQuery;
import securityManager.ports.SecurityAuthorization;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;
import exceptions.NoSuchPortException;
import exceptions.WrongInterfacePortException;


public class SecurityManager extends Component{
	
	 // Impl�mente-t'on cette daube ?
	 // private java.lang.SecurityManager sm = new java.lang.SecurityManager();
	
	public SecurityManager(Configuration config, String name) throws NoSuchPortException, WrongInterfacePortException{
		super(config, name);
		this.addRequiredPort(new CredentialQuery("CredentialQuery"));
		this.addProvidedPort(new SecurityAuthorization("SecurityAuthorization"));
	}
	
	public CredentialQuery getCredentialQuery(){
		CredentialQuery p = null;
		for (Port port : requiredPorts){
			if (port instanceof CredentialQuery){
				p = (CredentialQuery) port;
			}
		}
		return p;
	}
	
	public SecurityAuthorization getSecurityAuthorization(){
		SecurityAuthorization p = null;
		for (Port port : providedPorts){
			if (port instanceof SecurityAuthorization){
				p = (SecurityAuthorization) port;
			}
		}
		return p;
	}
}
