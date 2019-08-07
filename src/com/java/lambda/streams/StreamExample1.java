package com.java.lambda.streams;

import java.util.Arrays;
import java.util.List;

import com.java.lambda.exercise1.Person;

public class StreamExample1 {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Hero", "Maestro", 65), new Person("Honda", "Unicorn", 39),
				new Person("Benz", "Mercedes", 37), new Person("ThunderBird", "Enfield", 70));

		personList.stream().filter(p -> p.getFirstName().startsWith("H"))
				.forEach(p -> System.out.println(p.getFirstName()));
		
		System.out.println(personList.parallelStream().filter(p -> p.getLastName().startsWith("M")).count());
	}

}
