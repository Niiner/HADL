package exceptions;

import sun.font.CreatedFontTracker;

/**
 * Allow to raise an exception if a called {@link Port} doesn't exist
 * @author Niiner-PC
 *
 */
public class NoSuchPortException extends Exception{

	private static final long serialVersionUID = 1L;

	/** 
	* Create a new instance of {@link WrongInterfaceServiceException}
	*/
    public NoSuchPortException() {
        super();
    }
    
	/** 
	* Create a new instance of {@link NoSuchPortException}
	* @param message The message which details the {@link Exception}
	*/
    public NoSuchPortException(final String message) {
        super(message);
    }
    
	/** 
	* Create a new instance of {@link NoSuchPortException}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}
	*/
    public NoSuchPortException(final Throwable cause) {
        super(cause);
    }
    
	/** 
	* Create a new instance of {@link NoSuchPortException}
	* @param message The message which details the {@link Exception}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NoSuchPortException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
