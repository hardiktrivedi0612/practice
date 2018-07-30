package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MatchingParenthesis {
	public static int getClosingParenMySolution(String sentence, int openingParenIndex) {

		// find the position of the matching closing parenthesis

		Deque<ParenthesisWithIndex> stack = new ArrayDeque<>();

		if (openingParenIndex >= sentence.length()) {
			throw new IllegalArgumentException("Illegal openingParenIndex");
		}

		for (int i = openingParenIndex; i < sentence.length(); i++) {
			Character c = sentence.charAt(i);
			if (c.equals('(')) {
				stack.push(new ParenthesisWithIndex(c, i));
			} else if (c.equals(')')) {
				if (stack.size() == 1 && stack.peek().parenthesis.equals('(')) {
					// This is the closing parenthesis
					return i;
				} else {
					stack.pop();
				}
			}
		}

		throw new IllegalArgumentException("Illegal String");
	}

	public static int getClosingParen(String sentence, int openingParenIndex) {

		// find the position of the matching closing parenthesis

		int openParenthesisCount = 0;

		if (openingParenIndex >= sentence.length()) {
			throw new IllegalArgumentException("Illegal openingParenIndex");
		}

		for (int i = openingParenIndex; i < sentence.length(); i++) {
			Character c = sentence.charAt(i);
			if (c.equals('(')) {
				openParenthesisCount++;
			} else if (c.equals(')')) {
				if (openParenthesisCount == 1) {
					// This is the closing parenthesis
					return i;
				} else {
					openParenthesisCount--;
				}
			}
		}

		throw new IllegalArgumentException("No closing parenthesis found");
	}

	static class ParenthesisWithIndex {
		Character parenthesis;
		Integer index;

		ParenthesisWithIndex(Character parenthesis, Integer index) {
			this.parenthesis = parenthesis;
			this.index = index;
		}
	}

	// tests

	@Test
	public void allOpenersThenClosersTest() {
		final int expected = 7;
		final int actual = getClosingParen("((((()))))", 2);
		assertEquals(expected, actual);
	}

	@Test
	public void mixedOpenersAndClosersTest() {
		final int expected = 10;
		final int actual = getClosingParen("()()((()()))", 5);
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void noMatchingCloserTest() {
		getClosingParen("()(()", 2);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MatchingParenthesis.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
