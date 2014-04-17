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
	private ArrayList<ClassObject> classObjectList;
	private ArrayList<Relationship> relationList;
	private ArrayList<Integer> relationshipCandidates;

	
	public Datamodel (ArrayList<ClassObject> cObjectList, ArrayList<Relationship> relList, 
			ArrayList<Integer> relCandidates){
		
		classObjectList = cObjectList;
		relationList = relList;
		relationshipCandidates = relCandidates;
		
	}
	
	public void cleardata(){
		classObjectList.clear();
		relationList.clear();
		relationshipCandidates.clear();
	}
	
}

