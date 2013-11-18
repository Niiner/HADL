package securityManager.securityManager;
import securityManager.ports.CredentialQuery;
import securityManager.ports.SecurityAuthorization;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;


public class SecurityManager extends Component{
	
	public SecurityManager(Configuration config, String name){
		super(config, name);
		this.ports.add(new CredentialQuery("CredentialQuery"));
		this.ports.add(new SecurityAuthorization("SecurityAuthorization"));
	}
	
	public CredentialQuery getCredentialQuery(){
		CredentialQuery p = null;
		for (Port port : ports){
			if (port instanceof CredentialQuery){
				p = (CredentialQuery) port;
			}
		}
		return p;
	}
	
	public SecurityAuthorization getSecurityAuthorization(){
		SecurityAuthorization p = null;
		for (Port port : ports){
			if (port instanceof SecurityAuthorization){
				p = (SecurityAuthorization) port;
			}
		}
		return p;
	}
}
