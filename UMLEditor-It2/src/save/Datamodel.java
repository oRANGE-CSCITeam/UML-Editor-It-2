package save;

import java.io.Serializable;
import java.util.ArrayList;

import models.ClassObject;
import models.Relationship;

public class Datamodel implements Serializable {

	/**
	 * A class that 
	 */
	private static final long serialVersionUID = 1L;
	// serial Version UID needed for compatability checking

	private static ArrayList<ClassObject> classObjectList;
	private static ArrayList<Relationship> relationList;
	private static String projectName;

	public Datamodel(ArrayList<ClassObject> cObjectList,
			ArrayList<Relationship> relList) {

		classObjectList = cObjectList;
		relationList = relList;

	}
	
	public void rename(String newName){
		projectName = newName;
	}

	public void cleardata() {
		classObjectList.clear();
		relationList.clear();
	}
	
	public static String getName(){
		return projectName;
	}

	public ArrayList<ClassObject> getClassList() {

		return classObjectList;

	}

	public ArrayList<Relationship> getRelationList() {
		return relationList;
	}

}
