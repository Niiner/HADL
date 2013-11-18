package containers;

import java.util.ArrayList;
import java.util.List;

import elements.ports.Glue;
import elements.ports.Properties;
import elements.ports.Role;
import enumerations.InterfaceType;
import exceptions.NoSuchRoleException;
import exceptions.WrongInterfaceRoleException;



/**
 * This class provide an implementation for a PrimitivConnector
 * @author Niiner-PC
 *
 */
public class PrimitivConnector implements IConnectorType {
	
	protected String name;
	
	protected List<Properties> properties = new ArrayList<Properties>();	
	protected List<Role> providedRole = new ArrayList<Role>();
	protected List<Role> requiredRole = new ArrayList<Role>();		
	protected List<Glue> glues = new ArrayList<Glue>();
	
	/**
	 * Constructor
	 * @param name
	 */
	public PrimitivConnector(String name){
		this.name = name;
	}

	/**
	 * Adding a provided {@link Role} into the roles' list of the {@link PrimitivConnector}
	 * @param role The {@link Role} to add
	 * @throws NoSuchRoleException 
	 * @throws WrongInterfaceRoleException 
	 */
	public void addProvidedRole(Role role) throws NoSuchRoleException, WrongInterfaceRoleException{
		if(role==null){
			throw new NoSuchRoleException("Ce role n'existe pas ou n'a pas été instancié !");
		}
		
		if(role.getInterfaceType() == InterfaceType.Provided){
			this.providedRole.add(role);
		}
		else{
			throw new WrongInterfaceRoleException("Ce role dispose du mauvais type d'interface !");
		}		
	}

	/**
	 * Adding a required {@link Role} into the required roles' list of the {@link PrimitivConnector}
	 * @param role The {@link Role} to add
	 * @throws NoSuchServiceException 
	 * @throws WrongInterfaceServiceException 
	 */
	public void addRequiredRole(Role role) throws NoSuchRoleException, WrongInterfaceRoleException{
		if(role==null){
			throw new NoSuchRoleException("Ce role n'existe pas ou n'a pas été instancié !");
		}
		
		if(role.getInterfaceType() == InterfaceType.Required){
			this.requiredRole.add(role);
		}
		else{
			throw new WrongInterfaceRoleException("Ce role dispose du mauvais type d'interface !");
		}		
	}
}
