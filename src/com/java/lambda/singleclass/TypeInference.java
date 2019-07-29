package com.java.lambda.singleclass;

public class TypeInference {

	public static void main(String[] args) {
		// Type Inference is don't need to give like (String s1, String s2) -> (s1 +
		// s2).length(); Because
		// the compiler is smart to find type from the method.
		TypeInferenceInterface inference = (s1, s2) -> (s1 + s2).length();
		System.out.println(inference.stringLength("ABC", "DEF"));
	}

	interface TypeInferenceInterface {
		int stringLength(String s1, String s2);
	}
}
