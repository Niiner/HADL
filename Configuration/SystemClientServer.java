import links.A1;
import links.A2;

public class SystemClientServer {
	
	public static void main(String[] args) {
		Client c1 = new Client("FlorianPC");
		Server s = new Server("LaisseLibreCoursATonImagination");
		RPC rpc = new RPC("RPCConnector");
		new A1("A1", c1.getSendRequestP(), rpc.getCaller());
		new A2("A2", s.getReceiveRequestP(), rpc.getCalled());
	}

}
