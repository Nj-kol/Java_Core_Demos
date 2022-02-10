package com.njkol.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class TestOptional {

	@Test
	public void whenCreatesEmptyOptional_thenCorrect() {
		Optional<String> empty = Optional.empty();
		assertFalse(empty.isPresent());
	}

	@Test
	public void givenNonNull_whenCreatesNullable_thenCorrect() {
		String name = "baeldung";
		Optional<String> opt = Optional.ofNullable(name);
		assertTrue(opt.isPresent());
	}

	@Test
	public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
		String name = null;
		assertThrows(NullPointerException.class, () -> Optional.of(name));
	}

	@Test
	public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
		String name = "baeldung";
		Optional<String> opt = Optional.of(name);
		assertTrue(opt.isPresent());
	}

	@Test
	public void givenNull_whenCreatesNullable_thenCorrect() {
		String name = null;
		Optional<String> opt = Optional.ofNullable(name);
		assertFalse(opt.isPresent());
	}

	@Test
	public void givenOptional_whenIfPresentWorks_thenCorrect() {

		List<String> listOfStrings = Arrays.asList("Mark", "Howard", "Anthony D'Cornian");
		Optional<String> largeString = listOfStrings.stream().filter(str -> str.length() > 10).findAny();
		largeString.ifPresent(System.out::println);

		Optional<String> veryLargeString = listOfStrings.stream().filter(str -> str.length() > 20).findAny();
		veryLargeString.ifPresent(System.out::println);
	}

	@Test
	public void whenOrElseWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("john");
		assertEquals("john", name);
	}

	@Test
	public void whenOrElseGetWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
		assertEquals("john", name);
	}

	@Test()
	public void whenOrElseThrowWorks_thenCorrect() {
		
		String nullName = null;
		assertThrows(IllegalArgumentException.class,
				() -> Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new));
	}

	
	@Test
	public void givenOptional_whenGetsValue_thenCorrect() {
	    Optional<String> opt = Optional.of("baeldung");
	    String name = opt.get();
	    assertEquals("baeldung", name);
	}
	
	@Test
	public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
		
	    Optional<String> opt = Optional.ofNullable(null);
	    assertThrows(NoSuchElementException.class, () -> opt.get());
	}

	@Test
	public void whenOptionalFilterWorks_thenCorrect() {
	    Integer year = 2016;
	    Optional<Integer> yearOptional = Optional.of(year);
	    boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
	    assertTrue(is2016);
	    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
	    assertFalse(is2017);
	}

	@Test
	public void givenOptional_whenMapWorks_thenCorrect() {
	    var companyNames = Arrays.asList(
	      "paypal", "oracle", "", "microsoft", "", "apple");
	    
	    Optional<List<String>> listOptional = Optional.of(companyNames);

	    int size = listOptional
	      .map(List::size)
	      .orElse(0);
	    
	    assertEquals(6, size);
	}

	
	@Test
	public void givenOptional_whenFlatMapWorks_thenCorrect2() {
	    Person person = new Person("john", 26, null);
	    Optional<Person> personOptional = Optional.of(person);

	    Optional<Optional<String>> nameOptionalWrapper   = personOptional.map(Person::getName);
	    Optional<String> nameOptional  = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
	    String name1 = nameOptional.orElse("");
	    assertEquals("john", name1);

	    String name = personOptional
	      .flatMap(Person::getName)
	      .orElse("");
	    assertEquals("john", name);
	}
	
	// Java 9 Changes start
	@Test
	public void givenOptional_whenPresent_thenShouldTakeAValueFromIt() {
	    //given
	    String expected = "properValue";
	    Optional<String> value = Optional.of(expected);
	    Optional<String> defaultValue = Optional.of("default");

	    //when
	    Optional<String> result = value.or(() -> defaultValue);

	    //then
	    assertEquals(expected,result.get());
	}
	
	@Test
	public void givenOptional_whenPresent_thenShouldExecuteProperCallback() {
	    // given
	    Optional<String> value = Optional.of("properValue");
	    AtomicInteger successCounter = new AtomicInteger(0);
	    AtomicInteger onEmptyOptionalCounter = new AtomicInteger(0);

	    // when
	    value.ifPresentOrElse(
	      v -> successCounter.incrementAndGet(), 
	      onEmptyOptionalCounter::incrementAndGet);

	    // then
	    assertEquals(1,successCounter.get());
	    assertEquals(0,onEmptyOptionalCounter.get());
	}

	@Test
	public void givenOptional_whenNotPresent_thenShouldExecuteProperCallback() {
	    // given
	    Optional<String> value = Optional.empty();
	    AtomicInteger successCounter = new AtomicInteger(0);
	    AtomicInteger onEmptyOptionalCounter = new AtomicInteger(0);

	    // when
	    value.ifPresentOrElse(
	      v -> successCounter.incrementAndGet(), 
	      onEmptyOptionalCounter::incrementAndGet);

	    // then
	    assertEquals(0,successCounter.get());
	    assertEquals(1,onEmptyOptionalCounter.get());
	}
	
	@Test
	public void givenOptionalOfSome_whenToStream_thenShouldTreatItAsOneElementStream() {
	    // given
	    Optional<String> value = Optional.of("a");

	    // when
	    List<String> collect = value.stream().map(String::toUpperCase).collect(Collectors.toList());

	    // then
	    assertEquals(List.of("A"),collect);
	}
	
	@Test
	public void givenOptionalOfNone_whenToStream_thenShouldTreatItAsZeroElementStream() {
	    // given
	    Optional<String> value = Optional.empty();

	    // when
	    List<String> collect = value.stream()
	      .map(String::toUpperCase)
	      .collect(Collectors.toList());

	    // then
	    assertTrue(collect.isEmpty());
	}

	// Java 9 Changes end
	
	// Java 10 start
	@Test
	public void whenNoArgOrElseThrowWorks_thenCorrect() {
		String nullName = null;
		assertThrows(IllegalArgumentException.class,
				() -> Optional.ofNullable(nullName).orElseThrow());
	}
	// Java 10 end
	
	// Java 11 start
	@Test
	public void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
		Optional<String> opt = Optional.of("Baeldung");
		assertFalse(opt.isEmpty());
		opt = Optional.ofNullable(null);
		assertTrue(opt.isEmpty());
	}
	// Java 11 end
}
