package models;

import gui.Manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This object represents the Class Object or box for the UML editor to hold all
 * of the data of each instance of a Class Object.
 * 
 * @author oRANGE
 */
public class ClassObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private int type;
	private ArrayList<Attribute> attributes;
	private ArrayList<Operation> operations;

	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
	private boolean isSelected;
	private FontMetrics metrics;
	private Font font;
	private Graphics g;
	private Manager manager;

	/**
	 * Constructor for the class object
	 * 
	 * @param newName
	 *            - name of the newly created class
	 * @param xPos
	 *            - the class x-coordinate
	 * @param yPos
	 *            - the class y-coordinate
	 */
	public ClassObject(String newName, int xPos, int yPos, int type, Manager manager) {
		this.manager = manager;
		attributes = new ArrayList<Attribute>();
		operations = new ArrayList<Operation>();

		this.type = type;
		this.name = newName;
		this.xPos = xPos;
		this.yPos = yPos;
		g = manager.getGui().getView().getGraphics();
		font = new Font("", Font.PLAIN, 12);
		metrics = g.getFontMetrics(font);
		this.width = setWidth() + 10;
		this.height = 20;

		color = manager.getClassColor();
		isSelected = false;
	}

	/**
	 * Adds an attribute to the class object
	 * 
	 * @param attributeName
	 *            - name of the attribute
	 * @param isPrivate
	 *            - if attribute is private of public
	 */

	public void addAttribute(String attributeName, int visibility) {
		if (!attributeName.equals("")) {
			attributes.add(new Attribute(attributeName, visibility));
			this.width = setWidth() + 10;
			this.height += 20;
		}
	}

	/**
	 * Removes an attribute
	 * 
	 * @param index
	 *            - location in the ArrayList to be removed
	 */
	public void removeAttribute(int index) {
		attributes.remove(index);
		this.width = setWidth() + 10;
	}

	/**
	 * Removes all attributes. ArrayList of Attributes becomes empty
	 */
	public void removeAllAtributes() {
		attributes.clear();
		this.width = setWidth() + 10;
	}

	/**
	 * Add an operation to the class
	 * 
	 * @param operationName
	 */
	public void addOperation(String operationName, int visibility) {
		if (!operationName.equals("")) {
			operations.add(new Operation(operationName, visibility));
			this.width = setWidth() + 10;
			this.height += 20;
		}
	}

	/**
	 * Removes a specified operation
	 * 
	 * @param index
	 */
	public void removeOperation(int index) {
		operations.remove(index);
		this.width = setWidth() + 10;
	}

	/**
	 * Removes all operations. ArrayList of operations becomes empty
	 */
	public void removeAllOperations() {
		operations.clear();
		this.width = setWidth() + 10;
	}

	/**
	 * Return name of class
	 * 
	 * @return name - the name of the class
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns ArrayList containing all attributes.
	 * 
	 * @return attributes - holds all the attributes
	 */
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * Returns ArrayList containing all operations
	 * 
	 * @return operations - hold all the operations
	 */
	public ArrayList<Operation> getOperations() {
		return operations;
	}

	/**
	 * Returns x-coordinate of class object
	 * 
	 * @return - x-coordinate
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * Returns y-coordinate of class object
	 * 
	 * @return - y coordinate
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * Returns width of class object
	 * 
	 * @return width of the object
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns height of the class object
	 * 
	 * @return height of the object
	 */
	public int getHeight() {
		if (operations.size() > 0 && attributes.size() == 0) {
			return height + 20;
		} else {
			return height;
		}
	}

	/**
	 * Sets a predetermined x-coordinate for the object
	 * 
	 * @param xPos
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * Sets a predetermined y-coordinate for the object
	 * 
	 * @param yPos
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * Returns color with which the object is filled
	 * 
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets a color chosen by the user to fill the object
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Returns longest string in the attribute list
	 * 
	 * @return
	 */
	public int getLongestAttribute() {
		int max = 0;
		int setMax = 0;
		if (attributes.size() > 0) {
			setMax = metrics.stringWidth("+ " + attributes.get(max).getAttributeName());
		}
		for (int i = 0; i < attributes.size(); i++)
			if (metrics.stringWidth("+ " + attributes.get(i).getAttributeName()) >= metrics.stringWidth("+ " + attributes
					.get(max).getAttributeName())) {
				max = i;
				setMax = metrics.stringWidth("+ " + attributes.get(max).getAttributeName());
			}
		return setMax;
	}

	/**
	 * Returns longest string in the operation list
	 * 
	 * @return
	 */
	public int getLongestOperation() {
		int max = 0;
		int setMax = 0;
		if (operations.size() > 0) {
			setMax = metrics.stringWidth("+ " + operations.get(max).getOperationName());
		}
		for (int i = 0; i < operations.size(); i++)
			if (metrics.stringWidth("+ " + operations.get(i).getOperationName()) >= metrics.stringWidth("+ " + operations
					.get(max).getOperationName())) {
				max = i;
				setMax = metrics.stringWidth("+ " + operations.get(max).getOperationName());
			}
		return setMax;
	}

	/**
	 * Sets a predetermined width for the object
	 * 
	 * @return
	 */
	public int setWidth() {
		int max = Math.max(metrics.stringWidth(name), getLongestAttribute());
		return Math.max(max, getLongestOperation());
	}
	
	/**
	 * Clone this class
	 * @return ClassObject clone
	 */
	
	public ClassObject copy() {
		String tempName = name;
		int tempX = xPos;
		int tempY = yPos;
		int tempType = type;
		int tempId = id;
		ClassObject tempClass = new ClassObject(tempName, tempX, tempY, tempType, manager);
		
		if(attributes.size() > 0) {
			for(int i = 0; i < attributes.size(); i++) {
				String tempAttributeName = attributes.get(i).getAttributeName();
				int tempAttributeVisibility = attributes.get(i).getVisibility();
				tempClass.addAttribute(tempAttributeName, tempAttributeVisibility);
			}
		}
		if(operations.size() > 0) {
			for(int i = 0; i < operations.size(); i++) {
				String tempOperationName = operations.get(i).getOperationName();
				int tempOperationVisibility = operations.get(i).getVisibility();
				tempClass.addOperation(tempOperationName, tempOperationVisibility);
			}
		}
		
		tempClass.setId(tempId);
		
		return tempClass;
		
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
