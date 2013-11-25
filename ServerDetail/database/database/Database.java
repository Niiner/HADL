package database.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import serverDetail.ServerDetail;
import containers.Component;
import containers.Configuration;
import database.model.Person;
import database.ports.Query;
import database.ports.SecurityManagement;
import database.services.SecurityManagementS;
import elements.ports.Port;
import exceptions.NoSuchPortException;
import exceptions.WrongInterfacePortException;

public class Database extends Component implements Observer{

	private static Database instance;
	private Connection connection = null;
	
	private SecurityManagement securityManagement;
	private SecurityManagementS securityManagementS;
	private Query query;

	/**
	 * Constructor
	 * 
	 * @param name Database's name
	 * @throws WrongInterfacePortException
	 * @throws NoSuchPortException
	 */
	private Database(Configuration config, String name)
			throws NoSuchPortException, WrongInterfacePortException {
		super(config, name);
		securityManagement = new SecurityManagement("SecurityManagement");
		securityManagementS = new SecurityManagementS("SecurityManagementS");
		query = new Query("Query");
		this.addProvidedPort(securityManagement);
		this.addProvidedPort(query);
		this.securityManagementS.addPort(securityManagement);
		
		query.addObserver(this);
		securityManagement.addObserver(this);

		try {
			Class.forName("com.mysql.jdbc.Driver"); // loads the driver
			this.setConnection(DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hadl", "root", "root"));

			// Create table for the database
			createTablePerson();

		} catch (ClassNotFoundException cnfe) {
			System.out.println("Driver introuvable : ");
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("Erreur SQL : ");
			// Cf. Comment gerer les erreurs ?
		} catch (Exception e) {
			System.out.println("Autre erreur : ");
			e.printStackTrace();
		} 
	}

	/**
	 * Create Table Person
	 */
	private void createTablePerson() {
		String sqlquery = "CREATE TABLE IF NOT EXISTS Person" + "(id INT,"
				+ "name VARCHAR(20)," + "PRIMARY KEY(id));";

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sqlquery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pattern Singleton with Configuration
	 * 
	 * @return The Database
	 * @throws WrongInterfacePortException
	 * @throws NoSuchPortException
	 */
	public static synchronized Database getInstance(Configuration config)
			throws NoSuchPortException, WrongInterfacePortException {
		if (instance == null) {
			instance = new Database(config, "Database");
		}
		return instance;
	}

	/**
	 * Pattern Singleton
	 * 
	 * @return The Database
	 * @throws WrongInterfacePortException
	 * @throws NoSuchPortException
	 */
	public static synchronized Database getInstance()
			throws NoSuchPortException, WrongInterfacePortException {
		return instance;
	}
	
	/**
	 * Return a list of Persons
	 * @param message The SQL message to send to the database
	 * @return
	 * @throws SQLException
	 * @throws NoSuchPortException
	 * @throws WrongInterfacePortException
	 */
	public List<Person> receiveRequest(String message) throws SQLException, NoSuchPortException, WrongInterfacePortException{
			List<Person> persons = new ArrayList<Person>();

			Statement s = Database.getInstance().getConnection().createStatement();
			String sqlquery = message;
			ResultSet res = s.executeQuery(sqlquery);

			while(res.next()){
				persons.add(new Person(res.getInt("id"),res.getString("name")));
			}

			return persons;
	}
	
	/**
	 * Close the Database
	 * @throws SQLException 
	 */
	public void close() throws SQLException{
		this.connection.close();
	}

	/**
	 * Main method : launch database
	 * 
	 * @param args
	 * @throws WrongInterfacePortException
	 * @throws NoSuchPortException
	 */
	public static void main(String args[]) throws NoSuchPortException,
			WrongInterfacePortException {
		Database.getInstance();
	}

	/**
	 * Set the Connection
	 * 
	 * @param connection
	 */
	private void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Get the Connection
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return this.connection;
	}

	public SecurityManagement getSecurityManagement() {
		SecurityManagement p = null;
		for (Port port : providedPorts) {
			if (port instanceof SecurityManagement) {
				p = (SecurityManagement) port;
			}
		}
		return p;
	}

	public Query getQuery() {
		Query p = null;
		for (Port port : providedPorts) {
			if (port instanceof Query) {
				p = (Query) port;
			}
		}
		return p;
	}
	

	/**
	 * @return the securityManagementS
	 */
	public SecurityManagementS getSecurityManagementS() {
		return securityManagementS;
	}

	/**
	 * @param securityManagementS the securityManagementS to set
	 */
	public void setSecurityManagementS(SecurityManagementS securityManagementS) {
		this.securityManagementS = securityManagementS;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("Database notify");
		if (observable instanceof Query){
			this.getSecurityManagementS().sendRequest(object);
		}
		else if (observable instanceof SecurityManagement){
			((ServerDetail) this.configuration).transfertData(observable, object);
		}
	}
}
