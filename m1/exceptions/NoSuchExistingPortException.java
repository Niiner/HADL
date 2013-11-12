package exceptions;

/**
 * Allow to raise an exception if a called {@link Port} doesn't exist
 * @author Niiner-PC
 *
 */
public class NoSuchExistingPortException extends Exception{

	private static final long serialVersionUID = 1L;

	/** 
	* Create a new instance of {@link WrongServiceException}
	*/
    public NoSuchExistingPortException() {
        super();
    }
    
	/** 
	* Create a new instance of {@link NoSuchExistingPortException}
	* @param message The message which details the {@link Exception}
	*/
    public NoSuchExistingPortException(final String message) {
        super(message);
    }
    
	/** 
	* Create a new instance of {@link NoSuchExistingPortException}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NoSuchExistingPortException(final Throwable cause) {
        super(cause);
    }
    
	/** 
	* Create a new instance of {@link NoSuchExistingPortException}
	* @param message The message which details the {@link Exception}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NoSuchExistingPortException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
