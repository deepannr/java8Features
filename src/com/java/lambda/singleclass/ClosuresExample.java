package com.java.lambda.singleclass;

import java.util.function.Consumer;

public class ClosuresExample {

	public static void main(String[] args) {
		int first = 10;
		int second = 20;
		process(first, newNumber -> System.out.println(newNumber + second));
		/*
		 *  ++second;
		 *  
		 *  On uncommenting the previous line, it will throw compile time error,
		 * 
		 * Local variable second defined in an enclosing scope must be final or
		 * effectively final.
		 * 
		 * Here if any number is tried to alter then will throw compile time error.
		 * Because the number second is closure ie made to final.
		 */
	}

	private static void process(int i, Consumer<Integer> consumer) {
		consumer.accept(i);
	}

}
