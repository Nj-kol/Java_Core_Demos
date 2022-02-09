package com.njkol.streams;

import java.util.Objects;

public class Student {

	private String name;
	private String surname;
	private String city;
	private double avgGrade;
	private int age;
	
	public Student(String name, String surname, String city, double avgGrade, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.avgGrade = avgGrade;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", city=" + city + ", avgGrade=" + avgGrade + ", age="
				+ age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, avgGrade, city, name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Double.doubleToLongBits(avgGrade) == Double.doubleToLongBits(other.avgGrade)
				&& Objects.equals(city, other.city) && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}
	
}
