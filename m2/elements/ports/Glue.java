package elements.ports;

import java.util.ArrayList;
import java.util.List;


public class Glue {
	
	protected String name;
	private List<Role> roles;
	
	/**
	 * Constructor
	 * @param name The name of the glue
	 */
	public Glue(String name){
		this.name = name;
		this.roles = new ArrayList<Role>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	/**
	 * Adding one role 
	 * @param role the {@link Role} to add
	 */
	public void addRoleBasic(Role role){
		roles.add(role);
	}
	
	/**
	 * Adding one role and adding this {@link Glue} in the {@link Role}
	 * @param role the {@link Role} to add
	 */
	public void addRole(Role role){
		roles.add(role);
		role.addGlueBasic(this);
	}
	
}
