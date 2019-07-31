package com.java.lambda.exercise1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise1MainJava7 {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Ed", "Macke", 65), new Person("Deepan", "Reguraman", 39),
				new Person("Polo", "Mercedes", 37), new Person("ThunderBird", "Enfield", 70));

		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}

		});

		System.out.println("------Prints All List------");
		printAllPerson(personList);

		System.out.println("\n\n------Prints LastName Starts with M------");
		printPersonWithMatchingCondition(personList, new Condition() {
			@Override
			public boolean testCondition(Person person) {
				return person.getLastName().startsWith("M");
			}
		});
	}

	private static void printPersonWithMatchingCondition(List<Person> personList, Condition condition) {
		for (Person person : personList) {
			if (condition.testCondition(person)) {
				System.out.println(person);
			}
		}
	}

	private static void printAllPerson(List<Person> personList) {
		for (Person person : personList) {
			System.out.println(person);
		}
	}

	interface Condition {
		boolean testCondition(Person person);
	}
}
