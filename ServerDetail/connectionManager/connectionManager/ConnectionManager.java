package connectionManager.connectionManager;
import java.util.Observable;
import java.util.Observer;

import serverDetail.ServerDetail;
import connectionManager.ports.DbQuery;
import connectionManager.ports.ExternalSocket;
import connectionManager.ports.SecurityCheck;
import connectionManager.services.DbQueryS;
import containers.Component;
import containers.Configuration;
import elements.physicalInterface.ports.Port;
import exceptions.NoSuchPortException;
import exceptions.WrongInterfacePortException;


public class ConnectionManager extends Component implements Observer{
	
	private ExternalSocket externalSocket;
	private SecurityCheck securityCheck;
	private DbQuery dbQuery;
	private DbQueryS dbQueryS;
	
	
	public ConnectionManager(Configuration config, String name) throws NoSuchPortException, WrongInterfacePortException{
		super(config, name);
		externalSocket = new ExternalSocket("ExternalSocket");
		securityCheck = new SecurityCheck("SecurityCheck");
		dbQuery = new DbQuery("DbQuery");
		dbQueryS = new DbQueryS("DbQueryS");
		this.addProvidedPort(externalSocket);
		this.addRequiredPort(securityCheck);
		this.addRequiredPort(dbQuery);
		this.dbQueryS.addPort(dbQuery);
		
		externalSocket.addObserver(this);
		dbQuery.addObserver(this);
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
	

	/**
	 * @return the dbQueryS
	 */
	public DbQueryS getDbQueryS() {
		return dbQueryS;
	}

	/**
	 * @param dbQueryS the dbQueryS to set
	 */
	public void setDbQueryS(DbQueryS dbQueryS) {
		this.dbQueryS = dbQueryS;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- ConnectionManager notify ----- ]");
		if (observable instanceof ExternalSocket){
			this.getDbQueryS().sendRequest(object);
		}
		else if (observable instanceof DbQuery){
			((ServerDetail) this.configuration).transfertData(observable, object);
		}
	}
}
