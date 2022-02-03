package com.njkol.java8.methodreferences;

public class MyComparator {

	public int compareByFirstName(User first, User second) {
		return first.getFirstName().compareTo(second.getFirstName());
	}

	public int compareByLastName(User first, User second) {
		return first.getLastName().compareTo(second.getLastName());
	}
}