package com.njkol.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCompartors {

	private List<Player> footballTeam;
	private List<Employee> employees;

	@BeforeEach
	public void initEach() {
		
		footballTeam = new ArrayList<>();
		Player player1 = new Player(59, "John", 20);
		Player player2 = new Player(67, "Roger", 22);
		Player player3 = new Player(45, "Steven", 24);
		footballTeam.add(player1);
		footballTeam.add(player2);
		footballTeam.add(player3);

		employees = new ArrayList<>();
		employees.add(new Employee(6, "Yash", "Chopra", 25));
		employees.add(new Employee(2, "Aman", "Sharma", 28));
		employees.add(new Employee(3, "Aakash", "Yaadav", 52));
		employees.add(new Employee(5, "David", "Kameron", 19));
		employees.add(new Employee(4, "James", "Hedge", 72));
		employees.add(new Employee(8, "Balaji", "Subbu", 88));
		employees.add(new Employee(7, "Karan", "Johar", 59));
		employees.add(new Employee(1, "Lokesh", "Gupta", 32));
		employees.add(new Employee(9, "Vishu", "Bissi", 33));
		employees.add(new Employee(10, "Lokesh", "Ramachandran", 60));
	}

	@Test
	void testComparable() {
		Collections.sort(footballTeam);
		System.out.println(footballTeam);
	}

	@Test
	void testRankingComparator() {
		PlayerRankingComparator playerComparator = new PlayerRankingComparator();
		Collections.sort(footballTeam, playerComparator);
		System.out.println(footballTeam);
	}

	@Test
	void testReverseAgeComparator() {
		PlayerAgeComparator playerComparator = new PlayerAgeComparator();
		Collections.sort(footballTeam, playerComparator.reversed());
		System.out.println(footballTeam);
	}

	@Test
	void testAnonymousComparator() {

		Collections.sort(footballTeam, new Comparator<Player>() {
			public int compare(Player firstPlayer, Player secondPlayer) {
				return Integer.compare(firstPlayer.getAge(), secondPlayer.getAge());
			}
		});
		System.out.println(footballTeam);
	}

	@Test
	void testJava8Comparator() {

		// Sort all employees by first name
		employees.sort(Comparator.comparing(e -> e.getFirstName()));

		// OR you can use below
		employees.sort(Comparator.comparing(Employee::getFirstName));

		System.out.println(employees);

		// Sort all employees by last name
		employees.sort(Comparator.comparing(e -> e.getLastName()));

		// OR you can use below
		employees.sort(Comparator.comparing(Employee::getLastName));

		System.out.println(employees);
	}

	@Test
	void testReverseOrder() {
		// Sort all employees by first name; And then reversed
		Comparator<Employee> comparator = Comparator.comparing(e -> e.getFirstName());
		employees.sort(comparator.reversed());

		// Let's print the sorted list
		System.out.println(employees);
	}

	@Test
	void testSortOnMultipleFields() {

		// Sorting on multiple fields; Group by.
		Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName)
				.thenComparing(Employee::getLastName);
		employees.sort(groupByComparator);

		System.out.println(employees);
	}

	@Test
	void testParallelSort() {

		// Sorting on multiple fields; Group by.
		Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName)
				.thenComparing(Employee::getLastName);

		// Parallel Sorting
		Employee[] employeesArray = employees.toArray(new Employee[employees.size()]);

		// Parallel sorting
		Arrays.parallelSort(employeesArray, groupByComparator);

		System.out.println(Arrays.toString(employeesArray));
	}

	@Test
	public void whenNullsFirst_thenSortedByNameWithNullsFirst() {

		Employee[] employeesArrayWithNulls = { new Employee(6, "Yash", "Chopra", 25), null,
				new Employee(2, "Aman", "Sharma", 28), null, new Employee(10, "Lokesh", "Ramachandran", 60) };

		Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getFirstName);
		Comparator<Employee> employeeNameComparator_nullFirst = Comparator.nullsFirst(employeeNameComparator);

		Arrays.sort(employeesArrayWithNulls, employeeNameComparator_nullFirst);

		System.out.println(Arrays.toString(employeesArrayWithNulls));
	}

	@Test
	public void whenNullsLast_thenSortedByNameWithNullsLast() {

		Employee[] employeesArrayWithNulls = { new Employee(6, "Yash", "Chopra", 25), null,
				new Employee(2, "Aman", "Sharma", 28), null, new Employee(10, "Lokesh", "Ramachandran", 60) };

		Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getFirstName);
		Comparator<Employee> employeeNameComparator_nullLast = Comparator.nullsLast(employeeNameComparator);

		Arrays.sort(employeesArrayWithNulls, employeeNameComparator_nullLast);

		System.out.println(Arrays.toString(employeesArrayWithNulls));
	}
}