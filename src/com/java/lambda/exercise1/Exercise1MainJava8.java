package com.java.lambda.exercise1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Exercise1MainJava8 {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Ed", "Macke", 65), new Person("Deepan", "Reguraman", 39),
				new Person("Polo", "Mercedes", 37), new Person("ThunderBird", "Enfield", 70));
		
		System.out.println("----Unorder List----");
		printAllList(personList);
		Collections.sort(personList, (Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		System.out.println("\n\n----Sorted List----");
		printAllList(personList);
		
		System.out.println("\n\n----Matching List----");
		printMatchingList(personList, (Person person) -> person.getLastName().startsWith("M"));
	}

	private static void printMatchingList(List<Person> personList, Condition condition) {
		personList.forEach(person -> {
			if (condition.testCondition(person)) {
				System.out.println(person);
			}
		});
	}

	private static void printAllList(List<Person> personList) {
		personList.forEach(person -> System.out.println(person));
	}
	
	@FunctionalInterface
	interface Condition {
		boolean testCondition(Person person);
	}

}
