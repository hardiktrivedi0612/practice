package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class NthFibonacci {
	public static int fib(int n) {

		// compute the nth Fibonacci number

		if (n < 0) {
			throw new IllegalArgumentException("No negative numbers allowed");
		}

		if (n == 0 || n == 1)
			return n;
		
		int prevPrev = 0;
		int prev = 1;
		int current = 0;
		for(int i = 2; i <=n;i++) {
			current = prevPrev + prev;
			prevPrev = prev;
			prev= current;
		}
		return current;
		
	}

	// tests

	@Test
	public void zerothFibonacciTest() {
		final int actual = fib(0);
		final int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void firstFibonacciTest() {
		final int actual = fib(1);
		final int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void secondFibonacciTest() {
		final int actual = fib(2);
		final int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void thirdFibonacciTest() {
		final int actual = fib(3);
		final int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void fifthFibonacciTest() {
		final int actual = fib(5);
		final int expected = 5;
		assertEquals(expected, actual);
	}

	@Test
	public void tenthFibonacciTest() {
		final int actual = fib(10);
		final int expected = 55;
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void negativeFibonacciTest() {
		fib(-1);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(NthFibonacci.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
