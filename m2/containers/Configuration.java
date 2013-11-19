package containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import elements.links.AttachmentLink;
import elements.links.Link;
import elements.ports.Port;
import elements.ports.Properties;
import elements.ports.Role;
import elements.ports.Service;
import enumerations.InterfaceType;
import exceptions.NoSuchPortException;
import exceptions.NoSuchRoleException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceRoleException;
import exceptions.WrongInterfaceServiceException;

/**
 * This class provides an implementation for a Configuration.
 * A configuration is composed by Ports/Roles and Services which can be required or provided.
 * It is also composed by Components and Connectors
 * @author E096393A
 *
 */
public class Configuration implements IComponentType, IConnectorType {
	
	protected List<IComponentType> childComponent = new ArrayList<IComponentType>();
	protected List<IConnectorType> childConnector = new ArrayList<IConnectorType>();
	
	protected String name;
	
	protected List<Properties> properties = new ArrayList<Properties>();	
	protected List<Port> providedPorts = new ArrayList<Port>();
	protected List<Port> requiredPorts = new ArrayList<Port>();
	protected List<Service> providedServices = new ArrayList<Service>();
	protected List<Service> requiredServices = new ArrayList<Service>();	
	protected List<Role> providedRole = new ArrayList<Role>();
	protected List<Role> requiredRole = new ArrayList<Role>();	
	protected List<Link> links = new ArrayList<Link>();
	
	/**
	 * Constructor
	 * @param name The name of the configuration
	 */
	public Configuration(String name){
		this.name = name;
	}

	/**
	 * Adding a provided {@link Port} into the provided ports' list of the {@link Configuration}
	 * @param port The {@link Port} to add
	 * @throws NoSuchPortException 
	 * @throws WrongInterfacePortException 
	 */
	public void addProvidedPort(Port port) throws NoSuchPortException, WrongInterfacePortException{
		if(port==null){
			throw new NoSuchPortException("Le port " + port.getName() + " n'existe pas ou n'a pas été instancié!");
		}
		
		if(port.getInterfaceType() == InterfaceType.Provided){
			this.providedPorts.add(port);
		}
		else{
			throw new WrongInterfacePortException("Le port " + port.getName() + " doit disposer d'une interface de type Provided !");
		}
		
	}
	
	/**
	 * Adding a required {@link Port} into the required ports' list of the {@link Configuration}
	 * @param port The {@link Port} to add
	 * @throws NoSuchPortException 
	 * @throws WrongInterfacePortException 
	 */
	public void addRequiredPort(Port port) throws NoSuchPortException, WrongInterfacePortException{
		if(port==null){
			throw new NoSuchPortException("Le port " + port.getName() + " n'existe pas ou n'a pas été instancié!");
		}
		
		if(port.getInterfaceType() == InterfaceType.Required){
			this.requiredPorts.add(port);
		}
		else{
			throw new WrongInterfacePortException("Le port " + port.getName() + " doit disposer d'une interface de type Required !");
		}		
	}
	
	/**
	 * Adding a provided {@link Service} into the ports' list of the {@link Configuration}
	 * @param port The {@link Service} to add
	 * @throws NoSuchServiceException 
	 * @throws WrongInterfaceServiceException 
	 */
	public void addProvidedService(Service service) throws NoSuchServiceException, WrongInterfaceServiceException{
		if(service==null){
			throw new NoSuchServiceException("Le service " + service.getName() + " n'existe pas ou n'a pas été instancié !");
		}
		
		if(service.getInterfaceType() == InterfaceType.Provided){
			this.providedServices.add(service);
		}
		else{
			throw new WrongInterfaceServiceException("Le service " + service.getName() + " doit disposer d'une interface de type Provided !");
		}		
	}

	/**
	 * Adding a required {@link Service} into the required ports' list of the {@link Configuration}
	 * @param port The {@link Service} to add
	 * @throws NoSuchServiceException 
	 * @throws WrongInterfaceServiceException 
	 */
	public void addRequiredService(Service service) throws NoSuchServiceException, WrongInterfaceServiceException{
		if(service==null){
			throw new NoSuchServiceException("Le service " + service.getName() + " n'existe pas ou n'a pas été instancié !");
		}
		
		if(service.getInterfaceType() == InterfaceType.Required){
			this.requiredServices.add(service);
		}
		else{
			throw new WrongInterfaceServiceException("Le service " + service.getName() + " doit disposer d'une interface de type Required !");
		}			
	}
	
	/**
	 * Adding a provided {@link Role} into the roles' list of the {@link Configuration}
	 * @param role The {@link Role} to add
	 * @throws NoSuchRoleException 
	 * @throws WrongInterfaceRoleException 
	 */
	public void addProvidedRole(Role role) throws NoSuchRoleException, WrongInterfaceRoleException{
		if(role==null){
			throw new NoSuchRoleException("Le rôle " + role.getName() + " n'existe pas ou n'a pas été instancié !");
		}
		
		if(role.getInterfaceType() == InterfaceType.Provided){
			this.providedRole.add(role);
		}
		else{
			throw new WrongInterfaceRoleException("Le rôle " + role.getName() + " doit disposer d'une interface de type Provided !");
		}		
	}

	/**
	 * Adding a required {@link Role} into the required roles' list of the {@link Configuration}
	 * @param role The {@link Role} to add
	 * @throws NoSuchServiceException 
	 * @throws WrongInterfaceServiceException 
	 */
	public void addRequiredRole(Role role) throws NoSuchRoleException, WrongInterfaceRoleException{
		if(role==null){
			throw new NoSuchRoleException("Le rôle " + role.getName() + " n'existe pas ou n'a pas été instancié !");
		}
		
		if(role.getInterfaceType() == InterfaceType.Required){
			this.requiredRole.add(role);
		}
		else{
			throw new WrongInterfaceRoleException("Le rôle " + role.getName() + " doit disposer d'une interface de type Required !");
		}		
	}

	/**
	 * @return the childComponent
	 */
	public List<IComponentType> getChildComponent() {
		return childComponent;
	}

	/**
	 * @param childComponent the childComponent to set
	 */
	public void setChildComponent(List<IComponentType> childComponent) {
		this.childComponent = childComponent;
	}

	/**
	 * @return the childConnector
	 */
	public List<IConnectorType> getChildConnector() {
		return childConnector;
	}

	/**
	 * @param childConnector the childConnector to set
	 */
	public void setChildConnector(List<IConnectorType> childConnector) {
		this.childConnector = childConnector;
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
	 * @return the properties
	 */
	public List<Properties> getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List<Properties> properties) {
		this.properties = properties;
	}

	/**
	 * @return the providedPorts
	 */
	public List<Port> getProvidedPorts() {
		return providedPorts;
	}

	/**
	 * @param providedPorts the providedPorts to set
	 */
	public void setProvidedPorts(List<Port> providedPorts) {
		this.providedPorts = providedPorts;
	}

	/**
	 * @return the requiredPorts
	 */
	public List<Port> getRequiredPorts() {
		return requiredPorts;
	}

	/**
	 * @param requiredPorts the requiredPorts to set
	 */
	public void setRequiredPorts(List<Port> requiredPorts) {
		this.requiredPorts = requiredPorts;
	}

	/**
	 * @return the providedServices
	 */
	public List<Service> getProvidedServices() {
		return providedServices;
	}

	/**
	 * @param providedServices the providedServices to set
	 */
	public void setProvidedServices(List<Service> providedServices) {
		this.providedServices = providedServices;
	}

	/**
	 * @return the requiredServices
	 */
	public List<Service> getRequiredServices() {
		return requiredServices;
	}

	/**
	 * @param requiredServices the requiredServices to set
	 */
	public void setRequiredServices(List<Service> requiredServices) {
		this.requiredServices = requiredServices;
	}

	/**
	 * @return the providedRole
	 */
	public List<Role> getProvidedRole() {
		return providedRole;
	}

	/**
	 * @param providedRole the providedRole to set
	 */
	public void setProvidedRole(List<Role> providedRole) {
		this.providedRole = providedRole;
	}

	/**
	 * @return the requiredRole
	 */
	public List<Role> getRequiredRole() {
		return requiredRole;
	}

	/**
	 * @param requiredRole the requiredRole to set
	 */
	public void setRequiredRole(List<Role> requiredRole) {
		this.requiredRole = requiredRole;
	}

	/**
	 * @return the links
	 */
	public List<Link> getLinks() {
		return links;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void transfertData(Observable observable, Object object){
		for (Link link : links){
			if (link instanceof AttachmentLink && ((AttachmentLink) link).getFromPortComp().equals(observable)){
				((AttachmentLink) link).getToRoleConn().receiveData(object);
			}
		}
	}
	
	public void addLink(Link link){
		this.links.add(link);
	}
}
