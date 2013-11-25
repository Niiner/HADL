package containers;

import java.util.ArrayList;
import java.util.List;

import elements.physicalInterface.ports.Port;
import elements.physicalInterface.ports.Properties;
import elements.physicalInterface.services.Service;
import enumerations.InterfaceType;
import exceptions.NoSuchPortException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceServiceException;

/**
 * This class provides an implementation for a Component
 * A component is composed by Ports and Services which can be required or provided, it can also comp	orts properties
 * @author Niiner-PC
 *
 */
public class Component implements IComponentType {

	protected String name;
	protected Configuration configuration;

	protected List<Properties> properties = new ArrayList<Properties>();	
	protected List<Port> providedPorts = new ArrayList<Port>();
	protected List<Port> requiredPorts = new ArrayList<Port>();
	protected List<Service> providedServices = new ArrayList<Service>();
	protected List<Service> requiredServices = new ArrayList<Service>();


	/**
	 * Constructor
	 * @param config The {@link Configuration} to whom this component belongs
	 * @param name The name of the component
	 */
	public Component(Configuration config, String name){
		this.configuration = config;
		boolean oneProvided;
	}

	/**
	 * Adding a provided {@link Port} into the provided ports' list of the {@link Component}
	 * @param port The {@link Port} to add
	 * @throws NoSuchPortException 
	 * @throws WrongInterfacePortException 
	 */
	public void addProvidedPort(Port port) throws NoSuchPortException, WrongInterfacePortException{
		if(port==null){
			throw new NoSuchPortException("Le port " + port.getName() + " n'existe pas ou n'a pas été instancié !");
		}

		if(port.getInterfaceType() == InterfaceType.Provided){
			this.providedPorts.add(port);
		}
		else{
			throw new WrongInterfacePortException("Le port " + port.getName() + " doit disposer d'une interface de type Provided !");
		}		
	}

	/**
	 * Adding a required {@link Port} into the required ports' list of the {@link Component}
	 * @param port The {@link Port} to add
	 * @throws NoSuchPortException 
	 * @throws WrongInterfacePortException 
	 */
	public void addRequiredPort(Port port) throws NoSuchPortException, WrongInterfacePortException{
		if(port==null){
			throw new NoSuchPortException("Le port " + port.getName() + "n'existe pas ou n'a pas été instancié !");
		}

		if(port.getInterfaceType() == InterfaceType.Required){
			this.requiredPorts.add(port);
		}
		else{
			throw new WrongInterfacePortException("Ce port " + port.getName() + " doit disposer d'une interface de type Required !");
		}		
	}

	/**
	 * Adding a provided {@link Service} into the ports' list of the {@link Component}
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
	 * Adding a required {@link Service} into the required ports' list of the {@link Component}
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

}
