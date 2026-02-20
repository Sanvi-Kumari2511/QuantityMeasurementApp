package com.apps.quantitymeasurement;

import java.util.Scanner;

//Main class
public class QuantityMeasurementApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter two feet values:");

		Feet feet1 = new Feet(sc.nextDouble());
		Feet feet2 = new Feet(sc.nextDouble());

		// Comparing values
		System.out.println("Both Feet equal? " + feet1.equals(feet2));

		sc.close();
	}
}