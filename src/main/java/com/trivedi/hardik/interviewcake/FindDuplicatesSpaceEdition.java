package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * 
 * Find a duplicate, Space Edition�.
 * 
 * We have an array of integers, where:
 * 
 * The integers are in the range 1....n The array has a length of n+1
 * 
 * It follows that our array has at least one integer which appears at least
 * twice. But it may have several duplicates, and each duplicate may appear more
 * than twice.
 * 
 * Write a method which finds an integer that appears more than once in our
 * array. (If there are multiple duplicates, you only need to find one of them.)
 * 
 * We're going to run this method on our new, super-hip MacBook Pro With Retina
 * Display�. Thing is, the damn thing came with the RAM soldered right to the
 * motherboard, so we can't upgrade our RAM. So we need to optimize for space!
 * 
 * @author hardik
 *
 */
public class FindDuplicatesSpaceEdition {

	// This is the O(nlgn) solution
	public static int findRepeat(int[] theArray) {

		int floor = 1;
		int ceiling = theArray.length - 1;

		while (floor < ceiling) {

			// divide our range 1..n into an upper range and lower range
			// (such that they don't overlap)
			// lower range is floor..midpoint
			// upper range is midpoint+1..ceiling
			int midpoint = floor + ((ceiling - floor) / 2);
			int lowerRangeFloor = floor;
			int lowerRangeCeiling = midpoint;
			int upperRangeFloor = midpoint + 1;
			int upperRangeCeiling = ceiling;

			// count number of items in lower range
			int itemsInLowerRange = 0;
			for (int item : theArray) {

				// is it in the lower range?
				if (item >= lowerRangeFloor && item <= lowerRangeCeiling) {
					itemsInLowerRange += 1;
				}
			}

			int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

			if (itemsInLowerRange > distinctPossibleIntegersInLowerRange) {

				// there must be a duplicate in the lower range
				// so use the same approach iteratively on that range
				floor = lowerRangeFloor;
				ceiling = lowerRangeCeiling;
			} else {

				// there must be a duplicate in the upper range
				// so use the same approach iteratively on that range
				floor = upperRangeFloor;
				ceiling = upperRangeCeiling;
			}
		}

		// floor and ceiling have converged
		// we found a number that repeats!
		return floor;
	}

	// This is the O(n) solution
	public static int findDuplicate(int[] intArray) {

		final int n = intArray.length - 1;

		// STEP 1: GET INSIDE A CYCLE
		// start at position n+1 and walk n steps to
		// find a position guaranteed to be in a cycle
		int positionInCycle = n + 1;
		for (int i = 0; i < n; i++) {

			// we subtract 1 from the current position to step ahead:
			// the 2nd *position* in an array is *index* 1
			positionInCycle = intArray[positionInCycle - 1];
		}

		// STEP 2: FIND THE LENGTH OF THE CYCLE
		// find the length of the cycle by remembering a position in the cycle
		// and counting the steps it takes to get back to that position
		int rememberedPositionInCycle = positionInCycle;
		int currentPositionInCycle = intArray[positionInCycle - 1]; // 1 step ahead
		int cycleStepCount = 1;

		while (currentPositionInCycle != rememberedPositionInCycle) {
			currentPositionInCycle = intArray[currentPositionInCycle - 1];
			cycleStepCount += 1;
		}

		// STEP 3: FIND THE FIRST NODE OF THE CYCLE
		// start two pointers
		// (1) at position n+1
		// (2) ahead of position n+1 as many steps as the cycle's length
		int pointerStart = n + 1;
		int pointerAhead = n + 1;
		for (int i = 0; i < cycleStepCount; i++) {
			pointerAhead = intArray[pointerAhead - 1];
		}

		// advance until the pointers are in the same position
		// which is the first node in the cycle
		while (pointerStart != pointerAhead) {
			pointerStart = intArray[pointerStart - 1];
			pointerAhead = intArray[pointerAhead - 1];
		}

		// since there are multiple values pointing to the first node
		// in the cycle, its position is a duplicate in our array
		return pointerStart;
	}

	// tests

	@Test
	public void justTheRepeatedNumberTest() {
		final int[] numbers = { 1, 1 };
		final int expected = 1;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void shortArrayTest() {
		final int[] numbers = { 1, 2, 3, 2 };
		final int expected = 2;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void mediumArrayTest() {
		final int[] numbers = { 1, 2, 5, 5, 5, 5 };
		final int expected = 5;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void longArrayTest() {
		final int[] numbers = { 4, 1, 4, 8, 3, 2, 7, 6, 5 };
		final int expected = 4;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(FindDuplicatesSpaceEdition.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}

}
