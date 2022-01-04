package com.njkol.maps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class TestTreeMaps {

	@Test
	public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect() {

		SortedMap<Integer, String> map = new TreeMap<>();
		map.put(3, "val");
		map.put(2, "val");
		map.put(1, "val");
		map.put(5, "val");
		map.put(4, "val");

		assertEquals("[1, 2, 3, 4, 5]", map.keySet().toString());
	}

	@Test
	public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect2() {

		SortedMap<String, String> map = new TreeMap<>();
		map.put("c", "val");
		map.put("b", "val");
		map.put("a", "val");
		map.put("e", "val");
		map.put("d", "val");

		assertEquals("[a, b, c, d, e]", map.keySet().toString());
	}

	@Test
	public void givenTreeMap_whenOrdersEntriesByComparator_thenCorrect() {

		SortedMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());

		map.put(3, "val");
		map.put(2, "val");
		map.put(1, "val");
		map.put(5, "val");
		map.put(4, "val");

		assertEquals("[5, 4, 3, 2, 1]", map.keySet().toString());
	}

	@Test
	public void testIdentityHashMap() {

		Map<String, String> map = new HashMap<>();
		Map<String, String> ihm = new IdentityHashMap<>();

		map.put("ihmkey","one");
		map.put(new String("ihmkey"),"two");
        
		ihm.put("ihmkey","one");
        ihm.put(new String("ihmkey"),"two");
        
        // ihm.size() will print 1 since it
        // compares the objects by equality
        System.out.println("Size of HashMap--"+map.size());
        
        // ihm.size() will print 2 since it
        // compares the objects by reference
        System.out.println("Size of IdentityHashMap--"+ihm.size());
	}
}