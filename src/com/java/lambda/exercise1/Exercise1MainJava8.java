package com.java.lambda.exercise1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.java.lambda.exercise1.Exercise1MainJava7.Condition;

public class Exercise1MainJava8 {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Ed", "Macke", 65), new Person("Deepan", "Reguraman", 39),
				new Person("Polo", "Mercedes", 37), new Person("ThunderBird", "Enfield", 70));

		System.out.println("----Unorder List----");
		printAllList(personList);
		Collections.sort(personList, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		System.out.println("\n\n----Sorted List----");
		printAllList(personList);

		System.out.println("\n\n----Matching List----");
		printMatchingList(personList, person -> person.getLastName().startsWith("M"));
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
}
