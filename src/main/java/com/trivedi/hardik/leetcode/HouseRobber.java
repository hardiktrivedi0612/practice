package com.trivedi.hardik.leetcode;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author hatrivedi
 * @date Dec 3, 2018
 * @since 2.5
 */
public class HouseRobber {
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int rob[] = new int[nums.length];
		Arrays.fill(rob, -1);
		rob[0] = nums[0];
		rob[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			rob[i] = Math.max(nums[i] + rob[i - 2], rob[i - 1]);
		}
		return rob[nums.length - 1];
	}

	// Another solution that is used in later questions
	public int rob1(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int prevMax = 0;
		int currMax = 0;
		for (int num : nums) {
			int temp = currMax;
			currMax = Math.max(prevMax + num, currMax);
			prevMax = temp;
		}
		return currMax;
	}

}
