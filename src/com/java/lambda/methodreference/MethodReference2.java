package com.java.lambda.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java.lambda.exercise1.Person;

public class MethodReference2 {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Ed", "Macke", 65), new Person("Deepan", "Reguraman", 39),
				new Person("Polo", "Mercedes", 37), new Person("ThunderBird", "Enfield", 70));

		System.out.println("----Unorder List----");
		/**
		 * This is similar to person -> System.out.println(person)
		 * 
		 * ie it calls one argument instance and prints that
		 */
		printList(personList, person -> true, System.out::println);
		
		
		/**
		 * Here in Predicate it test a condition if the age is > 39
		 */
		System.out.println("----For a matching Condition----");
		printList(personList, person -> person.getAge() > 39, System.out::println);
	}

	private static void printList(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer) {
		personList.forEach(person -> {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		});
	}
}
