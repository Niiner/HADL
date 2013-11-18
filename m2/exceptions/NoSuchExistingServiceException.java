package exceptions;

/**
 * Allow to raise an exception if a called {@link Service} doesn't exist
 * @author Niiner-PC
 *
 */
public class NoSuchExistingServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	/** 
	* Create a new instance of {@link NoSuchExistingServiceException}
	*/  
    public NoSuchExistingServiceException() {
        super();
    }
    
	/** 
	* Create a new instance of {@link NoSuchExistingServiceException}
	* @param message The message which details the {@link Exception}
	*/
    public NoSuchExistingServiceException(final String message) {
        super(message);
    }
    
	/** 
	* Create a new instance of {@link NoSuchExistingServiceException}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NoSuchExistingServiceException(final Throwable cause) {
        super(cause);
    }
    
	/** 
	* Create a new instance of {@link NoSuchExistingServiceException}
	* @param message The message which details the {@link Exception}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NoSuchExistingServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
