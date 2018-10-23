/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class SubsetsPowerSet {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		long powerSetSize = (long) Math.pow(2, nums.length);
		for (int counter = 0; counter < powerSetSize; counter++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if ((counter & (1 << j)) > 0) {
					subset.add(nums[j]);
				}
			}
			subsets.add(subset);
		}
		return subsets;
	}
}
