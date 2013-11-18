package exceptions;

/**
 * Allow to raise an exception if a called {@link Service} doesn't exist
 * @author Niiner-PC
 *
 */
public class NoSuchServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	/** 
	* Create a new instance of {@link NoSuchServiceException}
	*/  
    public NoSuchServiceException() {
        super();
    }
    
	/** 
	* Create a new instance of {@link NoSuchServiceException}
	* @param message The message which details the {@link Exception}
	*/
    public NoSuchServiceException(final String message) {
        super(message);
    }
    
	/** 
	* Create a new instance of {@link NoSuchServiceException}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NoSuchServiceException(final Throwable cause) {
        super(cause);
    }
    
	/** 
	* Create a new instance of {@link NoSuchServiceException}
	* @param message The message which details the {@link Exception}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NoSuchServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
