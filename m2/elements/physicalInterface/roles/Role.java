package elements.physicalInterface.roles;

import java.util.ArrayList;
import java.util.List;

import elements.physicalInterface.PhysicalInterface;
import elements.physicalInterface.glues.Glue;
import enumerations.InterfaceType;
import enumerations.VisibilityType;

/**
 * This class is an abstract class which represents a Role
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public abstract class Role extends PhysicalInterface {

	private List<Glue> glues;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            the name of the glue
	 * @param interfaceT
	 *            the {@link InterfaceType} of the role
	 * @param visibilityT
	 *            the {@link VisibilityType} of the role
	 */
	public Role(String name, InterfaceType interfaceT,
			VisibilityType visibilityT) {
		super(name, interfaceT, visibilityT);
		this.glues = new ArrayList<Glue>();
	}

	/**
	 * Called when the role must receive some data
	 * 
	 * @param msg
	 *            The data
	 */
	public void receiveData(Object msg) {
		System.out.println("Actual.toBeOverridden()");
	}

	/**
	 * @return the glues
	 */
	public List<Glue> getGlues() {
		return glues;
	}

	/**
	 * @param glues
	 *            the glues to set
	 */
	public void setGlues(List<Glue> glues) {
		this.glues = glues;
	}

	/**
	 * Adding one glue
	 * 
	 * @param glue
	 *            the {@link Glue} to add
	 */
	public void addGlueBasic(Glue glue) {
		glues.add(glue);
	}

	/**
	 * Adding one glue and adding this {@link Role} in the {@link Glue}
	 * 
	 * @param glue
	 *            the {@link Glue} to add
	 */
	public void addRole(Glue glue) {
		glues.add(glue);
		glue.addRoleBasic(this);
	}
}
