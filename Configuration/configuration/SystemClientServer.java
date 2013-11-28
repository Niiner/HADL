package configuration;

import java.util.Observable;

import links.A1;
import links.A10;
import links.A2;
import links.A9;
import message.Message;
import server.Server;
import client.Client;
import connector.RPC;
import containers.Configuration;
import elements.links.AttachmentLink;
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
public class SystemClientServer extends Configuration {

	private Client c1;
	private Server s;
	private RPC rpc;
	private A1 a1;
	private A2 a2;
	private A9 a9;
	private A10 a10;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @throws NoSuchPortException
	 * @throws WrongInterfacePortException
	 * @throws NoSuchServiceException
	 * @throws WrongInterfaceServiceException
	 * @throws NoSuchRoleException
	 * @throws WrongInterfaceRoleException
	 * @throws NewAttachmentNotAllowed
	 * @throws NewBindingNotAllowed
	 */
	public SystemClientServer(String name) throws NoSuchPortException,
			WrongInterfacePortException, NoSuchServiceException,
			WrongInterfaceServiceException, NoSuchRoleException,
			WrongInterfaceRoleException, NewAttachmentNotAllowed,
			NewBindingNotAllowed {
		super(null, name);
		c1 = new Client(this, "FlorianPC");
		s = new Server(this, "LaisseLibreCoursATonImagination");
		rpc = new RPC(this, "RPCConnector");
		a1 = new A1("A1", c1.getSendRequestP(), rpc.getCaller());
		a2 = new A2("A2", s.getReceiveRequestP(), rpc.getCalled());
		a9 = new A9("A9", s.getReceiveResponseP(), rpc.getCallerResponse());
		a10 = new A10("A10", c1.getReceiveResponseP2(), rpc.getCalledResponse());
		this.addLink(a1);
		this.addLink(a2);
		this.addLink(a9);
		this.addLink(a10);
	}


	/**
	 * @return the c1
	 */
	public Client getC1() {
		return c1;
	}


	/**
	 * @param c1 the c1 to set
	 */
	public void setC1(Client c1) {
		this.c1 = c1;
	}


	/**
	 * Transfer the data to a role or port
	 * @param observable
	 * @param object
	 */
	public void transfertData(Observable observable, Object object) {
		for (Link link : links) {
			if (link instanceof AttachmentLink
					&& ((AttachmentLink) link).getFromPortComp().equals(
							observable)) {
				((AttachmentLink) link).getToRoleConn().receiveData((Message) object);
			} else if (link instanceof AttachmentLink
					&& ((AttachmentLink) link).getToRoleConn().equals(
							observable)) {
				((AttachmentLink) link).getFromPortComp().receiveData((Message) object);
			}
		}
	}

}
