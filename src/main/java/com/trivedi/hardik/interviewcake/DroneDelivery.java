package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * 
 * Your company delivers breakfast via autonomous quadcopter drones. And
 * something mysterious has happened.
 * 
 * Each breakfast delivery is assigned a unique ID, a positive integer. When one
 * of the company's 100 drones takes off with a delivery, the delivery's ID is
 * added to an array, deliveryIdConfirmations. When the drone comes back and
 * lands, the ID is again added to the same array.
 * 
 * After breakfast this morning there were only 99 drones on the tarmac. One of
 * the drones never made it back from a delivery. We suspect a secret agent from
 * Amazon placed an order and stole one of our patented drones. To track them
 * down, we need to find their delivery ID.
 * 
 * Given the array of IDs, which contains many duplicate integers and one unique
 * integer, find the unique integer.
 * 
 * The IDs are not guaranteed to be sorted or sequential. Orders aren't always
 * fulfilled in the order they were received, and some deliveries get cancelled
 * before takeoff.
 * 
 * @author hardik
 *
 */
public class DroneDelivery {

	public static int findUniqueDeliveryId(int[] deliveryIds) {

		int uniqueDeliveryId = 0;

		for (int deliveryId : deliveryIds) {
			uniqueDeliveryId ^= deliveryId;
		}

		return uniqueDeliveryId;
	}

	// tests

	@Test
	public void oneDroneTest() {
		final int expected = 1;
		final int actual = findUniqueDeliveryId(new int[] { 1 });
		assertEquals(expected, actual);
	}

	@Test
	public void uniqueIdComesFirstTest() {
		final int expected = 1;
		final int actual = findUniqueDeliveryId(new int[] { 1, 2, 2 });
		assertEquals(expected, actual);
	}

	@Test
	public void uniqueIdComesLastTest() {
		final int expected = 1;
		final int actual = findUniqueDeliveryId(new int[] { 3, 3, 2, 2, 1 });
		assertEquals(expected, actual);
	}

	@Test
	public void uniqueIdInTheMiddleTest() {
		final int expected = 1;
		final int actual = findUniqueDeliveryId(new int[] { 3, 2, 1, 2, 3 });
		assertEquals(expected, actual);
	}

	@Test
	public void manyDronesTest() {
		final int expected = 8;
		final int actual = findUniqueDeliveryId(new int[] { 2, 5, 4, 8, 6, 3, 1, 4, 2, 3, 6, 5, 1 });
		assertEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(DroneDelivery.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}

}
