package com.trivedi.hardik.leetcode;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0
 * represents that the seat is empty.
 * 
 * There is at least one empty seat, and at least one person sitting.
 * 
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized.
 * 
 * Return that maximum distance to closest person.
 * 
 * @author hardik
 *
 */
public class MaximizeDistanceToClosestPerson {
	public int maxDistToClosest(int[] seats) {
		int left = -1, maxDis = 0;
		int len = seats.length;
		for (int i = 0; i < len; i++) {
			if (seats[i] == 0)
				continue;

			if (left == -1) {
				maxDis = Math.max(maxDis, i);
			} else {
				maxDis = Math.max(maxDis, (i - left) / 2);
			}
			left = i;
		}

		if (seats[len - 1] == 0) {
			maxDis = Math.max(maxDis, len - 1 - left);
		}

		return maxDis;
	}
}
