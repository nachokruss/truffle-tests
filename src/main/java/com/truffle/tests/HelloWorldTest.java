package com.truffle.tests;

import java.io.IOException;
import java.net.URL;

import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.vm.PolyglotEngine;
import com.oracle.truffle.api.vm.PolyglotEngine.Value;

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
public class HelloWorldTest {
	
	private PolyglotEngine polyglotEngine = PolyglotEngine.newBuilder().build();

	
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
		interpretScript(TEST1_JS_HELLOWORLD, polyglotEngine);
		interpretScript(TEST1_RUBY_HELLOWORLD, polyglotEngine);
		interpretScript(TEST1_R_HELLOWORLD, polyglotEngine);
		
		System.out.println("Starting test 2 (return value from script funciton)");
		evalResultTest(TEST2_JS_HELLOWORLD, polyglotEngine);
		evalResultTest(TEST2_RUBY_HELLOWORLD, polyglotEngine);
		evalResultTest(TEST2_R_HELLOWORLD, polyglotEngine);
	}

	private void evalResultTest(String fileName, PolyglotEngine polyglotEngine) throws IOException {
		URL resource = getClass().getClassLoader().getResource(fileName);
		if (resource != null) {
			String file = resource.getFile();
			Source source = Source.fromFileName(file);
			System.out.println(source.getMimeType() + ":");
			Value result = polyglotEngine.eval(source);
			if (result == null || result.get() == null) {
				System.out.println("Got null result");
			} else {
				System.out.println("Eval result: " + result.get().toString());
			}
			System.out.println();
		} else {
			System.err.println(fileName + " doesn't exist");
		}
	}
	
	private void interpretScript(String fileName, PolyglotEngine polyglotEngine) throws IOException {
		URL resource = getClass().getClassLoader().getResource(fileName);
		if (resource != null) {
			String file = resource.getFile();
			Source source = Source.fromFileName(file);
			System.out.println("Running " + source.getMimeType() + ":");
			polyglotEngine.eval(source);
			System.out.println();
		} else {
			System.err.println(fileName + " doesn't exist");
		}
	}

}
