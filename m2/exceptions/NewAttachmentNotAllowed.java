package exceptions;

import elements.physicalinterface.links.AttachmentLink;

/**
 * Allow to raise an exception if an {@link AttachmentLink} doesn't respect some constraints
 * An {@link AttachementLink} must have a required role and a provided port or inversely
 * @author E096393A
 *
 */
public class NewAttachmentNotAllowed extends Exception{

	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = 2993900907540669392L;

	/** 
	* Create a new instance of {@link NewAttachmentNotAllowed}
	*/
    public NewAttachmentNotAllowed() {
        super();
    }
    
	/** 
	* Create a new instance of {@link NewAttachmentNotAllowed}
	* @param message The message which details the {@link Exception}
	*/
    public NewAttachmentNotAllowed(final String message) {
        super(message);
    }
    
	/** 
	* Create a new instance of {@link NewAttachmentNotAllowed}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}
	*/
    public NewAttachmentNotAllowed(final Throwable cause) {
        super(cause);
    }
    
	/** 
	* Create a new instance of {@link NewAttachmentNotAllowed}
	* @param message The message which details the {@link Exception}
	* @param cause The {@link Exception} which is the origin of this {@link Exception}  
	*/
    public NewAttachmentNotAllowed(final String message, final Throwable cause) {
        super(message, cause);
    }
}
