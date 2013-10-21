package database.model;

/**
 * This class provides an implementation for a Person
 * @author Niiner
 */
public class Person {

	private int id;
	private String name;

	/**
	 * Construct a Person
	 * @param id of the Person
	 * @param name of the Person
	 */
	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}


	/**
	 * Return the identification number of the Person
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Return the name of the Person
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
}
