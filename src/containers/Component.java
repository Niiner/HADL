package containers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import ports.SendRequestP;
import elements.Port;
import elements.Properties;
import elements.Service;
import elements.SynchronPort;
import enumerations.InterfaceType;


public class Component implements IComponentType {
	
	protected String name;
	protected List<Properties> properties = new ArrayList<Properties>();
	
	protected List<Port> ports = new ArrayList<Port>();
	protected List<Service> services = new ArrayList<Service>();
	
	public Component(String name/*, List<Port> portList*/){
		
		boolean oneProvided;
		
		/*for(Port port : portList){
			if(port.getInterfaceType() == InterfaceType.Provided){
				oneProvided = true;
			}
		}*/
		
		// Cr�er sa propre exception : instancier si au moins un port provided 
		// this.name = name;
	
	}

	public List<Port> getPorts() {
		return ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

}
