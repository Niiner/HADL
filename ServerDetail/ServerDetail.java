import links.A3;
import links.A4;
import links.A5;
import links.A6;
import links.A7;
import links.A8;
import links.B1;
import securityManager.securityManager.SecurityManager;
import securityquery.securityquery.SecurityQuery;
import sqlquery.sqlquery.SQLQuery;
import clearanceRequest.clearanceRequest.ClearanceRequest;
import connectionManager.connectionManager.ConnectionManager;
import containers.Configuration;
import database.database.Database;
import exceptions.NoSuchPortException;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceRoleException;


public class ServerDetail extends Configuration {

	private ConnectionManager connectionManager;
	private Database database;
	private SecurityManager securityManager;
	
	private SQLQuery sqlQuery;
	private SecurityQuery securityQuery;
	private ClearanceRequest clearanceRequest;
	
	private A3 a3;
	private A4 a4;
	private A5 a5;
	private A6 a6;
	private A7 a7;
	private A8 a8;
	
	public ServerDetail(String name) throws NoSuchPortException, WrongInterfacePortException, NoSuchRoleException, WrongInterfaceRoleException {
		super(name);
		connectionManager = new ConnectionManager(this, "connectionManager");
		database = Database.getInstance(this);
		securityManager = new SecurityManager(this, "securityManager");
		
		sqlQuery = new SQLQuery("SQLQuery");
		securityQuery = new SecurityQuery("SecurityQuery");
		clearanceRequest = new ClearanceRequest("clearanceRequest");
		
		a3 = new A3("A3", connectionManager.getDbQuery(), sqlQuery.getCaller());
		a4 = new A4("A4", database.getQuery(), sqlQuery.getCallee());
		a5 = new A5("A5", database.getSecurityManagement(), securityQuery.getRequestor());
		a6 = new A6("A6", securityManager.getCredentialQuery(), securityQuery.getSecurityManagerR());
		a7 = new A7("A7", securityManager.getSecurityAuthorization(), clearanceRequest.getGrantor());
		a8 = new A8("A8", connectionManager.getSecurityCheck(), clearanceRequest.getRequestor());
	}

	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}
	
	
}
