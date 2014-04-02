/**
 * The Manager class is in charge of managing the objects lists.
 */

package gui;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.undo.UndoManager;

import models.ClassObject;
import models.ObjectController;
import models.Relationship;
import models.UndoRedoManager;

public class Manager {
	private static Manager sharedManager;
	private Gui gui;
	
	private ArrayList<ClassObject> classObjectList;
	private ArrayList<Relationship> relationList;
	private ArrayList<Integer> relationshipCandidates;
	
	//Declare the Undo/Redo manager
	private UndoRedoManager undoRedoManager;	
	
	private ClassObjectView classView;
	private RelationshipView relationshipView;
	private ObjectController objController;
	
	private boolean canAddClass, tryRelationship;
	private int addClassX, addClassY;
	
	private ClassObject tempClass;
	
	public Manager() {
		
        
        gui = new Gui(this);
        
        classObjectList = new ArrayList<ClassObject>();
        relationList = new ArrayList<Relationship>();
        relationshipCandidates = new ArrayList<Integer>();
        canAddClass = false;
        tryRelationship = false;
        
        undoRedoManager = new UndoRedoManager();
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
	
	public void showAddClass() {
		gui.getAddClassDialog().setVisible(true);
	}
	public void showAddAttribute() {
		gui.getAddAttributeDialog().setVisible(true);
	}
	
	/**
	 * 
	 */
	public void addClass() {
		if(undoRedoManager.isRedoing()) {
			classObjectList.add(undoRedoManager.getClassObjectStack().pop());
			undoRedoManager.setRedoing(false);
		} else {
			String tempClassName = "";
			tempClassName = gui.getAddClassDialog().getjTextField1().getText();
			gui.getAddClassDialog().getjTextField1().setText("");
			tempClass = new ClassObject(tempClassName, addClassX, addClassY, 0);
			classObjectList.add(tempClass);
			
			if(undoRedoManager.getRedo().size() > 0) {
				undoRedoManager.getRedo().pop();
			}
		}
		//Add to undo Manager
		undoRedoManager.addUndo(new Runnable(){
			@Override
			public void run(){
				if(classObjectList.size() > 0)
				{
					undoRedoManager.getClassObjectStack().push(classObjectList.get(classObjectList.size() - 1));
					undoRedoManager.addRedo(new Runnable(){
						@Override
						public void run(){
							undoRedoManager.setRedoing(true);
							addClass();
							gui.getView().repaint();				
						}
					});
					classObjectList.remove(classObjectList.size() - 1);
					gui.getView().repaint();
				}
			}
		});
		gui.getClassButton().setSelected(false);
		canAddClass = false;
		gui.getAddClassDialog().dispose();
		gui.getView().repaint();
	}
	/**
	 * 
	 */
	public void deleteClass() {
		if(objController.getSelectedClassObject() >= 0) {
			undoRedoManager.getClassObjectStack().push(classObjectList.get(objController.getSelectedClassObject()));
			classObjectList.remove(objController.getSelectedClassObject());
			undoRedoManager.getSelectedObjectStack().push(objController.getSelectedClassObject());
			objController.setSelectedClassObject(-1);
			undoRedoManager.setRedoing(false);
			if(undoRedoManager.getRedo().size() > 0) {
				undoRedoManager.getRedo().pop();
			}
			
			//Add to undo stack
			undoRedoManager.addUndo(new Runnable(){
				@Override
				public void run(){	
					classObjectList.add(undoRedoManager.getSelectedObjectStack().peek(),undoRedoManager.getClassObjectStack().pop());
					classObjectList.get(undoRedoManager.getSelectedObjectStack().peek()).setIsSelected(false);
					gui.getView().repaint();
					undoRedoManager.addRedo(new Runnable() {
						@Override
						public void run() {
							undoRedoManager.setRedoing(true);
							deleteClass();
							gui.getView().repaint();
						}
					});
				}
			});
			gui.getView().repaint();
		}
		//If we enter the method due to a redo
		if(undoRedoManager.isRedoing()) {
			undoRedoManager.getClassObjectStack().push(classObjectList.get(undoRedoManager.getSelectedObjectStack().peek()));
			classObjectList.remove(undoRedoManager.getClassObjectStack().peek());
			objController.setSelectedClassObject(-1);
			undoRedoManager.setRedoing(false);
			
			//Add to undo stack
			undoRedoManager.addUndo(new Runnable(){
				@Override
				public void run(){
					
					classObjectList.add(undoRedoManager.getSelectedObjectStack().peek(), undoRedoManager.getClassObjectStack().pop());
					classObjectList.get(undoRedoManager.getSelectedObjectStack().peek()).setIsSelected(false);
					gui.getView().repaint();
					
					undoRedoManager.addRedo(new Runnable() {
						@Override
						public void run() {
							undoRedoManager.setRedoing(true);
							deleteClass();
							gui.getView().repaint();
						}
					});
				}
			});
			gui.getView().repaint();
		}
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

	public boolean isCanAddClass() {
		return canAddClass;
	}

	public void setCanAddClass(boolean canAddClass) {
		this.canAddClass = canAddClass;
	}

	public int getAddClassX() {
		return addClassX;
	}

	public void setAddClassX(int addClassX) {
		this.addClassX = addClassX;
	}

	public int getAddClassY() {
		return addClassY;
	}

	public void setAddClassY(int addClassY) {
		this.addClassY = addClassY;
	}

	public boolean isTryRelationship() {
		return tryRelationship;
	}

	public void setTryRelationship(boolean tryRelationship) {
		this.tryRelationship = tryRelationship;
	}

	public ArrayList<Integer> getRelationshipCandidates() {
		return relationshipCandidates;
	}

	public void setRelationshipCandidates(ArrayList<Integer> relationshipCandidates) {
		this.relationshipCandidates = relationshipCandidates;
	}

	public UndoRedoManager getUndoRedoManager() {
		return undoRedoManager;
	}
	
}
