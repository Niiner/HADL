package exceptions;

import enumerations.InterfaceType;

/**
 * Allow to raise an exception if a called {@link Port} doesn't provide the right {@link InterfaceType} (provided or required)
 * @author Niiner-PC
 *
 */
public class WrongPortException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/** 
	* Create a new instance of {@link WrongPortException}
	*/
    public WrongPortException() {
        super();
    }
    
	/** 
	* Create a new instance of {@link WrongPortException}
	* @param message The message which details the {@link Exception}
	*/
    public WrongPortException(final String message) {
        super(message);
    }
    
	/** 
	* Create a new instance of {@link WrongPortException}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public WrongPortException(final Throwable cause) {
        super(cause);
    }
    
	/** 
	* Create a new instance of {@link WrongPortException}
	* @param message The message which details the {@link Exception}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public WrongPortException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
