package models;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class COmodel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private int type;
	private ArrayList<Attribute> attributes;
	private ArrayList<Operation> operations;

	private static int xPos;
	private static int yPos;
	private static Color color;

	public COmodel(String n, int i, int t, ArrayList<Attribute> a,
			ArrayList<Operation> o, int x, int y, Color c) {
		
		name = n;
		id = i;
		type = t;
		attributes = a;
		operations = o;
		xPos = x;
		yPos = y;
		color = c;

	}
	
	public String getName(){
		return name;
	}
	
	public int getId(){
		return id;
	}
	
	public int getType(){
		return type;
	}
	
	public ArrayList<Attribute> getAttributes(){
		return attributes;
	}
	
	public ArrayList<Operation> getOperations(){
		return operations;
	}
	
	public int getX(){
		return xPos;
	}
	
	public int getY(){
		return yPos;
	}	
	
		
	public Color getColor(){
		return color;
	}

	
}
