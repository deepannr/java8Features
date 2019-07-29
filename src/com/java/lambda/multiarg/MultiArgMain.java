package com.java.lambda.multiarg;

public class MultiArgMain {
	public static void main(String ar[]) {
		OneArgFuncInterface oneArg = (arg) -> arg * 2;
		System.out.println("One Arg Functional Interface : " + oneArg.returnOneArg(10));

		TwoArgFuncInterface twoArg = (arg1, arg2) -> {
			if (null != arg1 && null != arg2) {
				return arg1 + arg2;
			} else if (null == arg1 && null != arg2) {
				return arg2;
			} else if (null == arg2 && null != arg1) {
				return arg1;
			}
			return "Both Empty String";
		};
		System.out.println("Two Arg Functional Interface : " + twoArg.twoArgFunction("First", "Second"));
	}
}
