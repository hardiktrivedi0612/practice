/*
 * Copyright (C) 2018 Copart, Inc. All rights reserved.
 */
package com.trivedi.hardik.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> remainder = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int rem = target - nums[i];
			if (remainder.containsKey(nums[i])) {
				return new int[] { remainder.get(nums[i]), i };
			} else {
				remainder.put(rem, i);
			}
		}
		return new int[] {};
	}
}
