package com.trivedi.hardik.leetcode;

/**
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * @author hatrivedi
 * @date Dec 11, 2018
 * @since 2.5
 */
public class MaximumProductSubarray {

	// Geeks for geeks solution that does not pass all cases
	public int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int maxTillHere = 1;
		int minTillHere = 1;
		int maxSoFar = 1;
		for (int num : nums) {
			if (num > 0) {
				// Keep increasing maxTillHere since num is positive
				maxTillHere *= num;
				// Written in case minTillHere is positive and it keeps
				// increasing
				minTillHere = Math.min(minTillHere * num, 1);
			} else if (num == 0) {
				// Reset the values
				maxTillHere = 1;
				minTillHere = 1;
			} else {
				// Max will become min swap multiplication with negative value
				int temp = maxTillHere;
				maxTillHere = Math.max(minTillHere * num, 1);
				minTillHere = temp * num;
			}
			maxSoFar = Math.max(maxSoFar, maxTillHere);
		}
		return maxSoFar;
	}

	// Proper solution
	public int maxProductProper(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0], min = nums[0], result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
			if (max > result) {
				result = max;
			}
		}
		return result;
	}
}
