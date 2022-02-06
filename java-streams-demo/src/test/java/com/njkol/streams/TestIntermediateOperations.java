package com.njkol.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestIntermediateOperations {

	// @Test
	public void testFilter() {
		var input = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");

		var list = input.filter(s -> s.startsWith("L")).collect(Collectors.toList());

		list.forEach(System.out::println);
	}

	// @Test
	public void testMap() {
		var input = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
		var list = input.filter(s -> s.startsWith("L")).map(String::toUpperCase).collect(Collectors.toList());

		list.forEach(System.out::println);
	}

	@Test
	public void testFlatMap() {
		// Creating a list of Prime Numbers
		var primeNumbers = Arrays.asList(5, 7, 11, 13);

		// Creating a list of Odd Numbers
		var oddNumbers = Arrays.asList(1, 3, 5);

		// Creating a list of Even Numbers
		var evenNumbers = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> listOfListofInts = Arrays.asList(primeNumbers, oddNumbers, evenNumbers);
		System.out.println("The Structure before flattening is : " + listOfListofInts);

		// Using flatMap for transformating and flattening.
		List<Integer> listofInts = listOfListofInts.stream().flatMap(list -> list.stream())
				.collect(Collectors.toList());

		listofInts.forEach(System.out::println);
	}

	// @Test
	public void testLimit() {
		var input = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
		input.map(String::toUpperCase).limit(3).forEach(System.out::println);
	}

	// @Test
	public void testSkip() {
		var input = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");

		input.map(String::toUpperCase).skip(2).forEach(System.out::println);
	}

	// @Test
	public void testDistinct() {
		var input = Stream.of("Monkey", "Lion", "Giraffe", "Lemur", "Lion");
		input.distinct().forEach(System.out::println);
	}

	//@Test
	public void testPeek() {

		var input = Stream.of("one", "two", "three", "four");

		input.filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
	}

	//@Test
	public void testSort() {
		var input = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
		input.sorted().forEach(System.out::println);
	}
	
	@Test
	public void testSortWithCOmparator() {
		var input = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");		
		input.sorted(Comparator.comparing(String::length)).forEach(System.out::println);
	}
}
