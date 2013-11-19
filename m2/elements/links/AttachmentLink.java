package elements.links;

import elements.ports.Port;
import elements.ports.Role;

public class AttachmentLink extends Link {
	
	private Port fromPortComp;
	private Role toRoleConn;
	
	public AttachmentLink(String name, Port fromPortComp, Role toRoleConn) {
		super(name);
		// TODO: Ajouter les verifications pour respecter les contraintes OCL
		this.fromPortComp = fromPortComp;
		this.toRoleConn = toRoleConn;
	}

	public Port getFromPortComp() {
		return fromPortComp;
	}

	public void setFromPortComp(Port fromPortComp) {
		this.fromPortComp = fromPortComp;
	}

	public Role getToRoleConn() {
		return toRoleConn;
	}

	public void setToRoleConn(Role toRoleConn) {
		this.toRoleConn = toRoleConn;
	}

}
