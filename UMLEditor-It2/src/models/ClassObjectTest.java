package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClassObjectTest {
	
	@Test
	public void testClassObject() {
		ClassObject target = new ClassObject("Name", 10, 10, 0);
		assertEquals("Name", target.getName());
		assertEquals(10, target.getxPos());
		assertEquals(10, target.getyPos());
		assertEquals(0, target.getId());
		assertEquals(0, target.getAttributes().size());
		assertEquals(0, target.getOperations().size());
		
	}
	

	@Test
	public void testAddAttribute() {
		ClassObject target = new ClassObject("Name", 10, 10, 0);
		target.addAttribute("Atrib1", 0);
		assertEquals(1, target.getAttributes().size());
		target.addAttribute("Atrib2", 0);
		target.addAttribute("Atrib3", 0);
		target.addAttribute("Atrib4", 0);
		assertEquals(4, target.getAttributes().size());
	}

	@Test
	public void testRemoveAttribute() {
		ClassObject target = new ClassObject("Name", 10, 10, 0);
		target.addAttribute("Atrib1", 0);
		target.addAttribute("Atrib2", 0);
		target.addAttribute("Atrib3", 0);
		target.addAttribute("Atrib4", 0);
		assertEquals(4, target.getAttributes().size());
		target.removeAttribute(3);
		assertEquals(3, target.getAttributes().size());
	}

	@Test
	public void testRemoveAllAtributes() {
		ClassObject target = new ClassObject("Name", 10, 10, 0);
		target.addAttribute("Atrib1", 0);
		target.addAttribute("Atrib2", 0);
		target.addAttribute("Atrib3", 0);
		target.addAttribute("Atrib4", 0);
		assertEquals(4, target.getAttributes().size());
		target.removeAllAtributes();
		assertEquals(0, target.getAttributes().size());
	}

	@Test
	public void testAddOperation() {
		ClassObject target = new ClassObject("Name", 10, 10, 0);
		target.addOperation("Oper1", 0);
		assertEquals(1, target.getOperations().size());
		target.addOperation("Oper2", 0);
		target.addOperation("Oper3", 0);
		target.addOperation("Oper4", 0);
		assertEquals(4, target.getOperations().size());
	}

	@Test
	public void testRemoveOperation() {
		ClassObject target = new ClassObject("Name", 10, 10, 0);
		target.addOperation("Oper1", 0);
		assertEquals(1, target.getOperations().size());
		target.addOperation("Oper2", 0);
		target.addOperation("Oper3", 0);
		target.addOperation("Oper4", 0);
		assertEquals(4, target.getOperations().size());
		target.removeOperation(3);
		assertEquals(3, target.getOperations().size());
	}

	@Test
	public void testRemoveAllOperations() {
		ClassObject target = new ClassObject("Name", 10, 10, 0);
		target.addOperation("Oper1", 0);
		assertEquals(1, target.getOperations().size());
		target.addOperation("Oper2", 0);
		target.addOperation("Oper3", 0);
		target.addOperation("Oper4", 0);
		assertEquals(4, target.getOperations().size());
		target.removeAllOperations();
		assertEquals(0, target.getOperations().size());
	}

	@Test
	public void testGetLongestAttribute() {
		ClassObject target = new ClassObject("Name", 10, 10, 0);
		target.addAttribute("Atrib1", 0);
		target.addAttribute("Atrib2", 0);
		target.addAttribute("Atrib3", 0);
		target.addAttribute("LongAtrib", 0);
		assertEquals(9, target.getLongestAttribute());
	}

	@Test
	public void testGetLongestOperation() {
		ClassObject target = new ClassObject("Name", 10, 10, 0);
		target.addOperation("Oper1", 0);
		target.addOperation("Oper2", 0);
		target.addOperation("Oper3", 0);
		target.addOperation("LongOper", 0);
		assertEquals(8, target.getLongestOperation());
	}

}
