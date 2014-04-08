package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClassObjectTest {
	
	@Test
	public void testClassObject() {
		ClassObject target = new ClassObject("Name", 10, 10, 0);
		assertEquals("Name", target.getName());
		assertEquals(10, target.getxPos());
		fail("Not yet implemented");
	}
	

	@Test
	public void testAddAttribute() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAttribute() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAllAtributes() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddOperation() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveOperation() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAllOperations() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLongestAttribute() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLongestOperation() {
		fail("Not yet implemented");
	}

}
