package models;

/**
 * Attribute class that hold all the basic information needed for an attribute
 * 
 * @author oRANGE
 */
public class Attribute {
	private String attributeName;
	private int visibility;

	/**
	 * Constructor for a new attribute
	 * 
	 * @param attributeName
	 * @param visibility
	 */
	public Attribute(String attributeName, int visibility) {
		this.attributeName = attributeName;
		this.visibility = visibility;
	}

	/**
	 * Returns name of the attribute
	 * 
	 * @return
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * Sets a predetermined name for the attribute
	 * 
	 * @param attributeName
	 */
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	/**
	 * Returns if visibility is private or public
	 * 
	 * @return
	 */
	public int getVisibility() {
		return visibility;
	}

	/**
	 * Sets the attribute to be private or public
	 * 
	 * @param visibility
	 */
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

}
