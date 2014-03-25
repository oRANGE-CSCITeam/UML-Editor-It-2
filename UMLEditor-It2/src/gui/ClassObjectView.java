

package gui;

import java.awt.Color;
import java.awt.Graphics;

/**
 * take in the all the classObjects from the Manager and will be
 * in charge of displaying them.
 * 
 * @author oRANGE
 *
 */
public class ClassObjectView {
	private Manager manager;
	private static ClassObjectView sharedClassView;
	private Color theColor;
	
	
	
	public ClassObjectView(Manager manager) {
		this.manager = manager;
		theColor = Color.orange;

	}
	
	/**
	 * This method will use the classObject list in manager to display the classObjects;
	 * @param g
	 */
	public void display(Graphics g) {
		for(int i = 0; i < manager.getClassObjectList().size(); i++)
		{
			g.setColor(new Color(0, 0, 0, 100));
			g.fill3DRect(manager.getClassObjectList().get(i).getxPos() + 3, manager.getClassObjectList().get(i).getyPos() + 3,
					manager.getClassObjectList().get(i).getWidth(), manager.getClassObjectList().get(i).getHeight(),
					true);
			g.setColor(theColor);
			
			g.fillRect(manager.getClassObjectList().get(i).getxPos(), manager.getClassObjectList().get(i).getyPos(), 
					manager.getClassObjectList().get(i).getWidth(), manager.getClassObjectList().get(i).getHeight());
			
			g.setColor(Color.black);
			g.drawRect(manager.getClassObjectList().get(i).getxPos(), manager.getClassObjectList().get(i).getyPos(), 
					manager.getClassObjectList().get(i).getWidth(), 20);
			
			
		
			
			
			
		}
		
		
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
