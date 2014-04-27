package saveload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import models.Attribute;
import models.ClassObject;
import models.Operation;
import models.Relationship;

public class LoadOnly {

	/**
	 * @param args
	 */

	private static ArrayList<ClassObject> classObjectList = new ArrayList<ClassObject>();
	private static ArrayList<Relationship> relationList = new ArrayList<Relationship>();
	private static ArrayList<ClassObject> classObjectList2 = new ArrayList<ClassObject>();
	private static ArrayList<Relationship> relationList2 = new ArrayList<Relationship>();
	private static String path = "UML.ser";

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

//		// create two test Classobjects
//		ClassObject target1 = new ClassObject("There", 10, 10, 0);
//		target1.addOperation("1-Oper1", 0);
//		target1.addOperation("1-Oper2", 0);
//		target1.addOperation("1-Oper3", 0);
//		target1.addAttribute("1-Atrib1", 0);
//		target1.addAttribute("1-Atrib2", 0);
//		target1.addAttribute("1-Atrib3", 0);
//		target1.addAttribute("1-LongAtrib", 0);
//
//		ClassObject target2 = new ClassObject("Here", 20, 20, 0);
//		target2.addOperation("2-Oper1", 0);
//		target2.addOperation("2-Oper2", 0);
//		target2.addOperation("2-Oper3", 0);
//		target2.addAttribute("2-Atrib1", 0);
//		target2.addAttribute("2-Atrib2", 0);
//		target2.addAttribute("2-Atrib3", 0);
//		target2.addAttribute("2-LongAtrib", 0);
//
//		// create a test relationship
//		Relationship line = new Relationship(target1, target2, 1);
//		Relationship line2 = new Relationship(target2, target1, 1);
//
//		relationList.add(line);
//		relationList.add(line2);
//
//		classObjectList.add(target1);
//		classObjectList.add(target2);
//
//		// SaveState();
//		System.out.println("Attempting Load:");
//		LoadState();
//
//		LoadTest();

	}

	private static void LoadTest() {
		/**
		 * Checks all the information from a loaded class.
		 */

		System.out.println("Start Test");
		System.out.println("Checking sizes: " + classObjectList.size() + " vs "
				+ classObjectList2.size());

		for (int i = 0; i < classObjectList.size(); i++) {
			int index = i + 1;
			System.out.println("Testing Classobject " + index + " of "
					+ classObjectList.size());
			ClassObject held = classObjectList.get(i);
			ClassObject loaded = classObjectList2.get(i);
			// ArrayList<Attribute> heldA, loadedA;
			// ArrayList<Operation> heldO, loadedO;
			// name check first

			System.out.println("Name Test: " + held.getName() + " vs "
					+ loaded.getName());

			// check Attributes and Operations lists
			System.out.println("Attributes List Size Test: "
					+ held.getAttributes().size() + " vs "
					+ loaded.getAttributes().size());
			// heldA = held.getAttributes();
			// loadedA = loaded.getAttributes();
			for (int j = 0; j < held.getAttributes().size(); j++) {
				System.out.println(held.getAttributes().get(j)
						.getAttributeName()
						+ " vs "
						+ loaded.getAttributes().get(j).getAttributeName());
			}

			System.out.println("Operations List Size Test: "
					+ held.getOperations().size() + " vs "
					+ loaded.getOperations().size());

			for (int j = 0; j < held.getOperations().size(); j++) {

				System.out.println(held.getOperations().get(j)
						.getOperationName()
						+ " vs "
						+ loaded.getOperations().get(j).getOperationName());
			}

			System.out.println();
		}

		for (int i = 0; i < relationList.size(); i++) {

			System.out.println(relationList.get(i).getOrigin().getName()
					+ " to " + relationList.get(i).getDestination().getName()
					+ " vs " + relationList2.get(i).getOrigin().getName()
					+ " to " + relationList2.get(i).getDestination().getName());
		}

	}

	private static void LoadState() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		ObjectInputStream scribe = new ObjectInputStream(new FileInputStream(
				path));

		// variables for classObjects list
		ClassObject target1;
		Relationship target2;

		int sizeof = scribe.readInt();
		for (int i = 0; i < sizeof; i++) {
			target1 = (ClassObject) scribe.readObject();

			classObjectList2.add(target1);
		}

		sizeof = scribe.readInt();
		for (int i = 0; i < sizeof; i++) {
			target2 = (Relationship) scribe.readObject();

			relationList2.add(target2);
		}

		scribe.close();
	}

}
