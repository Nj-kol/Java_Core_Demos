package com.njkol.enums;

public class EnumDemo {

	public static void main(String args[]) {

		// Display price of Winesap.
		System.out.println("Winesap costs " + Apple.Winesap.getPrice() + " cents.\n");

		enumComparsion();
		enumValue();
	}

	private static void enumComparsion() {

		Apple ap, ap2, ap3;

		// Obtain all ordinal values using ordinal().
		System.out.println("Here are all apple constants" + " and their ordinal values: ");

		ap = Apple.RedDel;
		ap2 = Apple.GoldenDel;
		ap3 = Apple.RedDel;

		System.out.println();

		// Demonstrate compareTo() and equals()

		if (ap.compareTo(ap2) < 0)
			System.out.println(ap + " comes before " + ap2);

		if (ap.compareTo(ap2) > 0)
			System.out.println(ap2 + " comes before " + ap);

		if (ap.compareTo(ap3) == 0)
			System.out.println(ap + " equals " + ap3);

		System.out.println();

		if (ap.equals(ap2))
			System.out.println("Error!");

		if (ap.equals(ap3))
			System.out.println(ap + " equals " + ap3);

		if (ap == ap3)
			System.out.println(ap + " == " + ap3);

	}

	private static void enumValue() {

		// Display all apples and prices.
		System.out.println("All apple prices:");

		for (Apple a : Apple.values()) {
			System.out.println(a + " costs " + a.getPrice() + " cents.");
		}

		// Value of
		System.out.println(Apple.valueOf("Winesap"));
	}

}