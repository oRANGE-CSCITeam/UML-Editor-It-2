package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Datamodel implements Serializable {
	
	private String name;
	private int id;
	private ArrayList<Attribute> attributes;
	private ArrayList<Operation> operations;

	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	
}
