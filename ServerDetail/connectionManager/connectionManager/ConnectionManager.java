package connectionManager.connectionManager;
import connectionManager.ports.DbQuery;
import connectionManager.ports.ExternalSocket;
import connectionManager.ports.SecurityCheck;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;


public class ConnectionManager extends Component{
	
	public ConnectionManager(Configuration config, String name){
		super(config, name);
		this.ports.add(new ExternalSocket("ExternalSocket"));
		this.ports.add(new SecurityCheck("SecurityCheck"));
		this.ports.add(new DbQuery("DbQuery"));
	}
	
	public DbQuery getDbQuery(){
		DbQuery p = null;
		for (Port port : ports){
			if (port instanceof DbQuery){
				p = (DbQuery) port;
			}
		}
		return p;
	}
	
	public SecurityCheck getSecurityCheck(){
		SecurityCheck p = null;
		for (Port port : ports){
			if (port instanceof SecurityCheck){
				p = (SecurityCheck) port;
			}
		}
		return p;
	}
	
	public ExternalSocket getExternalSocket(){
		ExternalSocket p = null;
		for (Port port : ports){
			if (port instanceof ExternalSocket){
				p = (ExternalSocket) port;
			}
		}
		return p;
	}
}
