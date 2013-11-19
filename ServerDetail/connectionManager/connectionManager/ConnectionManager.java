package connectionManager.connectionManager;
import connectionManager.ports.DbQuery;
import connectionManager.ports.ExternalSocket;
import connectionManager.ports.SecurityCheck;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;
import exceptions.NoSuchPortException;
import exceptions.WrongInterfacePortException;


public class ConnectionManager extends Component{
	
	public ConnectionManager(Configuration config, String name) throws NoSuchPortException, WrongInterfacePortException{
		super(config, name);
		this.addProvidedPort(new ExternalSocket("ExternalSocket"));
		this.addRequiredPort(new SecurityCheck("SecurityCheck"));
		this.addRequiredPort(new DbQuery("DbQuery"));
	}
	
	public DbQuery getDbQuery(){
		DbQuery p = null;
		for (Port port : requiredPorts){
			if (port instanceof DbQuery){
				p = (DbQuery) port;
			}
		}
		return p;
	}
	
	public SecurityCheck getSecurityCheck(){
		SecurityCheck p = null;
		for (Port port : requiredPorts){
			if (port instanceof SecurityCheck){
				p = (SecurityCheck) port;
			}
		}
		return p;
	}
	
	public ExternalSocket getExternalSocket(){
		ExternalSocket p = null;
		for (Port port : providedPorts){
			if (port instanceof ExternalSocket){
				p = (ExternalSocket) port;
			}
		}
		return p;
	}
}
