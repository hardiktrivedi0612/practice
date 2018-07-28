package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RecursiveStringPermutations {

	public static Set<String> getPermutations(String inputString) {

		// generate all permutations of the input string
		// base case
	    if (inputString.length() <= 1) {
	        return new HashSet<>(Collections.singletonList(inputString));
	    }

	    String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
	    char lastChar = inputString.charAt(inputString.length() - 1);

	    // recursive call: get all possible permutations for all chars except last
	    Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

	    // put the last char in all possible positions for each of the above permutations
	    Set<String> permutations = new HashSet<>();
	    for (String permutationOfAllCharsExceptLast : permutationsOfAllCharsExceptLast) {
	        for (int position = 0; position <= allCharsExceptLast.length(); position++) {
	            String permutation = permutationOfAllCharsExceptLast.substring(0, position) + lastChar
	                + permutationOfAllCharsExceptLast.substring(position);
	            permutations.add(permutation);
	        }
	    }

	    return permutations;
	}

	// tests

	@Test
	public void emptyStringTest() {
		final Set<String> expected = new HashSet<>(Arrays.asList(""));
		final Set<String> actual = getPermutations("");
		assertEquals(expected, actual);
	}

	@Test
	public void oneCharacterStringTest() {
		final Set<String> expected = new HashSet<>(Arrays.asList("a"));
		final Set<String> actual = getPermutations("a");
		assertEquals(expected, actual);
	}

	@Test
	public void twoCharacterStringTest() {
		final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
		final Set<String> actual = getPermutations("ab");
		assertEquals(expected, actual);
	}

	@Test
	public void threeCharacterStringTest() {
		final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba"));
		final Set<String> actual = getPermutations("abc");
		assertEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(RecursiveStringPermutations.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}

}
