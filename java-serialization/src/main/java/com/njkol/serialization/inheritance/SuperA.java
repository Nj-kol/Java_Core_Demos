package com.njkol.serialization.inheritance;

//superclass A  
//A class doesn't implement Serializable 
//interface. 
public class SuperA {
	public int i;

	// parameterized constructor
	public SuperA(int i) {
		this.i = i;
	}

	// default constructor
	// this constructor must be present
	// otherwise we will get runtime exception
	public SuperA() {
		i = 50;
		System.out.println("A's class constructor called");
	}
}