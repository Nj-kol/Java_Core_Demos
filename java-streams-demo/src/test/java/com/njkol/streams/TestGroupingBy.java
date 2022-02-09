package com.njkol.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static java.util.stream.Collectors.*;

public class TestGroupingBy {

	private List<Person> people = new ArrayList<>();
	private List<Item> items;
	
	@SuppressWarnings("removal")
	@BeforeEach
	public void setUp() {
		people.add(new Person("John", "London", 21));
		people.add(new Person("Swann", "London", 21));
		people.add(new Person("Kevin", "London", 23));
		people.add(new Person("Monobo", "Tokyo", 23));
		people.add(new Person("Sam", "Paris", 23));
		people.add(new Person("Nadal", "Paris", 31));
		
		items = Arrays.asList(
				new Item("apple", 10, new Double("9.99")),
				new Item("banana", 20, new Double("19.99")), 
				new Item("orang", 10, new Double("29.99")),
				new Item("watermelon", 10, new Double("29.99")), 
				new Item("papaya", 20, new Double("9.99")),
				new Item("apple", 10, new Double("9.99")), 
				new Item("banana", 10, new Double("19.99")),
				new Item("apple", 20, new Double("9.99")));
	}

	@Test
	public void testGroupBy1() {

		Map<String, List<Person>> personByCity = people.stream().collect(groupingBy(Person::getCity));
		System.out.println("Person grouped by cities in Java 8 ");
		personByCity.forEach((k, v) -> System.out.println(k + ":" + v));

		System.out.println("===================================");
		
		Map<Integer, List<Person>> personByAge = people.stream().collect(groupingBy(Person::getAge));
		System.out.println("Person grouped by cities  in Java 8 ");
		personByAge.forEach((k, v) -> System.out.println(k + ":" + v));
	}
	
	@Test
	public void testConcurrentGroupBy() {
		System.out.println("");
		
		ConcurrentMap<String, List<Person>> personByCity = people.stream()
				.parallel()
				.collect(groupingByConcurrent(Person::getCity));
		
		System.out.println("Person grouped by cities concurrently in Java 8 ");
		personByCity.forEach((k, v) -> System.out.println(k + ":" + v));
		

		System.out.println("===================================");
		ConcurrentMap<Integer, List<Person>> personByAge = people.stream()
				.parallel()
				.collect(groupingByConcurrent(Person::getAge));
		
		System.out.println("Person grouped by age concurrently in Java 8 ");
		personByAge.forEach((k, v) -> System.out.println(k + ":" + v));
	}
	
	
	@Test
	public void testGroupBy2() {
		System.out.println("");
		Map<String, Long> counting = items.stream()
				.collect(groupingBy(Item::getName, Collectors.counting()));

		System.out.println("Group by with count: ");
		counting.forEach((k, v) -> System.out.println(k + ":" + v));
		System.out.println("");
		
		Map<String, Double> avg = items.stream()
				.collect(groupingBy(Item::getName, Collectors.averagingDouble(Item::getPrice)));
		System.out.println("Group by with avg:");
		avg.forEach((k, v) -> System.out.println(k + ":" + v));
	}
}
