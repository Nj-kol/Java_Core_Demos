package com.njkol.java10;

import java.util.ArrayList;
import java.util.List;

public class Misc {

	/**
	 * java.util.List, java.util.Map and java.util.Set each got a new static method
	 * copyOf(Collection). It returns the unmodifiable copy of the given Collection:
	 */
	public void whenModifyCopyOfList_thenThrowsException() {

		List<Integer> someIntList = new ArrayList<>();
		someIntList.add(1);
		someIntList.add(2);
		someIntList.add(3);

		List<Integer> copyList = List.copyOf(someIntList);
		copyList.add(4); // Any attempt to modify such a collection would result in
							// java.lang.UnsupportedOperationExceptionruntime exception.
	}

	/** 
	 * java.util.Optional, java.util.OptionalDouble, java.util.OptionalIntand java.util.OptionalLongeach 
	 * got a new method orElseThrow()which doesn't take any argument and throws NoSuchElementExceptionif no value is present:
	 */
	public void whenListContainsInteger_OrElseThrowReturnsInteger() {

		List<Integer> someIntList = new ArrayList<>();
		someIntList.add(1);
		someIntList.add(2);
		someIntList.add(3);

		Integer firstEven = someIntList.stream().filter(i -> i % 2 == 0).findFirst().orElseThrow();
	
	}
}
