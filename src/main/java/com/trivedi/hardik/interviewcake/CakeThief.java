package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * You are a renowned thief who has recently switched from stealing precious
 * metals to stealing cakes because of the insane profit margins. You end up
 * hitting the jackpot, breaking into the world's largest privately owned stock
 * of cakes—the vault of the Queen of England.
 * 
 * While Queen Elizabeth has a limited number of types of cake, she has an
 * unlimited supply of each type.
 * 
 * Each type of cake has a weight and a value, stored in objects of a CakeType
 * class:
 * 
 * public class CakeType {
 * 
 * final int weight; final int value;
 * 
 * public CakeType(int weight, int value) { this.weight = weight; this.value =
 * value; } }
 * 
 * Java
 * 
 * For example:
 * 
 * // weighs 7 kilograms and has a value of 160 shillings new CakeType(7, 160);
 * 
 * // weighs 3 kilograms and has a value of 90 shillings new CakeType(3, 90);
 * 
 * You brought a duffel bag that can hold limited weight, and you want to make
 * off with the most valuable haul possible.
 * 
 * Write a method maxDuffelBagValue() that takes an array of cake type objects
 * and a weight capacity, and returns the maximum monetary value the duffel bag
 * can hold.
 * 
 * For example:
 * 
 * CakeType[] cakeTypes = new CakeType[] { new CakeType(7, 160), new CakeType(3,
 * 90), new CakeType(2, 15), };
 * 
 * int capacity = 20;
 * 
 * maxDuffelBagValue(cakeTypes, capacity); // returns 555 (6 of the middle type
 * of cake and 1 of the last type of cake)
 * 
 * Weights and values may be any non-negative integer. Yes, it's weird to think
 * about cakes that weigh nothing or duffel bags that can't hold anything. But
 * we're not just super mastermind criminals—we're also meticulous about keeping
 * our algorithms flexible and comprehensive.
 *
 */
public class CakeThief {

	public static class CakeType {

		final int weight;
		final int value;

		public CakeType(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}

	public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

		// calculate the maximum value that we can carry

		// we make an array to hold the maximum possible value at every
		// duffel bag weight capacity from 0 to weightCapacity
		// starting each index with value 0
		long[] maxValuesAtCapacities = new long[weightCapacity + 1];

		for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {
			long currentMaxValue = 0;
			for (CakeType cakeType : cakeTypes) {
				// if a cake weighs 0 and has a positive value the value of our duffel bag is
				// infinite!
				if (cakeType.weight == 0 && cakeType.value != 0) {
					throw new InfinityException();
				}

				if (cakeType.weight <= currentCapacity) {
					long maxValueUsingCake = cakeType.value + maxValuesAtCapacities[currentCapacity - cakeType.weight];
					currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
				}
			}
			maxValuesAtCapacities[currentCapacity] = currentMaxValue;
		}

		return maxValuesAtCapacities[weightCapacity];
	}

	public static class InfinityException extends RuntimeException {
		public InfinityException() {
			super("Max value is infinity!");
		}
	}

	// tests

	@Test
	public void oneCakeTest() {
		final CakeType[] cakeTypes = { new CakeType(2, 1) };
		final int weightCapacity = 9;
		final long expected = 4;
		final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
		assertEquals(expected, actual);
	}

	@Test
	public void twoCakesTest() {
		final CakeType[] cakeTypes = { new CakeType(4, 4), new CakeType(5, 5) };
		final int weightCapacity = 9;
		final long expected = 9;
		final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
		assertEquals(expected, actual);
	}

	@Test
	public void onlyTakeLessValuableCakeTest() {
		final CakeType[] cakeTypes = { new CakeType(4, 4), new CakeType(5, 5) };
		final int weightCapacity = 12;
		final long expected = 12;
		final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
		assertEquals(expected, actual);
	}

	@Test
	public void lotsOfCakesTest() {
		final CakeType[] cakeTypes = { new CakeType(2, 3), new CakeType(3, 6), new CakeType(5, 1), new CakeType(6, 1),
				new CakeType(7, 1), new CakeType(8, 1) };
		final int weightCapacity = 7;
		final long expected = 12;
		final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
		assertEquals(expected, actual);
	}

	@Test
	public void valueToWeightRatioIsNotOptimalTest() {
		final CakeType[] cakeTypes = { new CakeType(51, 52), new CakeType(50, 50) };
		final int weightCapacity = 100;
		final long expected = 100;
		final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
		assertEquals(expected, actual);
	}

	@Test
	public void zeroCapacityTest() {
		final CakeType[] cakeTypes = { new CakeType(1, 2) };
		final int weightCapacity = 0;
		final long expected = 0;
		final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
		assertEquals(expected, actual);
	}

	@Test
	public void cakeWithZeroValueAndWeightTest() {
		final CakeType[] cakeTypes = { new CakeType(0, 0), new CakeType(2, 1) };
		final int weightCapacity = 7;
		final long expected = 3;
		final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void cakeWithNonZeroValueAndZeroWeightTest() {
		final CakeType[] cakeTypes = { new CakeType(0, 5) };
		final int weightCapacity = 5;
		maxDuffelBagValue(cakeTypes, weightCapacity);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CakeThief.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}

}
