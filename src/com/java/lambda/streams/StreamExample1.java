package com.java.lambda.streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

import com.java.lambda.exercise1.Person;

public class StreamExample1 {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Hero", "Maestro", 65), new Person("Honda", "Unicorn", 39),
				new Person("Benz", "Mercedes", 37), new Person("ThunderBird", "Enfield", 70));

		personList.stream().filter(p -> p.getFirstName().startsWith("H"))
				.forEach(p -> System.out.println(p.getFirstName()));

		System.out.println(personList.parallelStream().filter(p -> p.getLastName().startsWith("M")).count());

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
	}

}
