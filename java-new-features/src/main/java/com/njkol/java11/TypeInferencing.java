package com.njkol.java11;

import java.util.stream.IntStream;

interface Cal {

	int sum(int a, int b);
}

public class TypeInferencing {

	public void valid() {

		Cal cal = (var a, var b) -> a + b;
		int result = cal.sum(10, 20);
		System.out.println(result);

		IntStream.of(1, 2, 3, 5, 6, 7).filter((var i) -> i % 3 == 0).forEach(System.out::println);
	}

	public void invalid() {

	}
}
