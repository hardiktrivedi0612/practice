package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class BracketValidator {
	public static boolean isValidMySolution(String code) {

		// determine if the input code is valid
		Deque<Character> bracketStack = new ArrayDeque<>();
		if (code == null) {
			throw new IllegalArgumentException("Code is null");
		}
		if (code.length() == 0) {
			return true;
		}

		for (int i = 0; i < code.length(); i++) {
			Character c = code.charAt(i);
			if (c.equals('(') || c.equals('[') || c.equals('{')) {
				bracketStack.push(c);
			} else if (c.equals(')')) {
				if (!bracketStack.isEmpty() && !bracketStack.peek().equals('(')) {
					return false;
				} else {
					if (bracketStack.isEmpty()) {
						return false;
					}
					bracketStack.pop();
				}
			} else if (c.equals(']')) {
				if (!bracketStack.isEmpty() && !bracketStack.peek().equals('[')) {
					return false;
				} else {
					if (bracketStack.isEmpty()) {
						return false;
					}
					bracketStack.pop();
				}
			} else if (c.equals('}')) {
				if (!bracketStack.isEmpty() && !bracketStack.peek().equals('{')) {
					return false;
				} else {
					if (bracketStack.isEmpty()) {
						return false;
					}
					bracketStack.pop();
				}
			}
		}
		if (!bracketStack.isEmpty())
			return false;
		return true;
	}

	public static boolean isValid(String code) {

		// determine if the input code is valid

		Map<Character, Character> openersToClosers = new HashMap<>();
		openersToClosers.put('(', ')');
		openersToClosers.put('[', ']');
		openersToClosers.put('{', '}');

		Set<Character> openers = openersToClosers.keySet();
		Set<Character> closers = new HashSet<>(openersToClosers.values());

		Deque<Character> openersStack = new ArrayDeque<>();

		if (code == null) {
			throw new IllegalArgumentException("Code is null");
		}
		if (code.length() == 0) {
			return true;
		}

		for (char c : code.toCharArray()) {
			if (openers.contains(c)) {
				openersStack.push(c);
			} else if (closers.contains(c)) {
				if (openersStack.isEmpty()) {
					return false;
				} else {
					char lastUnclosedOpener = openersStack.pop();

					// if this closer doesn't correspond to the most recently
					// seen unclosed opener, short-circuit, returning false
					if (openersToClosers.get(lastUnclosedOpener) != c) {
						return false;
					}
				}
			}
		}
		return openersStack.isEmpty();
	}

	// tests

	@Test
	public void validShortCodeTest() {
		final boolean result = isValid("()");
		assertTrue(result);
	}

	@Test
	public void validLongerCodeTest() {
		final boolean result = isValid("([]{[]})[]{{}()}");
		assertTrue(result);
	}

	@Test
	public void mismatchedOpenerAndCloserTest() {
		final boolean result = isValid("([][]}");
		assertFalse(result);
	}

	@Test
	public void missingCloserTest() {
		final boolean result = isValid("[[]()");
		assertFalse(result);
	}

	@Test
	public void extraCloserTest() {
		final boolean result = isValid("[[]]())");
		assertFalse(result);
	}

	@Test
	public void emptyStringTest() {
		final boolean result = isValid("");
		assertTrue(result);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(BracketValidator.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
