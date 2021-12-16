package com.njkol.reflection.demos;

public class Employee {

	public static String company;
	public String rank;
	private int id;
	private String name;
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
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
	@Override
	public String toString() {
		return "Employee [company = "+ company + " rank=" + rank + ", id=" + id + ", name=" + name + "]";
	}
}