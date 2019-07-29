package com.java.lambda.multiInit;

@FunctionalInterface

/*
 * Functional Interface means can declare only one method which is used for
 * Lambda. When another method is added to interface, it will throw compile time
 * issue in interface.
 */
public interface InterfaceInit {
	void perform();
}
