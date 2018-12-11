package com.trivedi.hardik.leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * 
 * @author hatrivedi
 * @date Dec 11, 2018
 * @since 2.5
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[nums.length - 1];
		for (int i = 0; i < nums.length - 2; i++) {
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum < target) {
					l++;
				} else {
					r--;
				}
				if (Math.abs(target - sum) < Math.abs(target - result)) {
					result = sum;
				}
			}
		}
		return result;
	}
}
