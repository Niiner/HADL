package serverDetailPackage.connectionManager.connectionManager;

import java.util.Observable;
import java.util.Observer;

import message.Message;
import serverDetailPackage.connectionManager.ports.DbQuery;
import serverDetailPackage.connectionManager.ports.ExternalSocket;
import serverDetailPackage.connectionManager.ports.SecurityCheck;
import serverDetailPackage.connectionManager.ports.SocketResponse;
import serverDetailPackage.connectionManager.services.DbQueryS;
import serverDetailPackage.connectionManager.services.SocketResponseS;
import serverDetailPackage.serverDetail.ServerDetail;
import containers.Component;
import containers.Configuration;
import exceptions.NoSuchPortException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceServiceException;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class ConnectionManager extends Component implements Observer {

	private ExternalSocket externalSocket;
	private SecurityCheck securityCheck;
	private SocketResponse socketResponse;
	private SocketResponseS socketResponseS;
	private DbQuery dbQuery;
	private DbQueryS dbQueryS;

	/**
	 * Constructor
	 * 
	 * @param config
	 * @param name
	 * @throws NoSuchPortException
	 * @throws WrongInterfacePortException
	 * @throws NoSuchServiceException
	 * @throws WrongInterfaceServiceException
	 */
	public ConnectionManager(Configuration config, String name)
			throws NoSuchPortException, WrongInterfacePortException,
			NoSuchServiceException, WrongInterfaceServiceException {
		super(config, name);
		externalSocket = new ExternalSocket("ExternalSocket");
		securityCheck = new SecurityCheck("SecurityCheck");
		dbQuery = new DbQuery("DbQuery");
		dbQueryS = new DbQueryS("DbQueryS");
		socketResponse = new SocketResponse("SocketResponse");
		socketResponseS = new SocketResponseS("SocketResponseS");
		this.addProvidedPort(externalSocket);
		this.addRequiredPort(securityCheck);
		this.addRequiredPort(dbQuery);
		this.addRequiredService(dbQueryS);
		this.addRequiredPort(socketResponse);
		this.addRequiredService(socketResponseS);
		this.dbQueryS.addPort(dbQuery);
		this.socketResponseS.addPort(socketResponse);

		externalSocket.addObserver(this);
		dbQuery.addObserver(this);
		securityCheck.addObserver(this);
		socketResponse.addObserver(this);
	}

	/**
	 * @return the externalSocket
	 */
	public ExternalSocket getExternalSocket() {
		return externalSocket;
	}

	/**
	 * @param externalSocket
	 *            the externalSocket to set
	 */
	public void setExternalSocket(ExternalSocket externalSocket) {
		this.externalSocket = externalSocket;
	}

	/**
	 * @return the securityCheck
	 */
	public SecurityCheck getSecurityCheck() {
		return securityCheck;
	}

	/**
	 * @param securityCheck
	 *            the securityCheck to set
	 */
	public void setSecurityCheck(SecurityCheck securityCheck) {
		this.securityCheck = securityCheck;
	}

	/**
	 * @return the dbQuery
	 */
	public DbQuery getDbQuery() {
		return dbQuery;
	}

	/**
	 * @param dbQuery
	 *            the dbQuery to set
	 */
	public void setDbQuery(DbQuery dbQuery) {
		this.dbQuery = dbQuery;
	}

	/**
	 * @return the dbQueryS
	 */
	public DbQueryS getDbQueryS() {
		return dbQueryS;
	}

	/**
	 * @param dbQueryS
	 *            the dbQueryS to set
	 */
	public void setDbQueryS(DbQueryS dbQueryS) {
		this.dbQueryS = dbQueryS;
	}

	/**
	 * @return the socketResponseS
	 */
	public SocketResponseS getSocketResponseS() {
		return socketResponseS;
	}

	/**
	 * @param socketResponseS
	 *            the socketResponseS to set
	 */
	public void setSocketResponseS(SocketResponseS socketResponseS) {
		this.socketResponseS = socketResponseS;
	}

	/**
	 * @return the socketResponse
	 */
	public SocketResponse getSocketResponse() {
		return socketResponse;
	}

	/**
	 * @param socketResponse
	 *            the socketResponse to set
	 */
	public void setSocketResponse(SocketResponse socketResponse) {
		this.socketResponse = socketResponse;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- ConnectionManager notify ----- ]");
		if (observable instanceof ExternalSocket) {
			this.getDbQueryS().sendRequest(object);
		} else if (observable instanceof DbQuery) {
			((ServerDetail) this.configuration).transfertData(observable,
					(Message) object);
		} else if (observable instanceof SecurityCheck) {
			this.getSocketResponseS().sendRequest(object);
		} else if (observable instanceof SocketResponse) {
			((ServerDetail) this.configuration).transfertData(observable,
					(Message) object);
		}
	}
}
