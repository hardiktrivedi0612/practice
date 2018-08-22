package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * 
 * You decide to test if your oddly-mathematical heating company is fulfilling
 * its All-Time Max, Min, Mean and Mode Temperature Guarantee™.
 * 
 * Write a class TempTracker with these methods:
 * 
 * insert()—records a new temperature getMax()—returns the highest temp we've
 * seen so far getMin()—returns the lowest temp we've seen so far
 * getMean()—returns the mean ↴ of all temps we've seen so far getMode()—returns
 * a mode ↴ of all temps we've seen so far
 * 
 * Optimize for space and time. Favor speeding up the getter methods getMax(),
 * getMin(), getMean(), and getMode() over speeding up the insert() method.
 * 
 * getMean() should return a double, but the rest of the getter methods can
 * return integers. Temperatures will all be inserted as integers. We'll record
 * our temperatures in Fahrenheit, so we can assume they'll all be in the range
 * 0..1100..1100..110.
 * 
 * If there is more than one mode, return any of the modes.
 * 
 * @author hardik
 *
 */
public class TemperatureTracker {

	static class TempTracker {

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		long sum;
		int count;
		double mean;
		private int[] occurrences = new int[111]; // array of 0s at indices 0..110
		private int maxOccurrences;
		private int mode;

		// fill in the TempTracker class methods below

		// records a new temperature
		public void insert(int temperature) {
			min = Math.min(min, temperature);
			max = Math.max(max, temperature);

			sum += temperature;
			count++;
			mean = (double) sum / count;

			occurrences[temperature]++;
			if (occurrences[temperature] > maxOccurrences) {
				mode = temperature;
				maxOccurrences = occurrences[temperature];
			}
		}

		// returns the highest temp we've seen so far
		public int getMax() {
			return max;
		}

		// returns the lowest temp we've seen so far
		public int getMin() {
			return min;
		}

		// returns the mean of all temps we've seen so far
		public double getMean() {
			return mean;
		}

		// return a mode of all temps we've seen so far
		public int getMode() {
			return mode;
		}
	}

	// tests

	@Test
	public void temperatureTrackerTest() {
		final double precision = 1e-6;

		final TempTracker t = new TempTracker();

		t.insert(50);
		assertEquals("step 1: max:", 50, t.getMax());
		assertEquals("step 1: min:", 50, t.getMin());
		assertEquals("step 1: mean:", 50.0, t.getMean(), precision);
		assertEquals("step 3: mode:", 50, t.getMode());

		t.insert(80);
		assertEquals("step 2: max:", 80, t.getMax());
		assertEquals("step 2: min:", 50, t.getMin());
		assertEquals("step 2: mean:", 65.0, t.getMean(), precision);
		assertTrue("step 2: mode:", t.getMode() == 50 || t.getMode() == 80);

		t.insert(80);
		assertEquals("step 3: max:", 80, t.getMax());
		assertEquals("step 3: min:", 50, t.getMin());
		assertEquals("step 3: mean:", 70.0, t.getMean(), precision);
		assertEquals("step 3: mode:", 80, t.getMode());

		t.insert(30);
		assertEquals("step 4: max:", 80, t.getMax());
		assertEquals("step 4: min:", 30, t.getMin());
		assertEquals("step 4: mean:", 60.0, t.getMean(), precision);
		assertEquals("step 4: mode:", 80, t.getMode());
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TemperatureTracker.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
