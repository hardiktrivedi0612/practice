package com.trivedi.hardik.interviewcake;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * I want to learn some big words so people think I'm smart.
 * 
 * I opened up a dictionary to a page in the middle and started flipping
 * through, looking for words I didn't know. I put each word I didn't know at
 * increasing indices in a huge array I created in memory. When I reached the
 * end of the dictionary, I started from the beginning and did the same thing
 * until I reached the page I started at.
 * 
 * Now I have an array of words that are mostly alphabetical, except they start
 * somewhere in the middle of the alphabet, reach the end, and then start from
 * the beginning of the alphabet. In other words, this is an alphabetically
 * ordered array that has been "rotated." For example:
 * 
 * String[] words = new String[]{ "ptolemaic", "retrograde", "supplant",
 * "undulate", "xenoepist", "asymptote", // <-- rotates here! "babka",
 * "banoffee", "engender", "karpatka", "othellolagkage", };
 * 
 * Write a method for finding the index of the "rotation point," which is where
 * I started working from the beginning of the dictionary. This array is huge
 * (there are lots of words I don't know) so we want to be efficient here.
 * 
 * @author hardik
 *
 */
public class RotationPoint {

	public static int findRotationPoint(String[] words) {

		final String firstWord = words[0];

		int floorIndex = 0;
		int ceilingIndex = words.length - 1;

		while (floorIndex < ceilingIndex) {

			// guess a point halfway between floor and ceiling
			int guessIndex = floorIndex + ((ceilingIndex - floorIndex) / 2);

			// if guess comes after first word or is the first word
			if (words[guessIndex].compareTo(firstWord) >= 0) {
				// go right
				floorIndex = guessIndex;
			} else {
				// go left
				ceilingIndex = guessIndex;
			}

			// if floor and ceiling have converged
			if (floorIndex + 1 == ceilingIndex) {

				// between floor and ceiling is where we flipped to the beginning
				// so ceiling is alphabetically first
				break;
			}
		}

		if (words[ceilingIndex].compareTo(firstWord) >= 0) {
			return 0;
		}

		return ceilingIndex;

//		int prevIndex = 0;
//		for(int i = 1; i < words.length ; i ++) {
//			if(words[prevIndex].compareTo(words[i]) > 0) {
//				return i;
//			}
//			prevIndex++;
//		}
//		
//		return 0;
	}

	@Test
	public void smallArrayTest() {
		final int actual = findRotationPoint(new String[] { "cape", "cake" });
		final int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void mediumArrayTest() {
		final int actual = findRotationPoint(new String[] { "grape", "orange", "plum", "radish", "apple" });
		final int expected = 4;
		assertEquals(expected, actual);
	}

	@Test
	public void largeArrayTest() {
		final int actual = findRotationPoint(new String[] { "ptolemaic", "retrograde", "supplant", "undulate",
				"xenoepist", "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage" });
		final int expected = 5;
		assertEquals(expected, actual);
	}

	@Test
	public void possiblyMissingEdgeCaseTest() {
		final int actual = findRotationPoint(new String[] { "grape", "orange", "plum", "radish" });
		final int expected = 0;
		assertEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(RotationPoint.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}

}
