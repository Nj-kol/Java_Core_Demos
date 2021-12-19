package com.njkol.enums;

import java.io.Serializable;

//Use an enum constructor, instance variable, and method.
public enum Apple implements Serializable {

	Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);

	private int price; // price of each apple

	// Constructor
	Apple(int p) {
		price = p;
	}

	int getPrice() {
		return price;
	}
}