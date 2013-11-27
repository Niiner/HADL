package message;
import java.util.List;

/**
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class Message {

	private String request;
	private List<Object> response;

	/**
	 * Constructor
	 * 
	 * @param request
	 * @param response
	 */
	public Message(String request, List<Object> response) {
		this.request = request;
		this.response = response;
	}

	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
	}

	/**
	 * @return the response
	 */
	public List<Object> getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(List<Object> response) {
		this.response = response;
	}

}
