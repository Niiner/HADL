package exceptions;

import enumerations.InterfaceType;

/**
 * Allow to raise an exception if a called {@link Port} doesn't provide the
 * right {@link InterfaceType} (provided or required)
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public class WrongInterfacePortException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Create a new instance of {@link WrongInterfacePortException}
	 */
	public WrongInterfacePortException() {
		super();
	}

	/**
	 * Create a new instance of {@link WrongInterfacePortException}
	 * 
	 * @param message
	 *            The message which details the {@link Exception}
	 */
	public WrongInterfacePortException(final String message) {
		super(message);
	}

	/**
	 * Create a new instance of {@link WrongInterfacePortException}
	 * 
	 * @param cause
	 *            The {@link Exception} which is the origin of this
	 *            {@link Exception}
	 */
	public WrongInterfacePortException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Create a new instance of {@link WrongInterfacePortException}
	 * 
	 * @param message
	 *            The message which details the {@link Exception}
	 * @param cause
	 *            The {@link Exception} which is the origin of this
	 *            {@link Exception}
	 */
	public WrongInterfacePortException(final String message,
			final Throwable cause) {
		super(message, cause);
	}
}
