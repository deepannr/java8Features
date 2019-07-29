package com.java.lambda.multiinit;

public class InitilizerMain {
	
	private void callInterfaceInit(InterfaceInit initInterface) {
		initInterface.perform();
	}

	public static void main(String[] args) {
		InitilizerMain initMain = new InitilizerMain();
		InterfaceInit init = new InterfaceInitImpl();
		initMain.callInterfaceInit(init);
		
		InterfaceInit inline = new InterfaceInit() {
			@Override
			public void perform() {
				System.out.println("Initilizer Inline");
				
			}
		};
		initMain.callInterfaceInit(inline);
		
		InterfaceInit lambda = () -> System.out.println("Lambda Print");
		
		// When lambda with () is called which by default calls perform method 
		initMain.callInterfaceInit(lambda);
	}
}
