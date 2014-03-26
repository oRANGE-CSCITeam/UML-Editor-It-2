/**
 * The Manager class is in charge of managing the objects lists.
 */

package gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import models.ClassObject;
import models.ObjectController;
import models.Relationship;

public class Manager {
	private static Manager sharedManager;
	private Gui gui;
	private JFrame frame;
	private ArrayList<ClassObject> classObjectList;
	private ArrayList<Relationship> relationList;
	private ClassObjectView classView;
	private RelationshipView relationshipView;
	private ObjectController objController;
	
	public Manager() {
   	    //Set the look and feel (for Macs too).
		if (System.getProperty("mrj.version") != null) {
			System.setProperty("apple.laf.useScreenMenuBar","true");
		}
        
        frame = new JFrame("UML Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui = new Gui(this, frame);
        frame.pack();
        frame.setVisible(true);
        
        objController = new ObjectController(this);
        classView = new ClassObjectView(this);
        relationshipView = new RelationshipView(this);
        
        
	}
	
	/**
	 * This method makes sure only one instance of the Manager is created.
	 * @return
	 */
	public static Manager sharedInstance() {
		if(sharedManager == null) {
			sharedManager = new Manager();
		}
		
		return sharedManager;
	}
	
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
       	new Runnable() {
           	public void run() {
           		sharedInstance();
           	}
       	}
       );
	}

	public Gui getGui() {
		return gui;
	}

	public void setGui(Gui gui) {
		this.gui = gui;
	}

	public ArrayList<ClassObject> getClassObjectList() {
		return classObjectList;
	}

	public void setClassObjectList(ArrayList<ClassObject> classObjectList) {
		this.classObjectList = classObjectList;
	}

	public ArrayList<Relationship> getRelationList() {
		return relationList;
	}

	public void setRelationList(ArrayList<Relationship> relationList) {
		this.relationList = relationList;
	}

	public ClassObjectView getClassView() {
		return classView;
	}

	public void setClassView(ClassObjectView classView) {
		this.classView = classView;
	}

	public RelationshipView getRelationshipView() {
		return relationshipView;
	}

	public void setRelationshipView(RelationshipView relationshipView) {
		this.relationshipView = relationshipView;
	}

	public ObjectController getObjController() {
		return objController;
	}

	public void setObjController(ObjectController objController) {
		this.objController = objController;
	}
	
	

}
