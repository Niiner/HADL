package exceptions;

import enumerations.InterfaceType;

/**
 * Allow to raise an exception if a called {@link Role} doesn't provide the right {@link InterfaceType} (provided or required)
 * @author Niiner-PC
 *
 */
public class WrongInterfaceRoleException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/** 
	* Create a new instance of {@link WrongInterfaceRoleException}
	*/
    public WrongInterfaceRoleException() {
        super();
    }
    
	/** 
	* Create a new instance of {@link WrongInterfaceRoleException}
	* @param message The message which details the {@link Exception}
	*/
    public WrongInterfaceRoleException(final String message) {
        super(message);
    }
    
	/** 
	* Create a new instance of {@link WrongInterfaceRoleException}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public WrongInterfaceRoleException(final Throwable cause) {
        super(cause);
    }
    
	/** 
	* Create a new instance of {@link WrongInterfaceRoleException}
	* @param message The message which details the {@link Exception}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public WrongInterfaceRoleException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
