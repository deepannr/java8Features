package com.java.lambda.prebuilt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java.lambda.exercise1.Person;

/**
 * 
 * Both Predicate and Customer are predefined functional interfaces from
 * java.util.function. There are more predefined interfaces which can be used
 * instead of creating any new interfaces.
 *
 */

public class PredicateAndConsumer {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Ed", "Macke", 65), new Person("Deepan", "Reguraman", 39),
				new Person("Polo", "Mercedes", 37), new Person("ThunderBird", "Enfield", 70));

		System.out.println("----Unorder List----");
		printList(personList, person -> true, person -> System.out.println(person));
		Collections.sort(personList, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		System.out.println("\n\n----Sorted List----");
		printList(personList, person -> true, person -> System.out.println(person));

		System.out.println("\n\n----Matching List For Last Name----");
		printList(personList, person -> person.getLastName().startsWith("M"), person -> System.out.println(person));

		System.out.println("\n\n----Matching List For First Name----");
		printList(personList, person -> person.getFirstName().startsWith("T"),
				person -> System.out.println(person.getFirstName()));
	}

	private static void printList(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer) {
		personList.forEach(person -> {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		});
	}
}
