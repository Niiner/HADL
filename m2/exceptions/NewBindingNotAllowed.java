package exceptions;

import elements.physicalinterface.links.BindingLink;

/**
 * Allow to raise an exception if an {@link BindingLink} doesn't respect some constraints
 * An {@link BindingLink} must have a required role and a provided port or inversely
 * @author E096393A
 *
 */
public class NewBindingNotAllowed extends Exception{

	private static final long serialVersionUID = -6150575435418791720L;

	/** 
	* Create a new instance of {@link NewBindingNotAllowed}
	*/
    public NewBindingNotAllowed() {
        super();
    }
    
	/** 
	* Create a new instance of {@link NewBindingNotAllowed}
	* @param message The message which details the {@link Exception}
	*/
    public NewBindingNotAllowed(final String message) {
        super(message);
    }
    
	/** 
	* Create a new instance of {@link NewBindingNotAllowed}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}
	*/
    public NewBindingNotAllowed(final Throwable cause) {
        super(cause);
    }
    
	/** 
	* Create a new instance of {@link NewBindingNotAllowed}
	* @param message The message which details the {@link Exception}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NewBindingNotAllowed(final String message, final Throwable cause) {
        super(message, cause);
    }
}
