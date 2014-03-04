/**
 * The Manager class is in charge of managing the objects lists.
 */

package gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import models.ClassObject;
import models.Relationship;

public class Manager {
	private static Manager sharedManager;
	private Gui gui;
	private JFrame frame;
	private ArrayList<ClassObject> classObjectList;
	private ArrayList<Relationship> relationList;
	
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

}
