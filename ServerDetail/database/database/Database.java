package database.database;

import containers.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import database.ports.Query;
import database.ports.SecurityManagement;

public class Database extends Component{

	// Provided ports
	private SecurityManagement securityManagementPort;
	private Query queryPort;
	
	private static Database instance;
	private Connection connection = null;

	/**
	 * Constructor
	 * @param name Database's name
	 */
	private Database(String name){
		super(name);
		
		try {			
			Class.forName("com.mysql.jdbc.Driver"); //loads the driver
			setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/HADL", "root", "root"));

			// Create table for the database
			createTablePerson();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create Table Person
	 */
	private void createTablePerson(){
		String sqlquery = "CREATE TABLE IF NOT EXISTS Person"+
				"(id INT,"
				+ "name VARCHAR(20),"
				+ "PRIMARY KEY(numero));";
		
		try{
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sqlquery);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * Pattern Singleton
	 * @return The Database
	 */
	public static synchronized Database getInstance(){
		if(instance == null){
			instance = new Database("Database");
		}
		return instance;
	}

	/**
	 * Main method : launch database
	 * @param args
	 */
	public static void main(String args[]){
		Database.getInstance();
	}


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
}
