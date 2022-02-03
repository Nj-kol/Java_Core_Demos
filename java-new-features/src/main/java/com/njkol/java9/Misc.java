package com.njkol.java9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Misc {

	/**
	 * Immutable factory methods
	 */
	public void demoFactoryMethodsforImmutable() {

		List<String> immutableList = List.of("one", "two", "three");

		Map<Integer, String> nonemptyImmutableMap = Map.of(1, "one", 2, "two", 3, "three");

		Set<String> immutableSet = Set.of("one", "two", "three");
	}

	/**
	 * Try with resources improvement
	 * 
	 * @throws IOException
	 */
	void testARM_Java9() throws IOException {
		
		BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
		
		try (reader1) {
			System.out.println(reader1.readLine());
		}
	}
}
