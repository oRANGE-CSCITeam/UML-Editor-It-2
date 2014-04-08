package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttributeTest {

	String testName = "Name";
	int x = 1;

	@Test
	public void testAttribute() {
		Attribute target = new Attribute(testName, x);
		assertEquals("Name", target.getAttributeName());
		assertEquals(1, target.getVisibility());

		target.setAttributeName("Name2");
		target.setVisibility(2);
		assertEquals("Name2", target.getAttributeName());
		assertEquals(2, target.getVisibility());

	}

}
