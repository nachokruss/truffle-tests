package com.truffle.tests;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;

import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.vm.PolyglotEngine;
import com.oracle.truffle.api.vm.PolyglotEngine.Value;

public class BaseTruffleTest {
	
	private final static int WARM_UP_ITERATIONS = 10;

	private PolyglotEngine polyglotEngine = PolyglotEngine.newBuilder().build();
	
	protected void evalWithWarmup(String fileName) throws IOException {
		interpretScript(fileName, (source) -> {
			Duration tookFirst = evalAndGetDuration(polyglotEngine, source);
			for (int i = 0; i < WARM_UP_ITERATIONS; i++) {
				polyglotEngine.eval(source);
			}
			Duration tookLast = evalAndGetDuration(polyglotEngine, source);
			System.out.println("First run took " + tookFirst + "ms. last run took " + tookLast + "ms.");
		});
	}

	private Duration evalAndGetDuration(PolyglotEngine polyglotEngine, Source source) throws IOException {
		Instant startInstant = Instant.now();
		polyglotEngine.eval(source);
		Instant stopInstant = Instant.now();
		return Duration.between(startInstant, stopInstant);
	}
	
	protected void runOnce(String fileName) throws IOException {
		interpretScript(fileName, (source) -> polyglotEngine.eval(source));
	}
	
	protected void runOnceAndPrintResult(String fileName) throws IOException {
		interpretScript(fileName, (source) -> {
			Value result = polyglotEngine.eval(source);
			if (result == null || result.get() == null) {
				System.out.println("Got null result");
			} else {
				System.out.println("Eval result: " + result.get().toString());
			}
		});
	}
	
	/**
	 * Loads a file, creates a truffle source object and delegates to a
	 * Action/lambda
	 * 
	 * @param fileName
	 * @param action
	 * @throws IOException
	 */
	private void interpretScript(String fileName, Action action) throws IOException {
		URL resource = getClass().getClassLoader().getResource(fileName);
		if (resource != null) {
			String file = resource.getFile();
			Source source = Source.fromFileName(file);
			System.out.println("Running " + source.getMimeType() + ":");
			action.run(source);
			System.out.println();
		} else {
			System.err.println(fileName + " doesn't exist");
		}
	}
	
	@FunctionalInterface
	private interface Action {
		public void run(Source source) throws IOException;
	}

}
