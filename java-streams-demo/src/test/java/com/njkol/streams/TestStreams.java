package com.njkol.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

public class TestStreams {

	@Test
	public void sample() {

		// Create a list of key characters in Hamlet.
		List<String> characters = List.of("horatio", "claudius", "Gertrude", "Hamlet", "Hamlet", // Hamlet appears
																									// twice.
				"laertes", "Ophelia");

		// Create sorted list of characters starting with 'h' or 'H'.
		Stream<String> results = characters
				// Create a stream of characters from William
				// Shakespeare's Hamlet.
				.stream();

	}

	@Test
	public void creation() {

		// Java 10 onwards
		var stream = Stream.of(1, 2, 3, 4);

		List<Integer> myList = new ArrayList<>();
		// sequential stream
		var sequentialStream = myList.stream();
		// parallel stream
		var parallelStream = myList.parallelStream();

		LongStream is = Arrays.stream(new long[] { 1, 2, 3, 4 });
		IntStream is2 = "abc".chars();
	}

	@Test
	public void conversion() {
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
		List<Integer> intList = intStream.collect(Collectors.toList());
		System.out.println(intList); // prints [1, 2, 3, 4]

		intStream = Stream.of(1, 2, 3, 4); // stream is closed, so we need to create it again
		Map<Integer, Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i + 10));
		System.out.println(intMap); // prints {1=11, 2=12, 3=13, 4=14}
	
		Integer[] intArray = intStream.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray)); //prints [1, 2, 3, 4]
	}
}
