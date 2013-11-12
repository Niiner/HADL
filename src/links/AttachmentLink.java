package links;

import elements.Port;
import elements.Role;

public class AttachmentLink extends Link {
	
	private Port fromPortComp;
	private Role toRoleConn;
	
	public AttachmentLink(String name, Port fromPortComp, Role toRoleConn) {
		super(name);
		// TODO: Ajouter les vérifications pour respecter les contraintes OCL
		this.fromPortComp = fromPortComp;
		this.toRoleConn = toRoleConn;
	}

}
