package exceptions;

/**
 * Allow to raise an exception if a called {@link Role} doesn't exist
 * @author Niiner-PC
 *
 */
public class NoSuchRoleException extends Exception{

	private static final long serialVersionUID = 1L;

	/** 
	* Create a new instance of {@link NoSuchRoleException}
	*/
    public NoSuchRoleException() {
        super();
    }
    
	/** 
	* Create a new instance of {@link NoSuchRoleException}
	* @param message The message which details the {@link Exception}
	*/
    public NoSuchRoleException(final String message) {
        super(message);
    }
    
	/** 
	* Create a new instance of {@link NoSuchRoleException}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NoSuchRoleException(final Throwable cause) {
        super(cause);
    }
    
	/** 
	* Create a new instance of {@link NoSuchRoleException}
	* @param message The message which details the {@link Exception}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NoSuchRoleException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
