package saveload;

import java.awt.Color;
import java.util.ArrayList;

import models.Attribute;
import models.ClassObject;
import models.COmodel;
import models.Operation;
import models.Relationship;

public class Scribe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<COmodel> classObjectConverter(ArrayList<ClassObject> cList) {

		ArrayList<COmodel> dList = new ArrayList<COmodel>();
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

		for (int i = 0; i < cList.size(); i++) {
			ClassObject source = cList.get(i);
			name = source.getName();
			id = source.getId();
			type = source.getType();
			attributes = source.getAttributes();
			operations = source.getOperations();
			xPos = source.getxPos();
			yPos = source.getyPos();
			width = source.getWidth();
			height = source.getHeight();
			color = source.getColor();

			COmodel target = new COmodel(name, id, type, attributes,
					operations, xPos, yPos, width, height, color);
			dList.add(target);
		}

		return dList;

	}

}
