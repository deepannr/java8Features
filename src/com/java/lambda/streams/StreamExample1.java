package com.java.lambda.streams;

import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import com.java.lambda.exercise1.Gender;
import com.java.lambda.exercise1.Person;

public class StreamExample1 {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Hero", "Maestro", Gender.MALE, 65),
				new Person("Honda", "Unicorn", Gender.MALE, 39), new Person("Benz", "Mercedes", Gender.FEMALE, 37),
				new Person("Hero", "Master", Gender.MALE, 2), new Person("Benz", "Merry", Gender.MALE, 7),
				new Person("ThunderBird", "Enfield", Gender.MALE, 70));

		System.out.println("----First Name Starts with H");
		personList.stream().filter(p -> p.getFirstName().startsWith("H"))
				.forEach(p -> System.out.println(p.getFirstName()));

		System.out.println("----Persons Count on Last Name Starts with M: "
				+ personList.parallelStream().filter(p -> p.getLastName().startsWith("M")).count());

		List<String> nameList = personList.stream().filter(person -> person.getAge() > 39)
				.map(person -> person.getFirstName()).map(fName -> fName.toUpperCase()).collect(toList());
		System.out.println("Lambda Streams : " + nameList);

		/**
		 * Here Person class has getFirstName method and String Class has toUpperCase
		 * method
		 */
		nameList = personList.stream().filter(person -> person.getAge() > 39).map(Person::getFirstName)
				.map(String::toUpperCase).collect(toList());
		System.out.println("Lambda Streams Method References : " + nameList);

		System.out.println(
				"Count For Certain Category : " + personList.stream().filter(person -> person.getAge() > 39).count());

		/**
		 * Even though Age is integer, need to map that stream to integer/
		 */
		System.out.println("Total Age: " + personList.stream().mapToInt(Person::getAge).sum());
		
		System.out.println("Print All First Names: " + personList.stream().map(Person::getFirstName).collect(toList()));

		System.out.println("Max Age: " + personList.stream().filter(person -> person.getGender() == Gender.MALE)
				.max((person1, person2) -> person1.getAge().compareTo(person2.getAge()))
				.map(person -> person.getFirstName().toUpperCase()));

		List<String> majorList = personList.stream().filter(person -> person.getAge() > 17).map(Person::getFirstName)
				.collect(toList());
		System.out.println("majorList : " + majorList);

		System.out.println("Male Gender List : " + personList.stream()
				.filter(person -> person.getGender() == Gender.MALE).map(Person::getFirstName).collect(toList()));

		/**
		 * Set will remove duplicates, so Hero occurs twice but once only printed.
		 */
		System.out.println("Male Gender Set : " + personList.stream()
				.filter(person -> person.getGender() == Gender.MALE).map(Person::getFirstName).collect(toSet()));

		Map<String, List<Person>> myMap = personList.stream().filter(person -> person.getGender() == Gender.MALE)
				.collect(Collectors.groupingBy(Person::getFirstName));
		System.out.println("Male Gender Map : " + myMap);

		/**
		 * This will no work
		 * 
		 * personList.stream().filter(person -> person.getGender() ==
		 * Gender.MALE).map(Person::getFirstName).collect(Collectors.groupingBy(Person::getFirstName));
		 * 
		 */

		// personList.stream().filter(person -> person.getAge() >
		// 17).collect(Collectors.)

		System.out.println("Matching Name : "
				+ personList.stream().filter(person -> person.getFirstName().length() == 4).findFirst());

		System.out.println("Matching Name Another Way : "
				+ personList.stream().filter(StreamExample1::isFourLettersFirstName).findFirst());

		System.out.print("Print 10 Even Numbers : ");
		Stream.iterate(0, e -> e + 1).filter(e -> e % 2 == 0).limit(10).forEach(System.out::println);

		System.out.print("Print Even Numbers Starting from 4 (seed first param in iterate) : ");
		Stream.iterate(4, e -> e + 1).filter(e -> e % 2 == 0).limit(10).forEach(System.out::println);
	}

	private static boolean isFourLettersFirstName(Person person) {
		return person.getFirstName().length() == 4;
	}

}
