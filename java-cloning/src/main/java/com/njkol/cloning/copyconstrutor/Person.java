package com.njkol.cloning.copyconstrutor;

/**
 * Demo of a copy constructor
 * 
 * @author Nilanjan Sarkar
 *
 */
public class Person {

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(Person emp) {
		this.setId(emp.getId());
		this.setName(emp.getName());
	}
}