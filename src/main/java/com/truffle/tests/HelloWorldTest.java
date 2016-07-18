package com.truffle.tests;

/**
 * Initializes Truffle PolyglotEngine and runs 2 tests in R, ruby and Javascript
 * 
 * Test 1: Interpret a script that prints "Hello World" to standard output
 * Test 2: Interpret a script that runs a function that returns "Hello World"
 * 
 * 
 * @author Ignacio Kruss <nachokruss@gmail.com>
 *
 */
public class HelloWorldTest extends BaseTruffleTest {
	
	private static final String TEST1_JS_HELLOWORLD = "test1/helloworld.js";
	private static final String TEST1_RUBY_HELLOWORLD = "test1/helloworld.rb";
	private static final String TEST1_R_HELLOWORLD = "test1/helloworld.R";
	
	private static final String TEST2_JS_HELLOWORLD = "test2/helloworld.js";
	private static final String TEST2_RUBY_HELLOWORLD = "test2/helloworld.rb";
	private static final String TEST2_R_HELLOWORLD = "test2/helloworld.R";

	public static void main(String[] args) throws Exception {
		new HelloWorldTest().run();
	}

	private void run() throws Exception {
		System.out.println("Starting test 1 (print to standard out from script)");
		runOnce(TEST1_JS_HELLOWORLD);
		runOnce(TEST1_RUBY_HELLOWORLD);
		runOnce(TEST1_R_HELLOWORLD);
		
		System.out.println("Starting test 2 (return value from script funciton)");
		runOnceAndPrintResult(TEST2_JS_HELLOWORLD);
		runOnceAndPrintResult(TEST2_RUBY_HELLOWORLD);
		runOnceAndPrintResult(TEST2_R_HELLOWORLD);
	}

}
