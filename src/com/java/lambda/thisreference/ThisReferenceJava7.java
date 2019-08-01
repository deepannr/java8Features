package com.java.lambda.thisreference;

public class ThisReferenceJava7 {

	public static void main(String[] args) {
		ThisReferenceJava7 javaRefr = new ThisReferenceJava7();
		javaRefr.processInterface(10, new Process() {

			@Override
			public void proceed(int i) {
				System.out.println("Value : " + i);

				/**
				 * this reference prints the reference of the anonymous inner class Process
				 */
				System.out.println(this);
			}

			@Override
			public String toString() {
				return "This Reference";
			}
		});
	}

	void processInterface(int i, Process p) {
		p.proceed(i);
	}

	interface Process {
		void proceed(int i);
	}

	@Override
	public String toString() {
		return "Class This Reference";
	}

}
