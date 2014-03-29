package models;
import java.util.Stack;

/**
* @author oRange
* This is the UndoRedoManager that will handle the information necessary to keep * track of doing and undoing actions. 
* Whenever you push an undo runnable that undoes the action, that runnable should also push a redo runnable within it
* that would call the original action method if possible or a similar method.
*
**/


public class UndoRedoManager {
	//For saving classObjects that could potentially be recreated with a redo
	private Stack<ClassObject> classObjectStack;
	
	//For saving the location of a deleted class Object, typically used for a redo
	private Stack<Integer> selectedObjectStack;
	
	//These are the runnable stacks
	private Stack<Runnable> undo;
	private Stack<Runnable> redo;
	
	public UndoRedoManager() {
		
		classObjectStack = new Stack<ClassObject>();
		selectedObjectStack = new Stack<Integer>();
		undo = new Stack<Runnable>();
		redo = new Stack<Runnable>();
	}
	
	public void undo() {
		if(undo.size() > 0) {
			undo.pop().run();
		}
	}
	
	public void redo() {
		if(redo.size() > 0) {
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
}