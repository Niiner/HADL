package securityManager.securityManager;
import securityManager.ports.CredentialQuery;
import securityManager.ports.SecurityAuthorization;
import containers.Component;
import elements.Port;


public class SecurityManager extends Component{
	
	public SecurityManager(String name){
		super(name);
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
