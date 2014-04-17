/**
 * The Manager class is in charge of managing the objects lists.
 */

package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.undo.UndoManager;

import save.Datamodel;

import models.Attribute;
import models.ClassObject;
import models.ObjectController;
import models.Operation;
import models.Relationship;
import models.UndoRedoManager;

public class Manager {
	private static Manager sharedManager;
	private Gui gui;

	private ArrayList<ClassObject> classObjectList;
	private ArrayList<Relationship> relationList;
	private ArrayList<Integer> relationshipCandidates;
	private ArrayList<Attribute> addAttributeList;
	private ArrayList<Operation> addOperationList;

	// Declare the Undo/Redo manager
	private UndoRedoManager undoRedoManager;

	private ClassObjectView classView;
	private RelationshipView relationshipView;
	private ObjectController objController;

	private boolean canAddClass, tryRelationship;
	private int addClassX, addClassY, selectedAttribute, selectedOperation;

	private ClassObject tempClass;

	public Manager() {
		
		gui = new Gui(this);

		classObjectList = new ArrayList<ClassObject>();
		relationList = new ArrayList<Relationship>();
		relationshipCandidates = new ArrayList<Integer>();
		addAttributeList = new ArrayList<Attribute>();
		addOperationList = new ArrayList<Operation>();
		canAddClass = false;
		tryRelationship = false;

		undoRedoManager = new UndoRedoManager();
		objController = new ObjectController(this);
		classView = new ClassObjectView(this);
		relationshipView = new RelationshipView(this);
		selectedAttribute = -1;
		selectedOperation = -1;

	}

	/**
	 * This method makes sure only one instance of the Manager is created.
	 * 
	 * @return
	 */
	public static Manager sharedInstance() {
		if (sharedManager == null) {
			sharedManager = new Manager();
		}

		return sharedManager;
	}

	public void showAddClass() {
		gui.getAddClassDialog().setLocation(gui.getX() + 400, gui.getY() + 200);
		gui.getAddClassDialog().setVisible(true);
	}

	public void showAddAttribute() {
		gui.getAddAttributeDialog().setLocation(
				gui.getAddClassDialog().getX() + 50,
				gui.getAddClassDialog().getY() + 25);
		gui.getAddAttributeDialog().setVisible(true);
	}

	/**
	 * Will add an attribute or replace a selected one
	 */
	public void addAttribute() {
		if (selectedAttribute >= 0 && addAttributeList.size() > 0) {
			addAttributeList.get(selectedAttribute).setAttributeName(
					gui.getAddAttributeDialog().getAttributeNameTextField()
							.getText());
			addAttributeList.get(selectedAttribute).setVisibility(
					gui.getAddAttributeDialog().getAttributeTypeComboBox()
							.getSelectedIndex());
			String[] tempAttributeList;
			tempAttributeList = new String[addAttributeList.size()];
			for (int i = 0; i < addAttributeList.size(); i++) {
				switch (addAttributeList.get(i).getVisibility()) {
				case 0:
					tempAttributeList[i] = "+ "
							+ addAttributeList.get(i).getAttributeName();
					break;
				case 1:
					tempAttributeList[i] = "- "
							+ addAttributeList.get(i).getAttributeName();
					break;
				case 2:
					tempAttributeList[i] = "# "
							+ addAttributeList.get(i).getAttributeName();
					break;
				case 3:
					tempAttributeList[i] = "~ "
							+ addAttributeList.get(i).getAttributeName();
					break;
				}
			}
			gui.getAddClassDialog().getAttributesList()
					.setListData(tempAttributeList);
			gui.getAddAttributeDialog().getAttributeTypeComboBox()
					.setSelectedIndex(0);
			gui.getAddAttributeDialog().getAttributeNameTextField().setText("");
			gui.getAddAttributeDialog().dispose();
			selectedAttribute = -1;
		} else {
			String attribute = gui.getAddAttributeDialog()
					.getAttributeNameTextField().getText();
			String[] tempAttributeList;
			int type = gui.getAddAttributeDialog().getAttributeTypeComboBox()
					.getSelectedIndex();

			addAttributeList.add(new Attribute(attribute, type));
			tempAttributeList = new String[addAttributeList.size()];

			for (int i = 0; i < addAttributeList.size(); i++) {
				switch (addAttributeList.get(i).getVisibility()) {
				case 0:
					tempAttributeList[i] = "+ "
							+ addAttributeList.get(i).getAttributeName();
					break;
				case 1:
					tempAttributeList[i] = "- "
							+ addAttributeList.get(i).getAttributeName();
					break;
				case 2:
					tempAttributeList[i] = "# "
							+ addAttributeList.get(i).getAttributeName();
					break;
				case 3:
					tempAttributeList[i] = "~ "
							+ addAttributeList.get(i).getAttributeName();
					break;
				}
			}
			gui.getAddClassDialog().getAttributesList()
					.setListData(tempAttributeList);
			gui.getAddAttributeDialog().getAttributeTypeComboBox()
					.setSelectedIndex(0);
			gui.getAddAttributeDialog().getAttributeNameTextField().setText("");
			gui.getAddAttributeDialog().dispose();
		}
	}

	/**
	 * This method will remove an attribute from the potential attributes list
	 */
	public void removeAttribute() {
		String[] tempAttributeList;
		if (gui.getAddClassDialog().getAttributesList().getSelectedIndices().length > 0
				&& addAttributeList.size() > 0) {
			for (int i = 0; i < gui.getAddClassDialog().getAttributesList()
					.getSelectedIndices().length; i++) {
				addAttributeList.remove(gui.getAddClassDialog()
						.getAttributesList().getSelectedIndices()[0]);
			}
			tempAttributeList = new String[addAttributeList.size()];
			for (int i = 0; i < addAttributeList.size(); i++) {
				switch (addAttributeList.get(i).getVisibility()) {
				case 0:
					tempAttributeList[i] = "+ "
							+ addAttributeList.get(i).getAttributeName();
					break;
				case 1:
					tempAttributeList[i] = "- "
							+ addAttributeList.get(i).getAttributeName();
					break;
				case 2:
					tempAttributeList[i] = "# "
							+ addAttributeList.get(i).getAttributeName();
					break;
				case 3:
					tempAttributeList[i] = "~ "
							+ addAttributeList.get(i).getAttributeName();
					break;
				}
			}
			gui.getAddClassDialog().getAttributesList()
					.setListData(tempAttributeList);
		}
	}

	public void showEditAttribute() {
		if (gui.getAddClassDialog().getAttributesList().getSelectedIndex() >= 0) {
			selectedAttribute = gui.getAddClassDialog().getAttributesList()
					.getSelectedIndex();
			gui.getAddAttributeDialog()
					.getAttributeNameTextField()
					.setText(
							addAttributeList.get(selectedAttribute)
									.getAttributeName());
			gui.getAddAttributeDialog()
					.getAttributeTypeComboBox()
					.setSelectedIndex(
							addAttributeList.get(
									gui.getAddClassDialog().getAttributesList()
											.getSelectedIndex())
									.getVisibility());
			gui.getAddAttributeDialog().setLocation(
					gui.getAddClassDialog().getX() + 50,
					gui.getAddClassDialog().getY() + 25);
			gui.getAddAttributeDialog().setVisible(true);
		}
	}

	public void showAddOperation() {
		gui.getAddOperationDialog().setLocation(
				gui.getAddClassDialog().getX() + 50,
				gui.getAddClassDialog().getY() + 25);
		gui.getAddOperationDialog().setVisible(true);
	}

	/**
	 * This method will an an operation to the potential operations list
	 */
	public void addOperation() {
		if (selectedOperation >= 0 && addOperationList.size() > 0) {
			addOperationList.get(selectedOperation).setOperationName(
					gui.getAddOperationDialog().getOperationNameTextField()
							.getText());
			addOperationList.get(selectedOperation).setVisibility(
					gui.getAddOperationDialog().getOperationTypeComboBox()
							.getSelectedIndex());
			String[] tempOperationList;
			tempOperationList = new String[addOperationList.size()];
			for (int i = 0; i < addOperationList.size(); i++) {
				switch (addOperationList.get(i).getVisibility()) {
				case 0:
					tempOperationList[i] = "+ "
							+ addOperationList.get(i).getOperationName();
					break;
				case 1:
					tempOperationList[i] = "- "
							+ addOperationList.get(i).getOperationName();
					break;
				case 2:
					tempOperationList[i] = "# "
							+ addOperationList.get(i).getOperationName();
					break;
				case 3:
					tempOperationList[i] = "~ "
							+ addOperationList.get(i).getOperationName();
					break;
				}
			}
			gui.getAddClassDialog().getOperationsList()
					.setListData(tempOperationList);
			gui.getAddOperationDialog().getOperationTypeComboBox()
					.setSelectedIndex(0);
			gui.getAddOperationDialog().getOperationNameTextField().setText("");
			gui.getAddOperationDialog().dispose();
			selectedOperation = -1;
		} else {
			String operation = gui.getAddOperationDialog()
					.getOperationNameTextField().getText();
			String[] tempOperationList;
			int visibility = gui.getAddOperationDialog()
					.getOperationTypeComboBox().getSelectedIndex();

			addOperationList.add(new Operation(operation, visibility));
			tempOperationList = new String[addOperationList.size()];

			for (int i = 0; i < addOperationList.size(); i++) {
				switch (addOperationList.get(i).getVisibility()) {
				case 0:
					tempOperationList[i] = "+ "
							+ addOperationList.get(i).getOperationName();
					break;
				case 1:
					tempOperationList[i] = "- "
							+ addOperationList.get(i).getOperationName();
					break;
				case 2:
					tempOperationList[i] = "# "
							+ addOperationList.get(i).getOperationName();
					break;
				case 3:
					tempOperationList[i] = "~ "
							+ addOperationList.get(i).getOperationName();
					break;
				}
			}
			gui.getAddClassDialog().getOperationsList()
					.setListData(tempOperationList);
			gui.getAddOperationDialog().getOperationTypeComboBox()
					.setSelectedIndex(0);
			gui.getAddOperationDialog().getOperationNameTextField().setText("");
			gui.getAddOperationDialog().dispose();
		}
	}

	/**
	 * This method will remove an operaiton from the potential operations list
	 */
	public void removeOperation() {
		String[] tempOperationList;
		if (gui.getAddClassDialog().getOperationsList().getSelectedIndices().length > 0
				&& addOperationList.size() > 0) {
			for (int i = 0; i < gui.getAddClassDialog().getOperationsList()
					.getSelectedIndices().length; i++) {
				addOperationList.remove(gui.getAddClassDialog()
						.getOperationsList().getSelectedIndices()[0]);
			}
			tempOperationList = new String[addOperationList.size()];
			for (int i = 0; i < addOperationList.size(); i++) {
				switch (addOperationList.get(i).getVisibility()) {
				case 0:
					tempOperationList[i] = "+ "
							+ addOperationList.get(i).getOperationName();
					break;
				case 1:
					tempOperationList[i] = "- "
							+ addOperationList.get(i).getOperationName();
					break;
				case 2:
					tempOperationList[i] = "# "
							+ addOperationList.get(i).getOperationName();
					break;
				case 3:
					tempOperationList[i] = "~ "
							+ addOperationList.get(i).getOperationName();
					break;
				}
			}
			gui.getAddClassDialog().getOperationsList()
					.setListData(tempOperationList);
		}
	}

	public void showEditOperation() {
		if (gui.getAddClassDialog().getOperationsList().getSelectedIndex() >= 0) {
			selectedOperation = gui.getAddClassDialog().getOperationsList()
					.getSelectedIndex();
			gui.getAddOperationDialog()
					.getOperationNameTextField()
					.setText(
							addOperationList.get(selectedOperation)
									.getOperationName());
			gui.getAddOperationDialog()
					.getOperationTypeComboBox()
					.setSelectedIndex(
							addOperationList.get(
									gui.getAddClassDialog().getOperationsList()
											.getSelectedIndex())
									.getVisibility());
			gui.getAddOperationDialog().setLocation(
					gui.getAddClassDialog().getX() + 50,
					gui.getAddClassDialog().getY() + 25);
			gui.getAddOperationDialog().setVisible(true);
		}
	}

	public void showAddRelationshipDialog() {
		gui.getAddRelationshipDialog().setLocation(gui.getX() + 400,
				gui.getY() + 200);
		gui.getAddRelationshipDialog().setVisible(true);
	}

	public void createRelationship() {
		relationList.add(new Relationship(classObjectList
				.get(relationshipCandidates.get(0)), classObjectList
				.get(relationshipCandidates.get(1)), gui
				.getAddRelationshipDialog().getRelationshipsComboBox()
				.getSelectedIndex()));
		gui.getAddRelationshipDialog().getRelationshipsComboBox()
				.setSelectedIndex(0);
		relationshipCandidates.clear();
		tryRelationship = false;
		gui.getRelationshipButton().setSelected(false);
		gui.getAddRelationshipDialog().dispose();
	}

	/**
	 * This method will take the potential attributes and operations list along
	 * with user input from gui to make a class and add to the ClassObjectList
	 */
	public void addClass() {
		if (undoRedoManager.isRedoing()) {
			classObjectList.add(undoRedoManager.getClassObjectStack().pop());
			undoRedoManager.setRedoing(false);
		} else {
			String tempClassName = "";
			tempClassName = gui.getAddClassDialog().getClassNameTextField()
					.getText();
			gui.getAddClassDialog().getClassNameTextField().setText("");
			tempClass = new ClassObject(tempClassName, addClassX, addClassY,
					gui.getAddClassDialog().getClassTypeList()
							.getSelectedIndex());
			// Add all the attributes from the list
			for (int i = 0; i < addAttributeList.size(); i++) {
				tempClass.addAttribute(addAttributeList.get(i)
						.getAttributeName(), addAttributeList.get(i)
						.getVisibility());
			}
			addAttributeList.clear();

			// Add all the operations from the list
			for (int i = 0; i < addOperationList.size(); i++) {
				tempClass.addOperation(addOperationList.get(i)
						.getOperationName(), addOperationList.get(i)
						.getVisibility());
			}
			addOperationList.clear();

			classObjectList.add(tempClass);

			if (undoRedoManager.getRedo().size() > 0) {
				undoRedoManager.getRedo().pop();
			}
		}
		// Add to undo Manager
		undoRedoManager.addUndo(new Runnable() {
			@Override
			public void run() {
				if (classObjectList.size() > 0) {
					undoRedoManager.getClassObjectStack().push(
							classObjectList.get(classObjectList.size() - 1));
					undoRedoManager.addRedo(new Runnable() {
						@Override
						public void run() {
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
		gui.setEnabled(true);
		gui.getClassButton().setSelected(false);
		canAddClass = false;
		gui.getAddClassDialog().getAttributesList().setListData(new String[0]);
		gui.getAddClassDialog().getOperationsList().setListData(new String[0]);
		gui.getAddClassDialog().dispose();
		gui.getView().repaint();
	}

	/**
	 * This method will delete a class from the list
	 */
	public void deleteClass() {
		if (objController.getSelectedClassObject() >= 0) {
			undoRedoManager.getClassObjectStack()
					.push(classObjectList.get(objController
							.getSelectedClassObject()));
			classObjectList.remove(objController.getSelectedClassObject());
			undoRedoManager.getSelectedObjectStack().push(
					objController.getSelectedClassObject());
			objController.setSelectedClassObject(-1);
			undoRedoManager.setRedoing(false);
			if (undoRedoManager.getRedo().size() > 0) {
				undoRedoManager.getRedo().pop();
			}

			// Add to undo stack
			undoRedoManager.addUndo(new Runnable() {
				@Override
				public void run() {
					classObjectList.add(undoRedoManager
							.getSelectedObjectStack().peek(), undoRedoManager
							.getClassObjectStack().pop());
					classObjectList.get(
							undoRedoManager.getSelectedObjectStack().peek())
							.setIsSelected(false);
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
		// If we enter the method due to a redo
		if (undoRedoManager.isRedoing()) {
			undoRedoManager.getClassObjectStack().push(
					classObjectList.get(undoRedoManager
							.getSelectedObjectStack().peek()));
			classObjectList
					.remove(undoRedoManager.getClassObjectStack().peek());
			objController.setSelectedClassObject(-1);
			undoRedoManager.setRedoing(false);

			// Add to undo stack
			undoRedoManager.addUndo(new Runnable() {
				@Override
				public void run() {

					classObjectList.add(undoRedoManager
							.getSelectedObjectStack().peek(), undoRedoManager
							.getClassObjectStack().pop());
					classObjectList.get(
							undoRedoManager.getSelectedObjectStack().peek())
							.setIsSelected(false);
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
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				sharedInstance();
			}
		});
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

	public void setRelationshipCandidates(
			ArrayList<Integer> relationshipCandidates) {
		this.relationshipCandidates = relationshipCandidates;
	}

	public UndoRedoManager getUndoRedoManager() {
		return undoRedoManager;
	}
	/*
	 * Operations related to Saving
	 */
	public void SaveState () throws FileNotFoundException, IOException {
		
		Datamodel state = new Datamodel(classObjectList, relationList, relationshipCandidates);
		
		ObjectOutputStream scribe = new ObjectOutputStream (new FileOutputStream("UML.ser"));
		scribe.writeObject(state);
		scribe.close();
	}
	
	public void LoadState () throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Datamodel state = new Datamodel(classObjectList, relationList, relationshipCandidates);
		state.cleardata();
		ObjectInputStream scribe = new ObjectInputStream(new FileInputStream("UML.ser"));
		state = (Datamodel) scribe.readObject();
		scribe.close();
	}
}
