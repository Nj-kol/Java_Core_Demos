package com.njkol.streams;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestCollectors {

	@Test
	public void testListCollectors() {

		var lengthOrder = Stream.of("Monkey", "Lion", "Giraffe", "Lemur").parallel();

		var o1 = lengthOrder.sorted(Comparator.comparing(String::length)).collect(toList());

		var o2 = lengthOrder.sorted(Comparator.comparing(String::length)).collect(toUnmodifiableList());

		// Specific implementation of a List
		var o3 = lengthOrder.sorted(Comparator.comparing(String::length)).collect(toCollection(LinkedList::new));
	}

	@Test
	public void testSetCollectors() {

		var lengthOrder = Stream.of("Monkey", "Lion", "Giraffe", "Lemur").parallel();

		var o1 = lengthOrder.sorted(Comparator.comparing(String::length)).collect(toSet());

		var o2 = lengthOrder.sorted(Comparator.comparing(String::length)).collect(toUnmodifiableSet());

		// Specific implementation of a Set
		var o3 = lengthOrder.sorted(Comparator.comparing(String::length)).collect(toCollection(TreeSet::new));
	}

	// Examples - https://stackabuse.com/guide-to-java-8-collectors-tomap/
	//@Test
	public void testMapCollectors() {
		var students = Arrays.asList(new Student("John", "Smith", "Miami", 7.38, 19),
				new Student("Mike", "Miles", "New York", 8.4, 21),
				new Student("Michael", "Peterson", "New York", 7.5, 20),
				new Student("James", "Robertson", "Miami", 9.1, 20), new Student("Kyle", "Miller", "Miami", 9.83, 20));

		Map<String, Double> nameToAvgGrade = students.stream().collect(toMap(Student::getName, Student::getAvgGrade));

		nameToAvgGrade.forEach((k, v) -> System.out.println(k + ":" + v));

		// we can map the identity of each object (the object itself) to their names
		// easily:

		Map<String, Student> nameToStudentObject = students.stream()
				.collect(toMap(Student::getName, Function.identity()));

		// Specific implementation of a Map
		Map<String, Double> nameToAvgGrade2 = students.stream()
				.collect(toMap(Student::getName, Student::getAvgGrade, (a, b) -> (a + b) / 2, LinkedHashMap::new));
	}

	//@Test
	public void testJoining() {
		var lengthOrder = Stream.of("Monkey", "Lion", "Giraffe", "Lemur").parallel();
		// Good for concatenating strings in parallel
		var o3 = lengthOrder.sorted(Comparator.comparing(String::length)).collect(joining());
	}

	//@Test
	public void testCounting() {
		var lengthOrder = Stream.of("Monkey", "Lion", "Giraffe", "Lemur").parallel();

		Long result = lengthOrder.collect(counting());
		System.out.println("Number of elements : " + result);
	}

	// @Test
	public void testCollectingAndThen() {

	}

	@Test
	public void testSummarizing() {
		var students = Arrays.asList(new Student("John", "Smith", "Miami", 7.38, 19),
				new Student("Mike", "Miles", "New York", 8.4, 21),
				new Student("Michael", "Peterson", "New York", 7.5, 20),
				new Student("James", "Robertson", "Miami", 9.1, 20), new Student("Kyle", "Miller", "Miami", 9.83, 20));
		
		//Using Collectors.summarizingDouble()
	    DoubleSummaryStatistics doubleSummaryStatistics = students
	        .stream()
	        .collect(summarizingDouble(Student::getAvgGrade));
	    
	    System.out.println("DoubleSummaryStatistics for average grades: " + doubleSummaryStatistics);
	}

	
	@Test
	public void testSumming() {
		var students = Arrays.asList(new Student("John", "Smith", "Miami", 7.38, 19),
				new Student("Mike", "Miles", "New York", 8.4, 21),
				new Student("Michael", "Peterson", "New York", 7.5, 20),
				new Student("James", "Robertson", "Miami", 9.1, 20), new Student("Kyle", "Miller", "Miami", 9.83, 20));
		
		//Using Collectors.summingDouble()
	    Double sum = students
	        .stream()
	        .collect(summingDouble(Student::getAvgGrade));
	    
	    System.out.println("Sum of gardes: " + sum);
	}
	
	@Test
	public void testAvg() {
		var students = Arrays.asList(new Student("John", "Smith", "Miami", 7.38, 19),
				new Student("Mike", "Miles", "New York", 8.4, 21),
				new Student("Michael", "Peterson", "New York", 7.5, 20),
				new Student("James", "Robertson", "Miami", 9.1, 20), new Student("Kyle", "Miller", "Miami", 9.83, 20));
		
		//Using Collectors.averagingDouble()
	    Double avg = students
	        .stream()
	        .collect(averagingDouble(Student::getAvgGrade));
	    
	    System.out.println("Average age of students: " + avg);
	}
	
	@Test
	public void testMinMax() {
	
		var students = Arrays.asList(new Student("John", "Smith", "Miami", 7.38, 19),
				new Student("Mike", "Miles", "New York", 8.4, 21),
				new Student("Michael", "Peterson", "New York", 7.5, 20),
				new Student("James", "Robertson", "Miami", 9.1, 20), new Student("Kyle", "Miller", "Miami", 9.83, 20));
		
		//Using Collectors.maxBy()
	    Optional<Student> eldestStudent = students
	        .stream()
	        .collect(maxBy(Comparator.comparing(Student::getAge)));
	    
	  //Using Collectors.minBy()
	    Optional<Student> youngestStudent = students
		        .stream()
		        .collect(minBy(Comparator.comparing(Student::getAge)));
		    
	    System.out.println("The eldest Student is : " + eldestStudent.get());
	    System.out.println("The youngest Student is : " + youngestStudent.get());
	}
}
