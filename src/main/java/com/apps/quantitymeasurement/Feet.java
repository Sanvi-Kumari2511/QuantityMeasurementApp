package com.apps.quantitymeasurement;

//Class representing a feet value
public class Feet {

	private final double value; 

	// Constructor
	public Feet(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	// Override equals() for value comparison
	@Override
	public boolean equals(Object obj) {

		// same reference (reflexive)
		if (this == obj) {
			return true;
		}

		// null or different class check
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		// type casting
		Feet ft = (Feet) obj;

		// floating point comparison
		return Double.compare(this.value, ft.value) == 0;
	}

	// Must override hashCode when equals is overridden
	@Override
	public int hashCode() {
		return Double.hashCode(value);
	}
}