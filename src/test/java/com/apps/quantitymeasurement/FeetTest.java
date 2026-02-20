package com.apps.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FeetTest {

	@Test
	void testEquality_SameValue() {
		Feet f1 = new Feet(1.0);
		Feet f2 = new Feet(1.0);

		assertTrue(f1.equals(f2));
	}

	@Test
	void testEquality_DifferentValue() {
		Feet f1 = new Feet(1.0);
		Feet f2 = new Feet(2.0);

		assertFalse(f1.equals(f2));
	}

	@Test
	void testEquality_NullComparison() {
		Feet f1 = new Feet(1.0);

		assertFalse(f1.equals(null));
	}

	@Test
	void testEquality_NonFeetObject() {
		Feet f1 = new Feet(1.0);
		String obj = "test";

		assertFalse(f1.equals(obj));
	}

	@Test
	void testEquality_SameReference() {
		Feet f1 = new Feet(1.0);

		assertTrue(f1.equals(f1));
	}
}