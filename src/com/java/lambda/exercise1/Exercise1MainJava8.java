package com.java.lambda.exercise1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
		
		System.out.println("\n\n----Another Way of Printing Matching List");
		printMatchingList(personList, person -> person.getLastName().startsWith("M"), System.out::println);
	}

	private static void printMatchingList(List<Person> personList, Condition condition) {
		personList.forEach(person -> {
			if (condition.testCondition(person)) {
				System.out.println(person);
			}
		});
	}

	private static void printAllList(List<Person> personList) {
		System.out.println("----One Way----");
		personList.forEach(person -> System.out.println(person));
		System.out.println("----Another Way----");
		personList.forEach(System.out::println);
	}
	
	private static void printMatchingList(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer) {
		personList.forEach(person -> {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		});
	}
}
