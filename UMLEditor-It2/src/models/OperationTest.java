package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperationTest { 
	
	String testName = "Name";
	int visibility = 0;
	@Test
	public void testOperation() {
		Operation target = new Operation(testName, visibility);
		assertEquals("Name", target.getOperationName());
		assertEquals(0, target.getVisibility());
		
		target.setOperationName("Name2");
		target.setVisibility(2);
		assertEquals("Name2",target.getOperationName());
		assertEquals(2,target.getVisibility());
	}

}
