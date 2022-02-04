package com.njkol.java8;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class TestTerminalOperations {

	@Test
	public void testForEach() {
		// Stream forEach() Method Example
		var streamForEach = Stream.of(1, 2, 3, 4, 5);
		// Printing the values
		streamForEach.forEach(value -> System.out.println(value));
		
		// Adding values to list.
		var numList = new ArrayList<Integer>();
		streamForEach.forEach(value -> numList.add(value));
		System.out.println("numList : " + numList);
	}
	
	@Test
	public void testForEachOrdered() {
		// Stream streamForEachOrdered() Method Example
		Stream<Integer> streamForEachOrdered = Stream.of(1, 2, 3, 4, 5).parallel();
		// Printing the values
		streamForEachOrdered.forEachOrdered(value -> System.out.println(value));

		// Adding values to list.
		Stream<Integer> streamForEachOrderedList = Stream.of(1, 2, 3, 4, 5).parallel();
		var numList1 = new ArrayList<>();
		streamForEachOrderedList.forEachOrdered(value -> numList1.add(value));
		System.out.println("numList1 : " + numList1);
	}
	
	@Test
	public void testToArray() {
		var stream = Stream.of(1, 2, 3, 4, 5);
		Object[] objArray = stream.toArray();
		System.out.println(objArray);
	}
	
	@Test
	public void testReduce() {
		var streamReduce = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> sum = streamReduce.reduce((value1, value2) -> value1 + value2);
		System.out.println("sum of first 5 numbers using reduce opration : " + sum.get());
	}
	
	@Test
	public void testCount() {
		var streamCount = Stream.of(1, 2, 3, 4, 5);
		long count = streamCount.count();
		System.out.println("count :: " + count);
	}
	
	@Test
	public void testSum() {
		var streamReduce = IntStream.of(1, 2, 3, 4, 5);
		var sum = streamReduce.sum();
		System.out.println("sum of first 5 numbers using reduce opration : " + sum);
	}
	
	@Test
	public void testMin() {
		var streamReduce = IntStream.of(1, 2, 3, 4, 5);
		OptionalInt min = streamReduce.min();
		System.out.println("The min value is : " + min.orElse(0));
	}
	
	@Test
	public void testMax() {
		var streamReduce = IntStream.of(1, 2, 3, 4, 5);
		OptionalInt  max = streamReduce.max();
		System.out.println("The max value is : " + max.orElse(0));
	}
	
	@Test
	public void testAverage() {
		var streamReduce = IntStream.of(1, 2, 3, 4, 5);
		OptionalDouble  avg = streamReduce.average();
		System.out.println("The average value is : " + avg.orElse(0));
	}
	
}
