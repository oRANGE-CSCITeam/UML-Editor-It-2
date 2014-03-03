/**
 * classObjectView is a class that will take in the all the classObjects from the Manager and will be
 * in charge of display them.
 */

package gui;

import java.awt.Graphics;

public class ClassObjectView {
	private Manager manager;
	private static ClassObjectView sharedClassView;
	
	public ClassObjectView(Manager manager) {
		this.manager = manager;

	}
	
	/**
	 * This method will use the classObject list in manager to display the classObjects;
	 * @param g
	 */
	public void display(Graphics g) {
		
	}
	
	/**
	 * This method makes sure that only one instance of the classObjectView is created
	 * as a singleton.
	 * @param manager
	 * @return
	 */
	public static ClassObjectView sharedInstance(Manager manager) {
		if(sharedClassView == null) {
			sharedClassView = new ClassObjectView(manager);
		}
		return sharedClassView;	
	}

}
