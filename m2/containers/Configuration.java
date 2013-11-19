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

public class Configuration implements IComponentType, IConnectorType {
	
	protected List<IComponentType> childComponent = new ArrayList<IComponentType>();
	protected List<IConnectorType> childConnector = new ArrayList<IConnectorType>();
	
	protected String name;
	
	protected List<Properties> properties = new ArrayList<Properties>();	
	protected List<Port> ports = new ArrayList<Port>();
	protected List<Service> services = new ArrayList<Service>();	
	protected List<Role> roles = new ArrayList<Role>();	
	protected List<Link> links = new ArrayList<Link>();
	
	public Configuration(String name){
		this.name = name;
	}

	public void addLink(Link link){
		this.links.add(link);
	}
	
	public void transfertData(Observable observable, Object object){
		for (Link link : links){
			if (link instanceof AttachmentLink && ((AttachmentLink) link).getFromPortComp().equals(observable)){
				((AttachmentLink) link).getToRoleConn().receiveData(object);
			}
		}
	}
}
