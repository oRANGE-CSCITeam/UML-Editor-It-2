package models;

/**
 * Operation class that hold all the basic information needed for an 
 * operation
 * 
 * @author oRANGE
 */
public class Operation {
    private String operationName;
    private boolean type;
    
    /**
     * Constructor for a new operation
     * 
     * @param operationName
     * @param type
     */
    public Operation(String operationName, boolean type){
        this.operationName = operationName;
        this.type = type;
    }

    /**
     * Returns name of the operation
     * @return
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * Sets a predetermined name for the operation
     * @param operationName
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    /**
     * Returns if type is private or public
     * @return
     */
    public boolean isType() {
        return type;
    }

    /**
     * Sets the operation to be private or public
     * @param type
     */
    public void setType(boolean type) {
        this.type = type;
    }
    
    
    
}
