

package gui;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;

import models.ClassObject;

/**
 * take in the all the classObjects from the Manager and will be
 * in charge of displaying them.
 * 
 * @author oRANGE
 *
 */
public class ClassObjectView {
	//private Manager manager;
	private static ClassObjectView sharedClassView;
	private Color theColor;
	private ArrayList<ClassObject> theList;
	
	
	
	public ClassObjectView(Manager manager) {
		//this.manager = manager;
		theColor = Color.orange;
		theList = manager.getClassObjectList();

	}
	
	/**
	 * This method will use the classObject list in manager to display the classObjects;
	 * @param g
	 */
	public void display(Graphics g) {
		for(int i = 0; i < theList.size(); i++)
		{
			g.setColor(new Color(0, 0, 0, 100));
			g.fillRect(theList.get(i).getxPos() + 3, theList.get(i).getyPos() + 3,
					theList.get(i).getWidth(), theList.get(i).getHeight());
			
			g.setColor(theColor);
			g.fillRect(theList.get(i).getxPos(), theList.get(i).getyPos(), 
					theList.get(i).getWidth(), theList.get(i).getHeight());
			
			g.setColor(Color.black);
			g.drawRect(theList.get(i).getxPos(), theList.get(i).getyPos(), 
					theList.get(i).getWidth(), 20);
			
			//Draw border for the attributes
			if(theList.get(i).getOperations().size() > 0 && theList.get(i).getAttributes().size() == 0)
			{
				g.drawRect(theList.get(i).getxPos(), theList.get(i).getyPos() + 20, theList.get(i).getWidth(), 20);
			}
			else
			{
				g.drawRect(theList.get(i).getxPos(), theList.get(i).getyPos() + 20, 
						theList.get(i).getWidth(), theList.get(i).getAttributes().size() * 20);
			}
			
			
			//Draw border for the operations
			if(theList.get(i).getOperations().size() > 0 && theList.get(i).getAttributes().size() == 0)
			{
				g.drawRect(theList.get(i).getxPos(), theList.get(i).getyPos() + 40, 
						theList.get(i).getWidth(), theList.get(i).getOperations().size() * 20);
			}
			else
			{
				g.drawRect(theList.get(i).getxPos(), 
						theList.get(i).getyPos() + (theList.get(i).getAttributes().size() * 20) + 20, 
						theList.get(i).getWidth(), theList.get(i).getOperations().size() * 20);
			}
		
			//Draw the name of the class
			g.setColor(Color.black);
			g.drawString(theList.get(i).getName(), theList.get(i).getxPos() + 5, theList.get(i).getyPos() + 15);
			
			//Draw the attributes
			for(int j = 0; j < theList.get(i).getAttributes().size(); j++)
			{
		    	switch (theList.get(i).getAttributes().get(j).getVisibility()) {
	    		case 0: g.drawString("+ " + theList.get(i).getAttributes().get(j).getAttributeName(), theList.get(i).getxPos() + 5,
						(theList.get(i).getyPos() +35) + (j * 20));
	    			break;
	    		case 1: g.drawString("- " + theList.get(i).getAttributes().get(j).getAttributeName(), theList.get(i).getxPos() + 5,
						(theList.get(i).getyPos() +35) + (j * 20));
	    			break;
	    		case 2: g.drawString("# " + theList.get(i).getAttributes().get(j).getAttributeName(), theList.get(i).getxPos() + 5,
						(theList.get(i).getyPos() +35) + (j * 20));
	    			break;
	    		case 3: g.drawString("~ " +theList.get(i).getAttributes().get(j).getAttributeName(), theList.get(i).getxPos() + 5,
						(theList.get(i).getyPos() +35) + (j * 20));
	    			break;
		    	} 
			}
			
			//Draw the operations
			if(theList.get(i).getOperations().size() > 0 && theList.get(i).getAttributes().size() == 0)
			{
				for(int j = 0; j < theList.get(i).getOperations().size(); j++)
				{
					switch (theList.get(i).getOperations().get(j).getVisibility()) {
					case 0: g.drawString("+ " + theList.get(i).getOperations().get(j).getOperationName(), theList.get(i).getxPos() + 5,
							(20 +(theList.get(i).getyPos() + 35)) + (j * 20) );
						break;
					case 1: g.drawString("- " + theList.get(i).getOperations().get(j).getOperationName(), theList.get(i).getxPos() + 5,
							(20 +(theList.get(i).getyPos() + 35)) + (j * 20) );
						break;
					case 2: g.drawString("# " + theList.get(i).getOperations().get(j).getOperationName(), theList.get(i).getxPos() + 5,
							(20 +(theList.get(i).getyPos() + 35)) + (j * 20) );
						break;
					case 3: g.drawString("~ " + theList.get(i).getOperations().get(j).getOperationName(), theList.get(i).getxPos() + 5,
							(20 +(theList.get(i).getyPos() + 35)) + (j * 20) );
						break;
					}
				}
			}
			else
			{
				for(int j = 0; j < theList.get(i).getOperations().size(); j++)
				{
					switch (theList.get(i).getOperations().get(j).getVisibility()) {
					case 0: g.drawString("+ " + theList.get(i).getOperations().get(j).getOperationName(),theList.get(i).getxPos() + 5,
							((theList.get(i).getAttributes().size() * 20) + (theList.get(i).getyPos() + 35)) + (j * 20));
						break;
					case 1: g.drawString("- " + theList.get(i).getOperations().get(j).getOperationName(),theList.get(i).getxPos() + 5,
							((theList.get(i).getAttributes().size() * 20) + (theList.get(i).getyPos() + 35)) + (j * 20));
						break;
					case 2: g.drawString("# " + theList.get(i).getOperations().get(j).getOperationName(),theList.get(i).getxPos() + 5,
							((theList.get(i).getAttributes().size() * 20) + (theList.get(i).getyPos() + 35)) + (j * 20));
						break;
					case 3: g.drawString("~ " + theList.get(i).getOperations().get(j).getOperationName(),theList.get(i).getxPos() + 5,
							((theList.get(i).getAttributes().size() * 20) + (theList.get(i).getyPos() + 35)) + (j * 20));
						break;
					}
				}
			}
			
			//Draw highlight is selected
			if(theList.get(i).isIsSelected())
			{
				for (int j = 0; j < 3; j++)
				{
					g.setColor(Color.DARK_GRAY);
					g.drawRect(theList.get(i).getxPos() + j, theList.get(i).getyPos() + j, 
							theList.get(i).getWidth(), theList.get(i).getHeight());
				}
			}
			
			
			
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
