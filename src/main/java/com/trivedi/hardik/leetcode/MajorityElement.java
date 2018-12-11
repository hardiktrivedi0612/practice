package com.trivedi.hardik.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * @author hatrivedi
 * @date Dec 10, 2018
 * @since 2.5
 */
public class MajorityElement {
	// Naive solution
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > Math.floor(nums.length / 2)) {
				return entry.getKey();
			}
		}
		return -1;
	}

	// Optimized solution
	// Boyer-Moore Voting Algorithm
	public int majorityElementBMVA(int[] nums) {
		int count = 0;
		Integer candidate = null;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}
		return candidate;
	}
}
