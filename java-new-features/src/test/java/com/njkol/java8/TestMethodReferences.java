package com.njkol.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

import org.junit.jupiter.api.Test;

import com.njkol.java8.methodreferences.*;

public class TestMethodReferences {

	//@Test
	public void testStaticMf() {
		BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
		int result = adder.apply(10, 20);
		System.out.println(result);
	}

	//@Test
	public void testInstanceMf() {

		List<User> users = Arrays.asList(new User("Gaurav", "Mazra"), new User("Arnav", "Singh"),
				new User("Daniel", "Verma"));

		MyComparator comparator = new MyComparator();
		System.out.println(users);

		Collections.sort(users, comparator::compareByFirstName);
		System.out.println(users);

		Comparator<String> stringIgnoreCase = String::compareToIgnoreCase;
		// this is equivalent to
		Comparator<String> stringComparator = (first, second) -> first.compareToIgnoreCase(second);
	}

	//@Test
	public void testInstanceMf2() {
		// Have multiple implementations at runtime
		Sayable sayable = Sayables::saySomethingForCommonMan;
		sayable.say();

		sayable = Sayables::saySomethingForInvestor;
		sayable.say();
	}

	@Test
	public void testConstructorMf() {
		
		User usr  = null;
		
		UserEmpty empEmpty = User::new;
		// Constructor invoked at this point
		usr= empEmpty.get();
		System.out.println(usr);
		
		UserwithFirstName empfname = User::new;
		// Constructor invoked at this point
		usr= empfname.get("Nilanjan");
		System.out.println(usr);
		
		UserwithAll empfall= User::new;
		// Constructor invoked at this point
		usr= empfall.get("Nilanjan","Sarkar");
		System.out.println(usr);
	}
}

interface UserEmpty {
	User get();
}

interface UserwithFirstName {
	User get(String firstName);
}

interface UserwithAll {
	User get(String firstName,String lastName);
}