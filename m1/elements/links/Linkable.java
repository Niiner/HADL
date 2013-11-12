package elements.links;


/**
 * This interface allow communication between links
 * @author Niiner-PC
 *
 */
public interface Linkable {
	
		void plug(Link link);
		void receive(String msg);
		
}
