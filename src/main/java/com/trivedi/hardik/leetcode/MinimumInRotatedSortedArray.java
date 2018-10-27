package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class MinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		int floor = 0;
		int ceiling = nums.length - 1;
		while (floor < ceiling) {
			int guessIndex = floor + (ceiling - floor) / 2;
			if (nums[guessIndex] >= nums[0]) {
				floor = guessIndex;
			} else {
				ceiling = guessIndex;
			}
			if (floor + 1 == ceiling) {
				break;
			}
		}

		if (nums[ceiling] >= nums[0]) {
			return nums[0];
		}

		return nums[ceiling];

	}

}
