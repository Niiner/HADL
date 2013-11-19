import links.A1;
import links.A2;
import containers.Configuration;
import exceptions.NewAttachmentNotAllowed;
import exceptions.NewBindingNotAllowed;
import exceptions.NoSuchPortException;
import exceptions.NoSuchRoleException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceRoleException;
import exceptions.WrongInterfaceServiceException;

public class SystemClientServer extends Configuration {
	
	private Client c1;
	private Server s;
	private RPC rpc;
	private A1 a1;
	private A2 a2;
	
	public SystemClientServer(String name) 
			throws NoSuchPortException, WrongInterfacePortException, NoSuchServiceException, 
			WrongInterfaceServiceException, NoSuchRoleException, WrongInterfaceRoleException, 
			NewAttachmentNotAllowed, NewBindingNotAllowed{
		super(name);
		c1 = new Client(this, "FlorianPC");
		s = new Server(this, "LaisseLibreCoursATonImagination");
		rpc = new RPC("RPCConnector");
		a1 = new A1("A1", c1.getSendRequestP(), rpc.getCaller());
		a2 = new A2("A2", s.getReceiveRequestP(), rpc.getCalled());
		this.links.add(a1);
		this.links.add(a2);
	}

	public Client getC1() {
		return c1;
	}

	public void setC1(Client c1) {
		this.c1 = c1;
	}

}
