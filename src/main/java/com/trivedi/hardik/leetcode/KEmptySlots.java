/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode;

import java.util.TreeSet;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class KEmptySlots {
	public int kEmptySlots(int[] flowers, int k) {
		TreeSet<Integer> active = new TreeSet<>();
		int day = 0;
		for (int flower : flowers) {
			day++;
			active.add(flower);
			Integer lower = active.lower(flower);
			Integer higher = active.higher(flower);
			if (lower != null && flower - lower - 1 == k || higher != null && higher - flower - 1 == k)
				return day;
		}
		return -1;
	}
}
