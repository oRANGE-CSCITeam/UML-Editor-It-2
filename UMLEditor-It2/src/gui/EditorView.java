package gui;

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
 * UML Editor. It has to maintain lists of the different types of objects it holds.
 * 
 * @author oRANGE
 */
public class EditorView extends JPanel implements MouseListener, MouseMotionListener{
	
	private boolean canAddClassObject, tryRelationship, isDragging, showPopUp, makeRelationship;
    private int isDraggingWho, selectedClassObject;
    private int xOffSet, yOffSet;
    
    private Manager manager;
    
    ArrayList<Integer> relationCandidates =  new ArrayList();

    public EditorView(Manager manager) {
    	this.manager = manager;
    	addMouseListener(this);
        //If the add class button toggled "on" this will be true and a new classObject can be added
        canAddClassObject = false;
        //This is to determine which of the classObjectes is being dragged in the List
        isDraggingWho = -1;
        isDragging = false;
        
        tryRelationship = false;
        
        selectedClassObject = -1;
        showPopUp = false;
    }

    /**
     * This method will update the position of a classObject being moved to a new location
     * and will repaint the updated location
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

        if ((CURR_X != x) || (CURR_Y != y)) {

            // The classObject is moving, repaint background 
            // over the old classObject location. 
            repaint(CURR_X, CURR_Y, CURR_W + OFFSET, CURR_H + OFFSET);

            // Update coordinates.
            classObject.setxPos(x);
            classObject.setyPos(y);

            // Repaint the classObject at the new location.
            repaint(classObject.getxPos(), classObject.getxPos(),
                    classObject.getWidth() + OFFSET,
                    classObject.getHeight() + OFFSET);
        }
    }

    /**
     * This method repaints the EditorView as needed
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw Text
        g.drawString("Click to insert Class Objects", 10, 20);

        //Draw All Relationship Lines
        manager.getClassView().display(g);
        
        //Draw All Class Objects
        manager.getRelationshipView().display(g);
        
    }

    //This method toggles if a new Class object can be added
    public void toggleCanAddClassObject() {
        if (!canAddClassObject) {
            canAddClassObject = true;
        } else {
            canAddClassObject = false;
        }
    }

    public boolean isShowPopUp() {
        return showPopUp;
    }

    public int getIsDraggingWho() {
        return isDraggingWho;
    }

    public void setIsDraggingWho(int isDraggingWho) {
        this.isDraggingWho = isDraggingWho;
    }
    
    
    public void togglePopUp() {
        if (!showPopUp) {
            showPopUp = true;
        } else {
            showPopUp = false;
        }
    }
    
        public void toggleTryRelation() {
        if (!tryRelationship) {
            tryRelationship = true;
        } else {
            tryRelationship = false;
        }
    }

    public boolean isCanAddClassObject() {
        return canAddClassObject;
    }

    public boolean isIsDragging() {
        return isDragging;
    }

    public void setIsDragging(boolean isDragging) {
        this.isDragging = isDragging;
    }

    public int getSelectedClassObject() {
        return selectedClassObject;
    }

    public void setSelectedClassObject(int selectedClassObject) {
        this.selectedClassObject = selectedClassObject;
    }

    public boolean isTryRelationship() {
        return tryRelationship;
    }

    public void setTryRelationship(boolean tryRelationship) {
        this.tryRelationship = tryRelationship;
    }

    public boolean isMakeRelationship() {
        return makeRelationship;
    }

    public void setMakeRelationship(boolean makeRelationship) {
        this.makeRelationship = makeRelationship;
    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
        
		if(selectedClassObject >= 0 && manager.getClassObjectList().size() > 0){
            manager.getClassObjectList().get(selectedClassObject).setIsSelected(false);
            selectedClassObject = -1;
            repaint();
        }
        
        for (int i = 0; i < manager.getClassObjectList().size(); i++) {
            if ((me.getX() > manager.getClassObjectList().get(i).getxPos())
                    && (me.getY() > manager.getClassObjectList().get(i).getyPos())
                    && (me.getX() < (manager.getClassObjectList().get(i).getWidth() + manager.getClassObjectList().get(i).getxPos()))
                    && (me.getY() < (manager.getClassObjectList().get(i).getHeight()) + manager.getClassObjectList().get(i).getyPos())) {
                if(me.isPopupTrigger()) {
                    togglePopUp();
                    isDraggingWho = i;
                    selectedClassObject = i;
                    manager.getClassObjectList().get(selectedClassObject).setIsSelected(true);
                    repaint();
                } else {
                    isDraggingWho = i;
                    isDragging = true;
                    selectedClassObject = i;
                    manager.getClassObjectList().get(selectedClassObject).setIsSelected(true);
                    xOffSet = me.getX() - manager.getClassObjectList().get(i).getxPos();
                    yOffSet = me.getY() - manager.getClassObjectList().get(i).getyPos();
                    repaint();
                }
            }
        }
	}

	@Override
	public void mouseReleased(MouseEvent me) {
        if(isDraggingWho >= 0 && isDragging == true) {
            isDraggingWho = -1;
            isDragging = false;
        }
		
	}

	@Override
	public void mouseDragged(MouseEvent evt) {
        if (manager.getClassObjectList().size() > 0 && isDraggingWho >= 0 && isDragging == true) {
            moveClassObject(manager.getClassObjectList().get(isDraggingWho), evt.getX() - xOffSet, evt.getY() - yOffSet);
            repaint(); 
        }
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
 
}
