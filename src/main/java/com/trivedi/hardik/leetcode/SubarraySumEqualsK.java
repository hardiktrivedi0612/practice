package com.trivedi.hardik.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * @author hatrivedi
 * @date Dec 3, 2018
 * @since 2.5
 */
public class SubarraySumEqualsK {
	// Brute force
	public int subarraySumBruteForce(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			for (int end = start + 1; end <= nums.length; end++) {
				int sum = 0;
				for (int i = start; i < end; i++) {
					sum += nums[i];
				}
				if (sum == k) {
					count++;
				}
			}
		}
		return count;
	}

	// Optimized approach
	public int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}
}
