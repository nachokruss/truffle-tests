package com.truffle.tests;

import java.io.IOException;
import java.net.URL;

import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.vm.PolyglotEngine;

public class InteropTest {
	
	private PolyglotEngine polyglotEngine = PolyglotEngine.newBuilder().build();
	
	private final static int WARM_UP_ITERATIONS = 10;
	private static final String JS_BUBBLE_SORT = "interop/interop.js";

	public static void main(String[] args) throws IOException {
		new InteropTest().run();
	}

	private void run() throws IOException {
		interpretScript(JS_BUBBLE_SORT, polyglotEngine);
	}
	
	private void interpretScript(String fileName, PolyglotEngine polyglotEngine) throws IOException {
		URL resource = getClass().getClassLoader().getResource(fileName);
		if (resource != null) {
			String file = resource.getFile();
			Source source = Source.fromFileName(file);
			System.out.println("Running " + source.getMimeType() + ":");
			long tookFirst = interpretAndGetTime(polyglotEngine, source);
			for (int i = 0; i < WARM_UP_ITERATIONS; i++) {
				polyglotEngine.eval(source);
			}
			long tookLast = interpretAndGetTime(polyglotEngine, source);
			System.out.println("First run took " + tookFirst + "ms. last run took " + tookLast + "ms.");
			System.out.println();
		} else {
			System.err.println(fileName + " doesn't exist");
		}
	}

	private long interpretAndGetTime(PolyglotEngine polyglotEngine, Source source) throws IOException {
		long currentTimeMillis = System.currentTimeMillis();
		polyglotEngine.eval(source);
		long took = System.currentTimeMillis() - currentTimeMillis;
		return took;
	}
	
}
