public class Main {

	public static void main(String[] args) {
		SystemClientServer system = new SystemClientServer("Client-Serveur");
		system.getC1().sendRequest("Trace Essai");
	}

}
