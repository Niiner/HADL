package serverDetailPackage.serverDetail;

import java.util.Observable;

import message.Message;
import serverDetailPackage.clearanceRequest.clearanceRequest.ClearanceRequest;
import serverDetailPackage.connectionManager.connectionManager.ConnectionManager;
import serverDetailPackage.database.database.Database;
import serverDetailPackage.links.A3;
import serverDetailPackage.links.A4;
import serverDetailPackage.links.A5;
import serverDetailPackage.links.A6;
import serverDetailPackage.links.A7;
import serverDetailPackage.links.A8;
import serverDetailPackage.links.B1;
import serverDetailPackage.links.B2;
import serverDetailPackage.securityManager.securityManager.SecurityManager;
import serverDetailPackage.securityquery.securityquery.SecurityQuery;
import serverDetailPackage.sqlquery.sqlquery.SQLQuery;
import serverPackage.ports.ReceiveRequestP;
import serverPackage.ports.SendRequestP2;
import serverPackage.server.Server;
import containers.Component;
import containers.Configuration;
import elements.links.AttachmentLink;
import elements.links.BindingLink;
import elements.links.Link;
import exceptions.NewAttachmentNotAllowed;
import exceptions.NewBindingNotAllowed;
import exceptions.NoSuchPortException;
import exceptions.NoSuchRoleException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceRoleException;
import exceptions.WrongInterfaceServiceException;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
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
	private B1 b1;
	private B2 b2;

	/**
	 * 
	 * Constructor
	 * 
	 * @param parent
	 * @param name
	 * @throws NoSuchPortException
	 * @throws WrongInterfacePortException
	 * @throws NoSuchRoleException
	 * @throws WrongInterfaceRoleException
	 * @throws NewAttachmentNotAllowed
	 * @throws NewBindingNotAllowed
	 * @throws NoSuchServiceException
	 * @throws WrongInterfaceServiceException
	 */
	public ServerDetail(Component parent, String name)
			throws NoSuchPortException, WrongInterfacePortException,
			NoSuchRoleException, WrongInterfaceRoleException,
			NewAttachmentNotAllowed, NewBindingNotAllowed,
			NoSuchServiceException, WrongInterfaceServiceException {

		super(parent, name);
		connectionManager = new ConnectionManager(this, "connectionManager");
		database = Database.getInstance(this);
		securityManager = new SecurityManager(this, "securityManager");

		sqlQuery = new SQLQuery(this, "SQLQuery");
		securityQuery = new SecurityQuery(this, "SecurityQuery");
		clearanceRequest = new ClearanceRequest(this, "clearanceRequest");

		a3 = new A3("A3", connectionManager.getDbQuery(), sqlQuery.getCaller());
		a4 = new A4("A4", database.getQuery(), sqlQuery.getCallee());
		a5 = new A5("A5", database.getSecurityManagement(),
				securityQuery.getRequestor());
		a6 = new A6("A6", securityManager.getCredentialQuery(),
				securityQuery.getSecurityManagerR());
		a7 = new A7("A7", securityManager.getSecurityAuthorization(),
				clearanceRequest.getGrantor());
		a8 = new A8("A8", connectionManager.getSecurityCheck(),
				clearanceRequest.getRequestor());
		b1 = new B1("B1", ((Server) parent).getReceiveRequestP(), this
				.getConnectionManager().getExternalSocket());
		b2 = new B2("B2", this.getConnectionManager().getSocketResponse(),
				((Server) parent).getReceiveResponseP());

		this.addLink(a3);
		this.addLink(a4);
		this.addLink(a5);
		this.addLink(a6);
		this.addLink(a7);
		this.addLink(a8);
		this.addLink(b1);
		this.addLink(b2);
	}

	/**
	 * @return the connectionManager
	 */
	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	/**
	 * @param connectionManager
	 *            the connectionManager to set
	 */
	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	public void transfertData(Observable observable, Object object) {
		for (Link link : links) {
			if (observable instanceof SendRequestP2
					&& link instanceof BindingLink
					&& ((BindingLink) link).getFromPortConfig() instanceof ReceiveRequestP) {
				((BindingLink) link).getToPortComp().receiveData(object);
			} else if (link instanceof AttachmentLink
					&& ((AttachmentLink) link).getFromPortComp().equals(
							observable)) {
				((AttachmentLink) link).getToRoleConn().receiveData(
						(Message) object);
			} else if (link instanceof AttachmentLink
					&& ((AttachmentLink) link).getToRoleConn().equals(
							observable)) {
				((AttachmentLink) link).getFromPortComp().receiveData(object);
			} else if (link instanceof BindingLink
					&& ((BindingLink) link).getFromPortConfig().equals(
							observable)) {
				((BindingLink) link).getToPortComp().receiveData(object);
			}
		}
	}

}
