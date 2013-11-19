package elements.links;

import elements.ports.Port;
import elements.ports.Role;

/**
 * This class provides an implementation for an AttachmentLink.
 * An attachment link allows to "plug" a Port and a Role.
 * @author E096393A
 *
 */
public class AttachmentLink extends Link {
	
	private Port fromPortComp;
	private Role toRoleConn;
	
	/**
	 * Constructor
	 * @param name The name of the AttachmentLink
	 * @param fromPortComp The {@link Port} to connect with
	 * @param toRoleConn The {@link Role} to connect with
	 */
	public AttachmentLink(String name, Port fromPortComp, Role toRoleConn) {
		super(name);
		// TODO: Ajouter les verifications pour respecter les contraintes OCL
		this.fromPortComp = fromPortComp;
		this.toRoleConn = toRoleConn;
	}

	/**
	 * @return the fromPortComp
	 */
	public Port getFromPortComp() {
		return fromPortComp;
	}

	/**
	 * @param fromPortComp the fromPortComp to set
	 */
	public void setFromPortComp(Port fromPortComp) {
		this.fromPortComp = fromPortComp;
	}

	/**
	 * @return the toRoleConn
	 */
	public Role getToRoleConn() {
		return toRoleConn;
	}

	/**
	 * @param toRoleConn the toRoleConn to set
	 */
	public void setToRoleConn(Role toRoleConn) {
		this.toRoleConn = toRoleConn;
	}

}
