package elements.links;

/**
 * This is an abstract class which represents links. Links can be attachment
 * links or binding links
 * 
 * @author FAGNIEZ Florian and RULLIER Noemie
 * 
 */
public abstract class Link {

	protected String name;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            The name of the Link
	 */
	public Link(String name) {
		this.name = name;
	}

}
