package database.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.database.Database;
import database.model.Person;
import exceptions.NoSuchPortException;
import exceptions.WrongInterfacePortException;

/**
 * This class provides an implementation for the Person Controller
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 */
public class PersonController {

	/**
	 * Import all the Persons
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 * @throws WrongInterfacePortException
	 * @throws NoSuchPortException
	 */
	public void importPerson() throws FileNotFoundException, IOException,
			SQLException, NoSuchPortException, WrongInterfacePortException {

		Person person1 = new Person(1, "Florian");
		Person person2 = new Person(2, "Noemie");
		Person person3 = new Person(3, "Chaton");

		this.add(person1);
		this.add(person2);
		this.add(person3);
	}

	/**
	 * Add the Person to the database.
	 * 
	 * @param person
	 * @throws WrongInterfacePortException
	 * @throws NoSuchPortException
	 */
	public void add(Person person) throws SQLException, NoSuchPortException,
			WrongInterfacePortException {

		Statement s = Database.getInstance().getConnection().createStatement();
		String sqlquery = "INSERT INTO Person (id,name)" + "VALUES('"
				+ person.getId() + "', " + "'" + person.getName() + "') ";
		System.out.println(sqlquery);
		s.executeUpdate(sqlquery);
	}

	/**
	 * Returns the list of Persons in the Database
	 * 
	 * @return The list of Persons
	 * @throws SQLException
	 * @throws WrongInterfacePortException
	 * @throws NoSuchPortException
	 */
	public List<Person> getAll() throws SQLException, NoSuchPortException,
			WrongInterfacePortException {
		List<Person> persons = new ArrayList<Person>();

		Statement s = Database.getInstance().getConnection().createStatement();
		String sqlquery = "SELECT * FROM Person;";
		ResultSet res = s.executeQuery(sqlquery);

		while (res.next()) {
			persons.add(new Person(res.getInt("id"), res.getString("name")));
		}

		return persons;
	}

	/**
	 * Return a Person List matching the id entered as a parameter
	 * 
	 * @param id
	 *            The id of the Person you want to retrieve
	 * @return A Person List matching the entered id
	 * @throws SQLException
	 * @throws WrongInterfacePortException
	 * @throws NoSuchPortException
	 */
	public List<Person> getPersonById(int id) throws SQLException,
			NoSuchPortException, WrongInterfacePortException {
		List<Person> persons = new ArrayList<Person>();

		Statement s = Database.getInstance().getConnection().createStatement();
		String sqlquery = "SELECT * FROM Person " + "WHERE id=" + id + ";";
		ResultSet res = s.executeQuery(sqlquery);

		while (res.next()) {
			persons.add(new Person(res.getInt("id"), res.getString("name")));
		}

		return persons;
	}

	/**
	 * Remove all persons in the database
	 * 
	 * @throws SQLException
	 * @throws NoSuchPortException
	 * @throws WrongInterfacePortException
	 */
	public void removeAll() throws SQLException, NoSuchPortException,
			WrongInterfacePortException {
		Statement s = Database.getInstance().getConnection().createStatement();
		String sqlquery = "DELETE FROM Person;";
		s.executeUpdate(sqlquery);
	}

//	/**
//	 * Main
//	 * 
//	 * @param args
//	 * @throws SQLException
//	 * @throws NoSuchPortException
//	 * @throws WrongInterfacePortException
//	 */
//	public static void main(String args[]) throws SQLException,
//			NoSuchPortException, WrongInterfacePortException {
//		PersonController personContr = new PersonController();
//		try {
//			personContr.removeAll();
//		} catch (SQLException ex) {
//			Logger.getLogger(PersonController.class.getName()).log(
//					Level.SEVERE, null, ex);
//		} catch (NoSuchPortException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (WrongInterfacePortException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			try {
//				System.out.println("Test 4 ");
//				personContr.importPerson();
//			} catch (SQLException ex) {
//				Logger.getLogger(PersonController.class.getName()).log(
//						Level.SEVERE, null, ex);
//			} catch (NoSuchPortException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (WrongInterfacePortException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (IOException ex) {
//			Logger.getLogger(PersonController.class.getName()).log(
//					Level.SEVERE, null, ex);
//		}
//		try {
//			System.out.println(personContr.getAll().size());
//		} catch (SQLException ex) {
//			Logger.getLogger(PersonController.class.getName()).log(
//					Level.SEVERE, null, ex);
//		} catch (NoSuchPortException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (WrongInterfacePortException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// Close the database
//		Database.getInstance().close();
//	}

}
