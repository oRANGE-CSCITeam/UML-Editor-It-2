package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import models.ClassObject;
import models.Relationship;

/**
 * The EditorPane is the container which will draw all of the 2D graphics of the
 * UML Editor. It has to maintain lists of the different types of objects it
 * holds.
 * 
 * @author oRANGE
 */
public class EditorView extends JPanel implements MouseListener,
		MouseMotionListener {

	private int xOffSet, yOffSet;
	private Manager manager;
	String stringTest;

	public EditorView(Manager manager) {
		this.manager = manager;
		addMouseListener(this);
		addMouseMotionListener(this);
		stringTest = "Click to insert Class Objects";
	}

	/**
	 * This method will update the position of a classObject being moved to a
	 * new location and will repaint the updated location
	 * 
	 * @param classObject
	 * @param x
	 * @param y
	 */
	private void moveClassObject(ClassObject classObject, int x, int y) {
		// Current classObject state, stored as final variables
		// to avoid repeat invocations of the same methods.
		final int CURR_X = classObject.getxPos();
		final int CURR_Y = classObject.getyPos();
		final int CURR_W = classObject.getWidth();
		final int CURR_H = classObject.getHeight();
		final int OFFSET = 1;

		if (((CURR_X != x) || (CURR_Y != y))
				&& (x > this.getX() && y > this.getY())) {

			// The classObject is moving, repaint background
			// over the old classObject location.
			repaint(CURR_X, CURR_Y, CURR_W + OFFSET, CURR_H + OFFSET);

			// Update coordinates.
			classObject.setxPos(x);
			classObject.setyPos(y);

			// Repaint the classObject at the new location.
			repaint(classObject.getxPos(), classObject.getxPos(),
					classObject.getWidth() + OFFSET, classObject.getHeight()
							+ OFFSET);
		}
	}

	/**
	 * This method repaints the EditorView as needed
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw All Relationship Lines
		manager.getRelationshipView().display(g);

		// Draw Text
		g.drawString(stringTest, 10, 20);

		// Draw All Class Objects
		manager.getClassView().display(g);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		stringTest = "Mouse Entered";

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		stringTest = "Mouse exited";

	}

	/**
	 * This method listens for where the mouse is pressed in the EditorView Then
	 * checks if it needs to select an object or allow dragging
	 */
	@Override
	public void mousePressed(MouseEvent me) {

		// Reset the selected object when clicked outside on white space
		if (manager.getObjController().getSelectedClassObject() >= 0
				&& manager.getClassObjectList().size() > 0) {
			manager.getClassObjectList()
					.get(manager.getObjController().getSelectedClassObject())
					.setIsSelected(false);
			manager.getObjController().setSelectedClassObject(-1);
			repaint();
		}
		
		//For bring the popUpmenu if right clicked
		if(me.isPopupTrigger()) {
			if(manager.getCopyObjectStack().isEmpty()) {
				manager.getGui().getPaste().setEnabled(false);
			} else {
				manager.getGui().getPaste().setEnabled(true);
			}
			manager.getGui().getDelete().setEnabled(false);
			manager.getGui().getCopy().setEnabled(false);
			
			manager.getGui().getPopUpMenu().show(me.getComponent(), me.getX(), me.getY());
			manager.setAddClassX(me.getX());
			manager.setAddClassY(me.getY());
		}
		repaint();
		

		// Get the X & Y if we are adding a class
		if (manager.isCanAddClass()) {
			manager.setAddClassX(me.getX());
			manager.setAddClassY(me.getY());
			manager.showAddClass();
		}

		for (int i = 0; i < manager.getClassObjectList().size(); i++) {
			// Find which class object is being selected in the list
			if ((me.getX() > manager.getClassObjectList().get(i).getxPos())
					&& (me.getY() > manager.getClassObjectList().get(i)
							.getyPos())
					&& (me.getX() < (manager.getClassObjectList().get(i)
							.getWidth() + manager.getClassObjectList().get(i)
							.getxPos()))
					&& (me.getY() < (manager.getClassObjectList().get(i)
							.getHeight())
							+ manager.getClassObjectList().get(i).getyPos())) {

				// Show the pop up menu and select
				if (me.isPopupTrigger()) {
					manager.getGui().getCopy().setEnabled(true);
					manager.getGui().getDelete().setEnabled(true);
					manager.getGui().getPopUpMenu()
							.show(me.getComponent(), me.getX(), me.getY());
					manager.getObjController().setIsDraggingWho(i);
					manager.getObjController().setSelectedClassObject(i);
					manager.getClassObjectList()
							.get(manager.getObjController()
									.getSelectedClassObject())
							.setIsSelected(true);
					repaint();
					// Else not a pop up menu, but select and allow dragging
				} else {
					manager.getObjController().setIsDraggingWho(i);
					manager.getObjController().setDragging(true);
					manager.getObjController().setSelectedClassObject(i);
					manager.getClassObjectList()
							.get(manager.getObjController()
									.getSelectedClassObject())
							.setIsSelected(true);
					xOffSet = me.getX()
							- manager.getClassObjectList().get(i).getxPos();
					yOffSet = me.getY()
							- manager.getClassObjectList().get(i).getyPos();

					// Try a relationship by adding candidates
					if (manager.isTryRelationship()
							&& manager.getRelationshipCandidates().size() == 0) {
						manager.getRelationshipCandidates().add(
								manager.getObjController()
										.getSelectedClassObject());
					} else if (manager.isTryRelationship()
							&& manager.getRelationshipCandidates().size() == 1) {
						manager.getRelationshipCandidates().add(
								manager.getObjController()
										.getSelectedClassObject());
						manager.showAddRelationshipDialog();
					}
					repaint();
				}

			}
			// Clear the relationship creation of clicked on white space
			if (i == (manager.getClassObjectList().size() - 1)
					&& manager.getObjController().getSelectedClassObject() == -1) {
				manager.getRelationshipCandidates().clear();
				manager.setTryRelationship(false);
				manager.getGui().getRelationshipButton().setSelected(false);
			}
		}

	}

	/**
	 * This method stops turns off dragging when the user lets go of the object
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		if (manager.getObjController().getIsDraggingWho() >= 0
				&& manager.getObjController().isDragging() == true) {
			manager.getObjController().setIsDraggingWho(-1);
			manager.getObjController().setDragging(false);
		}

		// For popUpMenu in other platforms
		for (int i = 0; i < manager.getClassObjectList().size(); i++) {
			// Find which class object is being selected in the list
			if ((me.getX() > manager.getClassObjectList().get(i).getxPos())
					&& (me.getY() > manager.getClassObjectList().get(i)
							.getyPos())
					&& (me.getX() < (manager.getClassObjectList().get(i)
							.getWidth() + manager.getClassObjectList().get(i)
							.getxPos()))
					&& (me.getY() < (manager.getClassObjectList().get(i)
							.getHeight())
							+ manager.getClassObjectList().get(i).getyPos())) {
				// Show the pop up menu and select
				if (me.isPopupTrigger()) {
					manager.getGui().getPopUpMenu()
							.show(me.getComponent(), me.getX(), me.getY());
					manager.getObjController().setIsDraggingWho(i);
					manager.getObjController().setSelectedClassObject(i);
					manager.getClassObjectList()
							.get(manager.getObjController()
									.getSelectedClassObject())
							.setIsSelected(true);
					repaint();
				}
			}
		}

	}

	/**
	 * This method calls the moveClassObject method and translates the location
	 * of the object is selected and being dragged
	 */
	@Override
	public void mouseDragged(MouseEvent evt) {
		if (manager.getClassObjectList().size() > 0
				&& manager.getObjController().getIsDraggingWho() >= 0
				&& manager.getObjController().isDragging()) {
			moveClassObject(
					manager.getClassObjectList().get(
							manager.getObjController().getIsDraggingWho()),
					evt.getX() - xOffSet, evt.getY() - yOffSet);
			repaint();
		}
		stringTest = "Dragged";

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		stringTest = "Moved";
	}
}