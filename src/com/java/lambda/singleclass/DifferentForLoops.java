package com.java.lambda.singleclass;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java.lambda.exercise1.Person;

public class DifferentForLoops {
	DifferentForLoops forLoops = new DifferentForLoops();

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Ed", "Macke", 65), new Person("Deepan", "Reguraman", 39),
				new Person("Polo", "Mercedes", 37), new Person("ThunderBird", "Enfield", 70));

		System.out.println("----Traditional For Loop----");
		for (int i = 0; i < personList.size(); ++i) {
			System.out.println(personList.get(i));
		}

		System.out.println("\n\n----For in Loop----");
		for (Person person : personList) {
			System.out.println(person);
		}

		System.out.println("\n\n----For Each Lambda Loop----");
		/**
		 * forEach calls a Consumer reference which has a method accept gets a
		 * parameter. Here when person object is passed to accept then that method will
		 * print person object.
		 */
		personList.forEach(person -> System.out.println(person));

		System.out.println("\n\n----For Each Lambda Method Reference Loop----");

		/**
		 * Compiler knows forEach then each iteration will be passed person object and
		 * if :: means System.out instance calls println method
		 */
		personList.forEach(System.out::println);
		
		System.out.println("\n\n----Static Reference method ----");
		personList.forEach(DifferentForLoops::printOnlyCondition);
		
		/**
		 * Here in Predicate test method all conditions will be returned as true
		 */
		System.out.println("\n\n----Instance Reference method ----");
		printList(personList, person -> true, System.out::println);

		/**
		 * In Predicate test method process the condition which returns true.
		 */
		System.out.println("\n\n----For Certain Matching Condition ----");
		printList(personList, person -> person.getAge() > 37, System.out::println);
	}
	
	
	private static void printOnlyCondition(Person p) {
			System.out.println(p);
	}
	

	private static void printList(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer) {
		/**
		 * Predicate test method test the passed condition and in if loop if(true)
		 * Consumer accept method with process the passed condition and here asked to print to console
		 */
		personList.forEach(person -> {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		});
	}

}
