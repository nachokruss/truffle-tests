package com.truffle.tests;

import java.io.IOException;

public class AlgorithmTest extends BaseTruffleTest {
	
	private static final String JS_BUBBLE_SORT = "bubbleSort/bubbleSort.js";
	private static final String RUBY_BUBBLE_SORT = "bubbleSort/bubbleSort.rb";
	private static final String R_BUBBLE_SORT = "bubbleSort/bubbleSort.R";

	public static void main(String[] args) throws IOException {
		new AlgorithmTest().run();
	}

	private void run() throws IOException {
		evalWithWarmup(JS_BUBBLE_SORT);
		evalWithWarmup(RUBY_BUBBLE_SORT);
		evalWithWarmup(R_BUBBLE_SORT);
	}
	
}
