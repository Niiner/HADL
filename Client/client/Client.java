package client;
import java.util.Observable;
import java.util.Observer;

import ports.SendRequestP;
import properties.SourceCode;
import properties.Visualization;
import services.SendRequestS;
import configuration.SystemClientServer;
import containers.Component;
import elements.physicalInterface.ports.Port;
import elements.physicalInterface.services.Service;
import exceptions.NoSuchPortException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceServiceException;

/**
 * This class provides an implementation for the Client
 * @author Niiner-PC
 *
 */
public class Client extends Component implements Observer{
	
	/**
	 * Constructor
	 * @param config the {@link Configuration} of the Client
	 * @param name the name of the client
	 * @throws NoSuchPortException
	 * @throws WrongInterfacePortException
	 * @throws NoSuchServiceException
	 * @throws WrongInterfaceServiceException
	 */
	public Client(SystemClientServer config, String name) throws NoSuchPortException, WrongInterfacePortException, NoSuchServiceException, WrongInterfaceServiceException{
		super(config, name);
		Port sendRequestP = new SendRequestP("SendRequestP");
		Service sendRequestS = new SendRequestS("SendRequestS");
		
		// Client listen the sendRequestP
		sendRequestP.addObserver(this);
		
		// Adding services and ports to the Client
		this.properties.add(new Visualization("Visualization"));
		this.properties.add(new SourceCode("SourceCode"));
		this.addProvidedPort(sendRequestP);
		this.addProvidedService(sendRequestS);
		sendRequestS.addPort(sendRequestP);
	}
	
	/**
	 * @return the port {@link SendRequestP} of {@link Client}
	 */
	public SendRequestP getSendRequestP(){
		SendRequestP p = null;
		for (Port port : providedPorts){
			if (port instanceof SendRequestP){
				p = (SendRequestP) port;
			}
		}
		return p;
	}
	
	/**
	 * @return the service {@link SendRequestS} of {@link Client}
	 */
	public SendRequestS getSendRequestS(){
		SendRequestS s = null;
		for (Service service : providedServices){
			if (service instanceof SendRequestS){
				s = (SendRequestS) service;
			}
		}
		return s;
	}

	@Override
	public void update(Observable observable, Object object) {
		System.out.println("[ ----- Client notify ----- ]");
		if (observable instanceof SendRequestP){
			((SystemClientServer) this.configuration).transfertData(observable, object);
		}
	}
}
