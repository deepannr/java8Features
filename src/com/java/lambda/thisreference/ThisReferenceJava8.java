package com.java.lambda.thisreference;

public class ThisReferenceJava8 {

	public static void main(String[] args) {
		ThisReferenceJava8 thisRefr = new ThisReferenceJava8();
		thisRefr.processInterface(10, i -> {
			System.out.println("Inside Main Method : " + ++i);

			/**
			 * System.out.println(this);
			 * 
			 * Here Lambda is treated as static content. So this will not work.
			 */
		});
		
		thisRefr.execute();
	}

	void execute() {
		processInterface(10, i -> {
			System.out.println("\n\nInside Instance Method : " + ++i);
			
			/**
			 * Here this notifies the class reference.
			 */
			System.out.println(this);
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
