package com.njkol.serialization.inheritance;

import java.io.Serializable;

public class SubclassB extends SuperA implements Serializable {

	public int j;

	public SubclassB() {
		System.out.println("B's class constructor called");
	}
	
	// parameterized constructor
	public SubclassB(int i,int j)  
    { 
        super(i); 
        this.j = j; 
    }
}
