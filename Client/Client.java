import java.util.Observable;
import java.util.Observer;

import ports.ReceiveRequestP;
import ports.SendRequestP;
import properties.SourceCode;
import properties.Visualization;
import services.ReceiveRequestS;
import services.SendRequestS;
import containers.Component;
import containers.Configuration;
import elements.ports.Port;
import elements.ports.Service;

public class Client extends Component implements Observer{
	
	public Client(Configuration config, String name){
		super(config, name);
		Port sendRequestP = new SendRequestP("SendRequestP");
		sendRequestP.addObserver(this);
		Service sendRequestS = new SendRequestS("SendRequestS");
		// Adding services and ports to the Client
		this.properties.add(new Visualization("Visualization"));
		this.properties.add(new SourceCode("SourceCode"));
		this.addPort(sendRequestP);
		this.addService(sendRequestS);
		sendRequestS.addPort(sendRequestP);
	}
	
	public SendRequestP getSendRequestP(){
		SendRequestP p = null;
		for (Port port : ports){
			if (port instanceof SendRequestP){
				p = (SendRequestP) port;
			}
		}
		return p;
	}
	
	public SendRequestS getSendRequestS(){
		SendRequestS s = null;
		for (Service service : services/*servicesProvided*/){
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
	
//	public void sendRequest(String msg){
//		SendRequestS useService = null;
//		for (Service s : servicesProvided){
//			if (s instanceof SendRequestS){
//				useService = (SendRequestS) s;
//			}
//		}
//		useService.receiveRequest(msg);
//	}
	
}
