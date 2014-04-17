package models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.io.Serializable;

/**
 * Class that will hold information such as what type of relationship as well as
 * the ????
 * 
 * @author oRANGE
 */
public class Relationship implements Serializable {
	private ClassObject origin;
	private int originX;
	private int originY;

	private ClassObject destination;
	private int destinationX;
	private int destinationY;

	private int rType;

	/**
	 * Creates a new Relationship
	 * 
	 * @param origin
	 *            is the source class of the relationship
	 * @param destination
	 *            is the target class of the relationship
	 * @param originX
	 *            x-coordinate of origin class
	 * @param originY
	 *            y-coordinate of origin class
	 * @param destinationX
	 *            x-coordinate of destination class
	 * @param destinationX
	 *            y-coordinate of destination class
	 * @param relaType
	 *            relationship type.
	 */

	public Relationship(ClassObject originClass, ClassObject destinationClass,
			int relaType) {
		origin = originClass;
		originX = (origin.getWidth() / 2) + origin.getxPos();
		originY = (origin.getHeight() / 2) + origin.getyPos();

		destination = destinationClass;
		destinationX = (destination.getWidth() / 2) + destination.getxPos();
		destinationY = (destination.getHeight() / 2) + destination.getyPos();

		rType = relaType;

	}

	/**
     *
     */
	public void update() {
		originX = (origin.getWidth() / 2) + origin.getxPos();
		originY = (origin.getHeight() / 2) + origin.getyPos();

		destinationX = (destination.getWidth() / 2) + destination.getxPos();
		destinationY = (destination.getHeight() / 2) + destination.getyPos();
	}

	/**
	 * Returns information about the main class in a relationship
	 * 
	 * @return mainC - the main class
	 */
	public ClassObject getOrigin() {
		return origin;
	}

	/**
	 * Returns the x-coordinate of the main class
	 * 
	 * @return mX - x-coordinate of main class
	 */
	public int getOriginX() {
		return originX;
	}

	/**
	 * Returns y-coordinate of the main class
	 * 
	 * @return mY - y-coordinate of main class
	 */
	public int getOriginY() {
		return originY;
	}

	/**
	 * Returns the derived class in the relationship
	 * 
	 * @return derivedC - the derived class
	 */
	public ClassObject getDestination() {
		return destination;
	}

	/**
	 * Returns the x-coordinate of the derived class
	 * 
	 * @return dX - x-coordinate of derived class
	 */
	public int getDestinationX() {
		return destinationX;
	}

	/**
	 * Returns the y-coordinate of the derived class
	 * 
	 * @return dY - y coordinate of derived class
	 */
	public int getDestinationY() {
		return destinationY;
	}

	/**
	 * Return relationship type of the classes
	 * 
	 * @return rType - integer corresponding relationship type
	 */
	public int getRelationshipType() {
		return rType;
	}

	/**
	 * Sets main class to which ever class the user decides
	 * 
	 * @param mainC
	 *            - the class the user decides to be the main class
	 */
	public void setOrigin(ClassObject originClass) {
		this.origin = originClass;
	}

	/**
	 * Sets a predetermined x-coordinate for the main class
	 * 
	 * @param mX
	 *            - the new x-coordinate for the main class
	 */
	public void setOriginX(int oX) {
		this.originX = oX;
	}

	/**
	 * Sets a predetermined y-coordinate for the main class
	 * 
	 * @param mY
	 *            - new y-coordinate for the main class
	 */
	public void setOriginY(int oY) {
		this.originY = oY;
	}

	/**
	 * Set the derived class to be whichever the user wants
	 * 
	 * @param derivedC
	 *            - the derived class
	 */
	public void setDestination(ClassObject destinationClass) {
		this.destination = destinationClass;
	}

	/**
	 * Sets a predetermined x-coordinate for the derived class
	 * 
	 * @param dX
	 *            - new x-coordinate
	 */
	public void setDestinationX(int dX) {
		this.destinationX = dX;
	}

	/**
	 * Sets a predetermined y-coordinate for the derived class
	 * 
	 * @param dY
	 *            - the new y-coordinate
	 */
	public void setDestinationY(int dY) {
		this.destinationX = dY;
	}

	/**
	 * Sets the relationship type be the one chosen by the user
	 * 
	 * @param rType
	 *            - the relationship type
	 */
	public void setRelationshipType(int rType) {
		this.rType = rType;
	}

}
