

package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This object represents the Class Object or box for the UML editor to hold all
 * of the data of each instance of a Class Object.
 * 
 * @author oRANGE
 */
public class ClassObject {

    private String name;
    private int id;
    private ArrayList<Attribute> attributes;
    private ArrayList<Operation> operations;

    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private final int widthScale = 8;
    private Color color;
    private boolean isSelected;

    /**
     * Constructor for the class object
     * @param newName - name of the newly created class
     * @param xPos - the class x-coordinate
     * @param yPos - the class y-coordinate
     */
    public ClassObject(String newName, int xPos, int yPos, int id) {
        
        attributes = new ArrayList<Attribute>();
        operations = new ArrayList<Operation>();
        
        this.id = id;
        this.name = newName;
        this.xPos = xPos;
        this.yPos = yPos;

        this.width = setWidth() * widthScale + 10;
        this.height = 20;
        
        color = Color.orange;
        isSelected = false;
    }

    

    /**
     * Adds an attribute to the class object
     * 
     * @param attributeName - name of the attribute
     * @param isPrivate - if attribute is private of public
     */
    
    public void addAttribute(String attributeName, int visibility) {
        if(!attributeName.equals("")){
        	attributes.add(new Attribute(attributeName, visibility)); 
            this.width = setWidth() * widthScale + 10;
            this.height += 20;
        }
    }

    /**
     * Removes an attribute
     * @param index - location in the ArrayList to be removed
     */
    public void removeAttribute(int index) {
        attributes.remove(index);
        this.width = setWidth() * widthScale + 10;
    }

    /**
     * Removes all attributes. ArrayList of Attributes becomes empty
     */
    public void removeAllAtributes() {
        attributes.clear();
        this.width = setWidth() * widthScale + 10;
    }

    /**
     * Add an operation to the class
     * @param operationName 
     */
    public void addOperation(String operationName, int visibility) {
        if(!operationName.equals("")){
        	operations.add(new Operation(operationName, visibility)); 
            this.width = setWidth() * widthScale + 10;
            this.height += 20;
        }
    }

    /**
     * Removes a specified operation
     * @param index
     */
    public void removeOperation(int index) {
        operations.remove(index);
        this.width = setWidth() * widthScale + 10;
    }

    /**
     * Removes all operations. ArrayList of operations becomes empty
     */
    public void removeAllOperations() {
        operations.clear();
        this.width = setWidth() * widthScale + 10;
    }

    /**
     * Return name of class
     * @return name -  the name of the class
     */
    public String getName() {
        return name;
    }

    /**
     * Returns ArrayList containing all attributes.
     * @return attributes - holds all the attributes
     */
    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Returns ArrayList containing all operations
     * @return operations - hold all the operations
     */
    public ArrayList<Operation> getOperations() {
        return operations;
    }

    /**
     * Returns x-coordinate of class object
     * @return - x-coordinate
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * Returns y-coordinate of class object
     * @return - y coordinate
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * Returns width of class object
     * @return width of the object
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns height of the class object
     * @return height of the object
     */
    public int getHeight() {
        if(operations.size() > 0 && attributes.size() == 0) {
            return height + 20;
        } else {
            return height;
        } 
    }

    /**
     * Sets a predetermined x-coordinate for the object
     * @param xPos
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * Sets a predetermined y-coordinate for the object
     * @param yPos
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * Returns color with which the object is filled
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets a color chosen by the user to fill the object
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

        
    /**
     * Returns longest string in the attribute list
     * @return
     */
    public int getLongestAttribute() {
        int max = 0;
        int setMax = 0;
        if(attributes.size() > 0) {
        	setMax = attributes.get(max).getAttributeName().length();
        }
        for(int i = 0; i < attributes.size(); i++)
            if(attributes.get(i).getAttributeName().length() >= attributes.get(max).getAttributeName().length()){
                max = i;
                setMax = attributes.get(max).getAttributeName().length();
            }
        return setMax;    
    }

    /**
     * Returns longest string in the operation list
     * @return
     */
    public int getLongestOperation() {
        int max = 0;
        int setMax = 0;
        if(operations.size() > 0) {
        	setMax = operations.get(max).getOperationName().length();
        }
        for(int i = 0; i < operations.size(); i++)
            if(operations.get(i).getOperationName().length() >= operations.get(max).getOperationName().length()){
                max = i;
                setMax = operations.get(max).getOperationName().length();
            }
        return setMax;    
    }
    
    /**
     * Sets a predetermined width for the object
     * @return
     */
    public int setWidth(){
        int max = Math.max(name.length(), getLongestAttribute());
        return Math.max(max, getLongestOperation());
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
    
    
}
