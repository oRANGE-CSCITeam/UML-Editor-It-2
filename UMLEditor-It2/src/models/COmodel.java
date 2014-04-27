package models;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class COmodel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String name;
	private static int id;
	private static int type;
	private static ArrayList<Attribute> attributes;
	private static ArrayList<Operation> operations;

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
	
	public static String getName(){
		return name;
	}
	
	public static int getId(){
		return id;
	}
	
	public static int getType(){
		return type;
	}
	
	public static ArrayList<Attribute> getAttributes(){
		return attributes;
	}
	
	public static ArrayList<Operation> getOperations(){
		return operations;
	}
	
	public static int getX(){
		return xPos;
	}
	
	public static int getY(){
		return yPos;
	}	
	
		
	public static Color getColor(){
		return color;
	}

	
}
