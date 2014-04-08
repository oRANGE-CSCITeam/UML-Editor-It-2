package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class RelationshipTest {

	ClassObject origin = new ClassObject("Class1", 30, 30, 1);
	ClassObject dest = new ClassObject("Class2", 60, 60, 2);
	Relationship relate = new Relationship(origin, dest, 1);

	@Test
	public void testGetOrigin() {

		assertEquals(origin, relate.getOrigin());

	}

	@Test
	public void testGetDestination() {
		assertEquals(dest, relate.getDestination());

	}

	@Test
	public void testGetRelationshipType() {
		assertEquals(1, relate.getRelationshipType());

	}

	@Test
	public void testSetOrigin() {
		ClassObject newOrigin = new ClassObject("New Origin", 25, 69, 3);
		relate.setOrigin(newOrigin);
		assertEquals(newOrigin, relate.getOrigin());
	}

	@Test
	public void testSetDestination() {
		ClassObject newDest = new ClassObject("New Dest", 34, 90, 2);
		relate.setDestination(newDest);
		assertEquals(newDest, relate.getDestination());

	}

	@Test
	public void testSetRelationshipType() {
		int newType = 3;
		relate.setRelationshipType(newType);
		assertEquals(3, relate.getRelationshipType());

	}

}
