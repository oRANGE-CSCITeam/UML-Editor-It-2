package gui;

import javax.swing.JFrame;

public class Manager {
	private static Manager sharedManager;
	private Gui gui;
	private JFrame frame;
	
	public Manager() {
   	    //Set the look and feel (for Macs too).
		if (System.getProperty("mrj.version") != null) {
			System.setProperty("apple.laf.useScreenMenuBar","true");
		}
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        frame = new JFrame("UML Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui = new Gui(this, frame);
        frame.pack();
        frame.setVisible(true);
        
	}
	
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
