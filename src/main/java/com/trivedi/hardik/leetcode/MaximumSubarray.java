package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Dec 3, 2018
 * @since 2.5
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		// Kanade's algorithm
		int maxSoFar = nums[0];
		int maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
}
