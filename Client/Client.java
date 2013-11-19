import java.util.Observable;
import java.util.Observer;

import ports.SendRequestP;
import properties.SourceCode;
import properties.Visualization;
import services.SendRequestS;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;
import elements.ports.Service;
import exceptions.NoSuchPortException;
import exceptions.NoSuchServiceException;
import exceptions.WrongInterfacePortException;
import exceptions.WrongInterfaceServiceException;

public class Client extends Component implements Observer{
	
	public Client(Configuration config, String name) throws NoSuchPortException, WrongInterfacePortException, NoSuchServiceException, WrongInterfaceServiceException{
		super(config, name);
		Port sendRequestP = new SendRequestP("SendRequestP");
		sendRequestP.addObserver(this);
		Service sendRequestS = new SendRequestS("SendRequestS");
		// Adding services and ports to the Client
		this.properties.add(new Visualization("Visualization"));
		this.properties.add(new SourceCode("SourceCode"));
		this.addProvidedPort(sendRequestP);
		this.addProvidedService(sendRequestS);
		sendRequestS.addPort(sendRequestP);
	}
	
	public SendRequestP getSendRequestP(){
		SendRequestP p = null;
		for (Port port : providedPorts){
			if (port instanceof SendRequestP){
				p = (SendRequestP) port;
			}
		}
		return p;
	}
	
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
		System.out.println("Client notify");
		if (observable instanceof SendRequestP){
			System.out.println("SendRequestP notify");
			this.configuration.transfertData(observable, object);
		}
		// TODO Auto-generated method stub
		
	}
}
