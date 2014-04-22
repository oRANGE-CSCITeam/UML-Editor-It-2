package models;

import java.io.Serializable;

/**
 * Operation class that hold all the basic information needed for an operation
 * 
 * @author oRANGE
 */
public class Operation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String operationName;
	private int visibility;

	/**
	 * Constructor for a new operation
	 * 
	 * @param operationName
	 * @param visibility
	 */
	public Operation(String operationName, int visibility) {
		this.operationName = operationName;
		this.visibility = visibility;
	}

	/**
	 * Returns name of the operation
	 * 
	 * @return
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * Sets a predetermined name for the operation
	 * 
	 * @param operationName
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	/**
	 * Returns if visibility is private or public
	 * 
	 * @return
	 */
	public int getVisibility() {
		return visibility;
	}

	/**
	 * Sets the operation to be private or public
	 * 
	 * @param visibility
	 */
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

}
