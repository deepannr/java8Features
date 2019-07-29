package com.java.lambda.singleclass;

public class RunnableInterfaceExample {

	public static void main(String ar[]) {
		Thread innerClassThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("InnerClass Thread");

			}

		});

		innerClassThread.run();
		
		Thread lambdaThread = new Thread(() -> System.out.println("Lambda Thread"));
		lambdaThread.run();
		
		innerClassThread.stop();
		lambdaThread.stop();
	}

}
