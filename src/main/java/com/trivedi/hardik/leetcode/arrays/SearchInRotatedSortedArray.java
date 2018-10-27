package com.trivedi.hardik.leetcode.arrays;

/**
 * @author hatrivedi
 * @date Oct 27, 2018
 * @since 2.5
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		int floor = 0;
		int ceiling = nums.length - 1;
		while (floor <= ceiling) {
			int guess = floor + ((ceiling - floor) / 2);
			if (nums[guess] == target) {
				return guess;
			} else if (nums[floor] <= nums[guess]) {
				// Left array is sorted
				if (nums[floor] <= target && nums[guess] > target) {
					// Num is in the left sub array
					ceiling = guess - 1;
				} else {
					floor = guess + 1;
				}
			} else {
				// Right array is sorted
				if (target > nums[guess] && target <= nums[ceiling]) {
					// Num is in right sub array
					floor = guess + 1;
				} else {
					ceiling = guess - 1;
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray app = new SearchInRotatedSortedArray();
		System.out.println(app.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
	}
}
