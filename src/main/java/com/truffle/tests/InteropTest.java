package com.truffle.tests;

import java.io.IOException;

public class InteropTest extends BaseTruffleTest {
	
	private static final String JS_BUBBLE_SORT = "interop/interop.js";

	public static void main(String[] args) throws IOException {
		new InteropTest().run();
	}

	private void run() throws IOException {
		evalWithWarmup(JS_BUBBLE_SORT);
	}
	
}
