package database.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import containers.Component;
import containers.Configuration;
import database.ports.Query;
import database.ports.SecurityManagement;
import elements.ports.Port;
import exceptions.NoSuchPortException;
import exceptions.WrongInterfacePortException;

public class Database extends Component{

	private static Database instance;
	private Connection connection = null;

	/**
	 * Constructor
	 * @param name Database's name
	 * @throws WrongInterfacePortException 
	 * @throws NoSuchPortException 
	 */
	private Database(Configuration config, String name) throws NoSuchPortException, WrongInterfacePortException{
		super(config, name);
		this.addProvidedPort(new SecurityManagement("SecurityManagement"));
		this.addProvidedPort(new Query("Query"));

//		try {
//			Class.forName("com.mysql.jdbc.Driver"); //loads the driver
//			this.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/hadl", "root", "root"));
//
//			// Create table for the database
//			createTablePerson();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if ( connection != null )
//				try {
//					connection.close();
//				} catch ( SQLException ignore ) {
//					/* If an error occurs during application fermeture, we just need to ignore it */
//				}
//		}
	}

	/**
	 * Create Table Person
	 */
	private void createTablePerson(){
		String sqlquery = "CREATE TABLE IF NOT EXISTS Person"+
				"(id INT,"
				+ "name VARCHAR(20),"
				+ "PRIMARY KEY(id));";

		try{
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sqlquery);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * Pattern Singleton with Configuration
	 * @return The Database
	 * @throws WrongInterfacePortException 
	 * @throws NoSuchPortException 
	 */
	public static synchronized Database getInstance(Configuration config) throws NoSuchPortException, WrongInterfacePortException{
		if(instance == null){
			instance = new Database(config, "Database");
		}
		return instance;
	}
	
	/**
	 * Pattern Singleton
	 * @return The Database
	 */
	public static synchronized Database getInstance(){
		return instance;
	}

	/**
	 * Main method : launch database
	 * @param args
	 */
//	public static void main(String args[]){
//		Database.getInstance();
//	}


	/**
	 * Set the Connection
	 * @param connection
	 */
	private void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Get the Connection
	 * @return
	 */
	public Connection getConnection(){
		return this.connection;
	}
	
	public SecurityManagement getSecurityManagement(){
		SecurityManagement p = null;
		for (Port port : providedPorts){
			if (port instanceof SecurityManagement){
				p = (SecurityManagement) port;
			}
		}
		return p;
	}
	
	public Query getQuery(){
		Query p = null;
		for (Port port : providedPorts){
			if (port instanceof Query){
				p = (Query) port;
			}
		}
		return p;
	}
}
