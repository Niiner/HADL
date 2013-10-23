import links.A7;
import links.A8;
import links.B1;
import securityManager.securityManager.SecurityManager;
import clearanceRequest.clearanceRequest.ClearanceRequest;
import connectionManager.connectionManager.ConnectionManager;
import containers.Configuration;
import database.database.Database;


public class ServerDetail extends Configuration {

	private ConnectionManager connectionManager;
	private Database database;
	private SecurityManager securityManager;
	
//	private SQLQuery sqlQuery;
//	private SecurityQuery securityQuery;
	private ClearanceRequest clearanceRequest;
	
//	private A3 a3;
//	private A4 a4;
//	private A5 a5;
//	private A6 a6;
	private A7 a7;
	private A8 a8;
	private B1 b1;
	
	public ServerDetail(String name) {
		super(name);
		connectionManager = new ConnectionManager("connectionManager");
//		database = new Database("database");
		securityManager = new SecurityManager("securityManager");
		
//		sqlQuery = new SQLQuery();
//		securityQuery = new SecurityQuery();
		clearanceRequest = new ClearanceRequest("clearanceRequest");
		
//		a3 = new A3();
//		a4 = new A4();
//		a5 = new A5();
//		a6 = new A6();
		a7 = new A7("A7", securityManager.getSecurityAuthorization(), clearanceRequest.getGrantor());
		a8 = new A8("A8", connectionManager.getSecurityCheck(), clearanceRequest.getRequestor());
		
		// TODO:Comment on fait pour faire le lien avec Server
//		b1 = new B1("B1", /*Mettre ici la récupération de RequestP de Server*/ , connectionManager.getExternalSocket());
		
	}
}
