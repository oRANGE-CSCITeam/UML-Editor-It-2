package save;

import java.io.Serializable;
import java.util.ArrayList;

import models.ClassObject;
import models.Relationship;

public class Datamodel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1736941983536755231L;
	//serial Version UID needed for compatability checking
	
	private ArrayList<ClassObject> classObjectList;
	private ArrayList<Relationship> relationList;
	private String projectName;
	
	
	public Datamodel (ArrayList<ClassObject> cObjectList, ArrayList<Relationship> relList){
		
		classObjectList = cObjectList;
		relationList = relList;
				
	}
	
	public void cleardata(){
		classObjectList.clear();
		relationList.clear();
			}
	
	
}

