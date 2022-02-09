package com.njkol.streams;

import java.util.Comparator;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

import org.junit.jupiter.api.Test;

public class TestConfig {

	@Test
	public void testForkJoinPoolConfig() {
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "10");
		System.out.println("Parallelism in common fork join pool is : " + ForkJoinPool.getCommonPoolParallelism());
	}

	@Test
	public void testCollectors() {
		var lengthOrder = Stream.of("Monkey", "Lion", "Giraffe", "Lemur").parallel();

		var o1 = lengthOrder.sorted(Comparator.comparing(String::length))
	           	.collect(toList());
		
		var o2 = lengthOrder.sorted(Comparator.comparing(String::length))
				.collect(toSet());
		
		// Good for concatenating strings in parallel
		var o3 = lengthOrder.sorted(Comparator.comparing(String::length))
				.collect(joining());
	}
	

	@Test
	public void testConcurrentCollectors() {
		
	}
}
