package com.njkol.java10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class TypeInferencing {

	// public var = "hello"; // error: 'var' is not allowed here
	public void valid() {

		var message = "Hello, Java 10";
		var idToNameMap = new HashMap<Integer, String>();

		var immutableList = List.of("one", "two", "three");
		for (var name : immutableList) {
			System.out.println(name);
		}

		IntStream.of(1, 2, 3, 5, 6, 7).filter((var i) -> i % 3 == 0).forEach(System.out::println);
	}

	public void invalid() {
		// var n; // error: cannot use 'var' on variable without initializer
		// var emptyList = null; // error: variable initializer is 'null'
		// var p = (String s) -> s.length() > 10; // error: lambda expression needs an
		// explicit target-type
		// var arr = { 1, 2, 3 }; // error: array initializer needs an explicit
		// target-type
	}
}
