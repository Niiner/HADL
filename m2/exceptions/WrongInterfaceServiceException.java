package exceptions;

import enumerations.InterfaceType;

/**
 * Allow to raise an exception if a called {@link Service} doesn't provide the
 * right {@link InterfaceType} (provided or required)
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class WrongInterfaceServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Create a new instance of {@link WrongInterfaceServiceException}
	 */
	public WrongInterfaceServiceException() {
		super();
	}

	/**
	 * Create a new instance of {@link WrongInterfaceServiceException}
	 * 
	 * @param message
	 *            The message which details the {@link Exception}
	 */
	public WrongInterfaceServiceException(String message) {
		super(message);
	}

	/**
	 * Create a new instance of {@link WrongInterfaceServiceException}
	 * 
	 * @param cause
	 *            The {@link Exception} which is the origin of this
	 *            {@link Exception}
	 */
	public WrongInterfaceServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * Create a new instance of {@link WrongInterfaceServiceException}
	 * 
	 * @param message
	 *            The message which details the {@link Exception}
	 * @param cause
	 *            The {@link Exception} which is the origin of this
	 *            {@link Exception}
	 */
	public WrongInterfaceServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
