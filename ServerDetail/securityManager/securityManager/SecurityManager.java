package securityManager.securityManager;
import securityManager.ports.CredentialQuery;
import securityManager.ports.SecurityAuthorization;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;
import exceptions.NoSuchPortException;
import exceptions.WrongInterfacePortException;


public class SecurityManager extends Component{
	
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
