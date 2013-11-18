package exceptions;

import enumerations.InterfaceType;

/**
 * Allow to raise an exception if a called {@link Service} doesn't provide the right {@link InterfaceType} (provided or required)
 * @author Niiner-PC
 *
 */
public class WrongServiceException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Create a new instance of {@link WrongServiceException}
	 */
    public WrongServiceException() {
        super();
    }
    
	/** 
	* Create a new instance of {@link WrongServiceException}
	* @param message The message which details the {@link Exception}
	*/  
    public WrongServiceException(String message) {
        super(message);
    }
    
	/** 
	* Create a new instance of {@link WrongServiceException}
	* @param cause The {@link Exception} which is the origin of this {@link Exception} 
	*/  
    public WrongServiceException(Throwable cause) {
        super(cause);
    }
    
	/** 
	* Create a new instance of {@link WrongServiceException}
	* @param message The message which details the {@link Exception}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public WrongServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
