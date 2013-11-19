import exceptions.NewAttachmentNotAllowed;
import exceptions.NewBindingNotAllowed;
import exceptions.NoSuchPortException;
import exceptions.NoSuchRoleException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceRoleException;
import exceptions.WrongInterfaceServiceException;

public class Main {

	public static void main(String[] args) {
		SystemClientServer system;
		try {
			system = new SystemClientServer("Client-Serveur");
			system.getC1().getSendRequestS().sendRequest("Trace message");
		} catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongInterfacePortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongInterfaceServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchRoleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongInterfaceRoleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NewAttachmentNotAllowed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NewBindingNotAllowed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
