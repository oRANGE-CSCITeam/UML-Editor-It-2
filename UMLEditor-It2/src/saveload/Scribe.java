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
	private ArrayList<COmodel> targetListC = new ArrayList<COmodel>();
	private ArrayList<RLmodel> targetListR = new ArrayList<RLmodel>();
	private ArrayList<ClassObject> sourceListC = new ArrayList<ClassObject>();
	private ArrayList<Relationship> sourceListR = new ArrayList<Relationship>();
	private Manager manager;

	public Scribe(Manager m) {
		this.manager = m;
		sourceListC = manager.getClassObjectList();
		sourceListR = manager.getRelationList();

	}

	public void serialConverter() {
		/**
		 * Creates a COmodel that holds all the key data in ClassObject for
		 * serialization Very simple method, just sets all the constructor
		 * variables to their ClassObject equivalent and then adds the newly
		 * constructed COmodel to an ArrayList for serialization.
		 * 
		 * Then repeats for Relationship to RLmodel.
		 */

		targetListC.clear();
		targetListR.clear();

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

		for (int i = 0; i < sourceListC.size(); i++) {
			ClassObject sourceCO = sourceListC.get(i);
			name = sourceCO.getName();
			id = sourceCO.getId();
			type = sourceCO.getType();
			attributes = sourceCO.getAttributes();
			operations = sourceCO.getOperations();
			xPos = sourceCO.getxPos();
			yPos = sourceCO.getyPos();
			width = sourceCO.getWidth();
			height = sourceCO.getHeight();
			color = sourceCO.getColor();

			COmodel targetCLM = new COmodel(name, id, type, attributes,
					operations, xPos, yPos, width, height, color);
			targetListC.add(targetCLM);
		}
		
		
		//Relationship Variables to be stored
		int oID;
		int dID;
		int typeR;
		for (int i = 0; i < sourceListR.size(); i++){
			Relationship sourceRL = sourceListR.get(i);
			oID = sourceRL.getOriginId();
			dID = sourceRL.getDestinationId();
			typeR = sourceRL.getRelationshipType();
			RLmodel targetRLM = new RLmodel(oID, dID, typeR);
			targetListR.add(targetRLM);
		}

	}

}
