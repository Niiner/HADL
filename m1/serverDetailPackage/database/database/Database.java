package serverDetailPackage.database.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import message.Message;
import serverDetailPackage.database.controller.PersonController;
import serverDetailPackage.database.model.Person;
import serverDetailPackage.database.ports.Query;
import serverDetailPackage.database.ports.SecurityManagement;
import serverDetailPackage.database.services.SecurityManagementS;
import serverDetailPackage.serverDetail.ServerDetail;
import containers.Component;
import containers.Configuration;
import exceptions.NoSuchPortException;
import exceptions.WrongInterfacePortException;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Database extends Component implements Observer {

	private static Database instance;
	private Connection connection = null;

	private SecurityManagement securityManagement;
	private SecurityManagementS securityManagementS;
	private Query query;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            Database's name
	 * @throws WrongInterfacePortException
	 * @throws NoSuchPortException
	 */
	private Database(Configuration config, String name)
			throws NoSuchPortException, WrongInterfacePortException {
		super(config, name);

		PersonController persCtr = new PersonController();
		// Instanciation
		securityManagement = new SecurityManagement("SecurityManagement");
		securityManagementS = new SecurityManagementS("SecurityManagementS");
		query = new Query("Query");

		// Add ports and services
		this.addProvidedPort(securityManagement);
		this.addProvidedPort(query);
		this.securityManagementS.addPort(securityManagement);

		// Add Observers
		query.addObserver(this);
		securityManagement.addObserver(this);

		// Connection to Database
		try {
			Class.forName("com.mysql.jdbc.Driver"); // loads the driver
			this.setConnection(DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hadl", "root", "root"));

			// Create table for the database
			Statement s = connection.createStatement();
			createTablePerson();
			// Initialization
			persCtr.removeAllInitial(s);
			persCtr.importPerson(s);
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
	 * 
	 * @param object
	 *            The SQL message to send to the database
	 * @return
	 * @throws SQLException
	 * @throws NoSuchPortException
	 * @throws WrongInterfacePortException
	 */
	public List<Object> receiveRequest(Message object) throws SQLException,
			NoSuchPortException, WrongInterfacePortException {

		List<Object> persons = new ArrayList<Object>();

		Statement s = Database.getInstance().getConnection().createStatement();
		String sqlquery = object.getRequest();
		ResultSet res = s.executeQuery(sqlquery);

		while (res.next()) {
			persons.add(new Person(res.getInt("id"), res.getString("name")));
		}

		return persons;
	}

	/**
	 * Close the Database
	 * 
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		this.connection.close();
	}

	// /**
	// * Main method : launch database
	// *
	// * @param args
	// * @throws WrongInterfacePortException
	// * @throws NoSuchPortException
	// */
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

	/**
	 * @return the securityManagementS
	 */
	public SecurityManagementS getSecurityManagementS() {
		return securityManagementS;
	}

	/**
	 * @param securityManagementS
	 *            the securityManagementS to set
	 */
	public void setSecurityManagementS(SecurityManagementS securityManagementS) {
		this.securityManagementS = securityManagementS;
	}

	/**
	 * @return the securityManagement
	 */
	public SecurityManagement getSecurityManagement() {
		return securityManagement;
	}

	/**
	 * @param securityManagement
	 *            the securityManagement to set
	 */
	public void setSecurityManagement(SecurityManagement securityManagement) {
		this.securityManagement = securityManagement;
	}

	/**
	 * @return the query
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(Query query) {
		this.query = query;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- Database notify ----- ]");
		if (observable instanceof Query) {
			try {
				((Message) object).setResponse(this
						.receiveRequest((Message) object));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WrongInterfacePortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getSecurityManagementS().sendRequest(object);
		} else if (observable instanceof SecurityManagement) {
			((ServerDetail) this.configuration).transfertData(observable,
					(Message) object);
		}
	}
}
