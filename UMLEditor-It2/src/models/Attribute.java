
package models;

/**
 * Attribute class that hold all the basic information needed for an 
 * attribute
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
    public Attribute(String attributeName, int visibility){
    	switch (visibility) {
    		case 0: this.attributeName = "+ " + attributeName;
    			break;
    		case 1: this.attributeName = "- " + attributeName;
    			break;
    		case 2: this.attributeName = "# " + attributeName;
    			break;
    		case 3: this.attributeName = "~ " + attributeName;
    			break;
    	}  
        this.visibility = visibility;
    }

    /**
     * Returns name of the attribute
     * @return
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * Sets a predetermined name for the attribute
     * @param attributeName
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * Returns if visibility is private or public
     * @return
     */
    public int getVisibility() {
        return visibility;
    }

    /**
     * Sets the attribute to be private or public
     * @param visibility
     */
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
    
    
    
}
