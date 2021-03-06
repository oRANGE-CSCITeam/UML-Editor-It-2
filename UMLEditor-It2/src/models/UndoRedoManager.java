package models;

import java.util.Stack;

/**
 * @author oRange This is the UndoRedoManager that will handle the information
 *         necessary to keep * track of doing and undoing actions. Whenever you
 *         push an undo runnable that undoes the action, that runnable should
 *         also push a redo runnable within it that would call the original
 *         action method if possible or a similar method.
 * 
 **/

public class UndoRedoManager {
	// For saving classObjects that could potentially be recreated with a redo
	private Stack<ClassObject> classObjectStack;

	// For saving the location of a deleted class Object, typically used for a
	// redo
	private Stack<Integer> selectedObjectStack;
	
	private Stack<Relationship> relationshipStack;

	// These are the runnable stacks
	private Stack<Runnable> undo;
	private Stack<Runnable> redo;
	
	private int deletedRelationships;
	private int editedClassIndex;

	private boolean redoing;

	public UndoRedoManager() {

		classObjectStack = new Stack<ClassObject>();
		selectedObjectStack = new Stack<Integer>();
		relationshipStack = new Stack<Relationship>();
		undo = new Stack<Runnable>();
		redo = new Stack<Runnable>();
		redoing = false;
		deletedRelationships = 0;
		editedClassIndex = 0;
		
		
	}

	public void undo() {
		if (undo.size() > 0) {
			undo.pop().run();
		}
	}

	public void redo() {
		if (redo.size() > 0) {
			redo.pop().run();
		}
	}

	public void addUndo(Runnable runnable) {
		undo.push(runnable);
	}

	public void addRedo(Runnable runnable) {
		redo.push(runnable);
	}

	public Stack<Runnable> getUndo() {
		return undo;
	}

	public Stack<Runnable> getRedo() {
		return redo;
	}

	public Stack<ClassObject> getClassObjectStack() {
		return classObjectStack;
	}

	public Stack<Integer> getSelectedObjectStack() {
		return selectedObjectStack;
	}

	public boolean isRedoing() {
		return redoing;
	}

	public void setRedoing(boolean redoing) {
		this.redoing = redoing;
	}

	public Stack<Relationship> getRelationshipStack() {
		return relationshipStack;
	}

	public int getDeletedRelationships() {
		return deletedRelationships;
	}

	public void setDeletedRelationships(int deletedRelationships) {
		this.deletedRelationships = deletedRelationships;
	}

	public int getEditedClassIndex() {
		return editedClassIndex;
	}

	public void setEditedClassIndex(int editedClassIndex) {
		this.editedClassIndex = editedClassIndex;
	}
	
	
}


