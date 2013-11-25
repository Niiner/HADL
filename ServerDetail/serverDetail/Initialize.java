package serverDetail;
import database.controller.PersonController;


public class Initialize {
	 public static void main(String args[]){
	        
	        /** Initialize the Person **/
	        PersonController personController = new PersonController();
	        
	        try {
	        	System.out.println("Import en cours");
	            personController.importPerson();
	            System.out.println("Import termin? !");
	        }catch(Exception e){
	            e.printStackTrace();
	            System.err.println("Impossible d'importer les personnes");
	            System.out.println(e);
	        }
	        
	    }
	}