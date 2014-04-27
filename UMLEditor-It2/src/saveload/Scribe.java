package saveload;

import gui.Manager;

import java.awt.Color;
import java.util.ArrayList;

import models.Attribute;
import models.ClassObject;
import models.COmodel;
import models.Operation;
import models.RLmodel;
import models.Relationship;

public class Scribe {
	private ArrayList<COmodel> scribeListC = new ArrayList<COmodel>();
	private ArrayList<RLmodel> scribeListR = new ArrayList<RLmodel>();
	private ArrayList<ClassObject> managerListC = new ArrayList<ClassObject>();
	private ArrayList<Relationship> managerListR = new ArrayList<Relationship>();
	private Manager manager;

	public Scribe(Manager m) {
		this.manager = m;
		managerListC = manager.getClassObjectList();
		managerListR = manager.getRelationList();

	}

	private void serialConverter() {
		/**
		 * Creates a COmodel that holds all the key data in ClassObject for
		 * serialization Very simple method, just sets all the constructor
		 * variables to their ClassObject equivalent and then adds the newly
		 * constructed COmodel to an ArrayList for serialization.
		 * 
		 * Then repeats for Relationship to RLmodel.
		 */

		scribeListC.clear();
		scribeListR.clear();

		// ClassObject Variables to be stored
		String name;
		int id;
		int type;
		ArrayList<Attribute> attributes;
		ArrayList<Operation> operations;
		int xPos;
		int yPos;		
		Color color;

		/*
		 * Walks the list of Classobjects and extracts the information for
		 * storage in a serializable CLmodel
		 */

		for (int i = 0; i < managerListC.size(); i++) {
			ClassObject sourceCO = managerListC.get(i);
			name = sourceCO.getName();
			id = sourceCO.getId();
			type = sourceCO.getType();
			attributes = sourceCO.getAttributes();
			operations = sourceCO.getOperations();
			xPos = sourceCO.getxPos();
			yPos = sourceCO.getyPos();			
			color = sourceCO.getColor();

			COmodel targetCLM = new COmodel(name, id, type, attributes,
					operations, xPos, yPos, color);
			scribeListC.add(targetCLM);
		}

		// Relationship Variables to be stored, works as the above loop.
		int oID;
		int dID;
		int typeR;
		for (int i = 0; i < managerListR.size(); i++) {
			Relationship sourceRL = managerListR.get(i);
			oID = sourceRL.getOriginId();
			dID = sourceRL.getDestinationId();
			typeR = sourceRL.getRelationshipType();
			RLmodel targetRLM = new RLmodel(oID, dID, typeR);
			scribeListR.add(targetRLM);
		}

	}

	private void deserialConverter() {
		/**
		 * Creates a ClassObject that holds all the key data in each COmodel
		 * 
		 * Then repeats for RLmodel to Relationship.
		 */

		managerListC.clear();
		managerListR.clear();

		// ClassObject Variables to be stored
		String name;
		int id;
		int type;
		ArrayList<Attribute> attributes;
		ArrayList<Operation> operations;
		int xPos;
		int yPos;
		int width;
		int height;
		Color color;

		/*
		 * Walks the list of Classobjects and extracts the information for
		 * storage in a serializable CLmodel
		 */

		for (int i = 0; i < scribeListC.size(); i++) {

			COmodel sourceCO = scribeListC.get(i);
			// Constructor Variables
			name = sourceCO.getName();
			xPos = sourceCO.getX();
			yPos = sourceCO.getY();
			type = sourceCO.getType();
			// Non-Constructor information
			id = sourceCO.getId();
			color = sourceCO.getColor();
			attributes = sourceCO.getAttributes();
			operations = sourceCO.getOperations();

			ClassObject newCL = new ClassObject(name, xPos, yPos, type, manager);
			// Setting Non-Constructor information
			newCL.setId(id);
			newCL.setColor(color);
			for (int j = 0; j < attributes.size(); j++) {
				newCL.addAttribute(attributes.get(j).getAttributeName(),
						attributes.get(j).getVisibility());
			}
			for (int j = 0; j < operations.size(); j++) {
				newCL.addOperation(operations.get(j).getOperationName(),
						operations.get(j).getVisibility());
			}

			managerListC.add(newCL);
		}

		// Relationship Variables to be stored, works as the above loop.
		int oID;
		int dID;
		int typeR;
		for (int i = 0; i < scribeListR.size(); i++) {

			RLmodel sourceRL = scribeListR.get(i);
			oID = RLmodel.getOriginId();
			dID = RLmodel.getDestinationId();
			typeR = RLmodel.getType();
			
			ClassObject origin = CLSeeker(oID);
			ClassObject destination = CLSeeker(dID);

//			Relationship sourceRL = sourceListR.get(i);
//			oID = sourceRL.getOriginId();
//			dID = sourceRL.getDestinationId();
//			typeR = sourceRL.getRelationshipType();
//			RLmodel targetRLM = new RLmodel(oID, dID, typeR);
//			targetListR.add(targetRLM);
		}

	}

	private ClassObject CLSeeker(int oID) {
		// TODO Auto-generated method stub
		return null;
	}

}
