package com.java.lambda.methodreference;

public class MethodReference1 {

	public static void main(String[] args) {

		/**
		 * This is equivalent to Thread thread = new Thread(() ->
		 * System.out.println("Thread")); ie Lambda calls runnable run method with no
		 * argument passed and calls no argument method.
		 * 
		 * Static method reference
		 */
		Thread thread = new Thread(MethodReference1::printMethod);

		thread.start();
	}

	private static void printMethod() {
		System.out.println("Method Reference No Arg");
	}

}
