/**
 * This Class is in charge of drawing the Relationships it will use the manager to get the 
 * data from the Relationships in Manager
 */

package gui;

import java.awt.Graphics;

public class RelationshipView {
	private Manager manager;
	private static RelationshipView sharedRelationView;
	
	public RelationshipView(Manager manager) {
		this.manager = manager;
	}
	
	/**
	 * This method will use the Relationship list in manager to display the classObjects;
	 * @param g
	 */
	public void display(Graphics g) {
		
	}
	
	/**
	 * This method makes sure that only one instance of the RelationshipView is created
	 * as a singleton.
	 * @param manager
	 * @return
	 */
	public static RelationshipView sharedInstance(Manager manager) {
		if(sharedRelationView == null) {
			sharedRelationView = new RelationshipView(manager);
		}
		return sharedRelationView;	
	}

}
