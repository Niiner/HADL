package connectionManager.connectionManager;

import java.util.Observable;
import java.util.Observer;

import message.Message;
import serverDetail.ServerDetail;
import connectionManager.ports.DbQuery;
import connectionManager.ports.ExternalSocket;
import connectionManager.ports.SecurityCheck;
import connectionManager.ports.SocketResponse;
import connectionManager.services.DbQueryS;
import connectionManager.services.SocketResponseS;
import containers.Component;
import containers.Configuration;
import database.model.Person;
import elements.physicalInterface.ports.Port;
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

	public DbQuery getDbQuery() {
		DbQuery p = null;
		for (Port port : requiredPorts) {
			if (port instanceof DbQuery) {
				p = (DbQuery) port;
			}
		}
		return p;
	}

	public SecurityCheck getSecurityCheck() {
		SecurityCheck p = null;
		for (Port port : requiredPorts) {
			if (port instanceof SecurityCheck) {
				p = (SecurityCheck) port;
			}
		}
		return p;
	}

	public ExternalSocket getExternalSocket() {
		ExternalSocket p = null;
		for (Port port : providedPorts) {
			if (port instanceof ExternalSocket) {
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
