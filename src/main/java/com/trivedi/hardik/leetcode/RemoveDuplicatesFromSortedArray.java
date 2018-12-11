package com.trivedi.hardik.leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * @author hatrivedi
 * @date Dec 11, 2018
 * @since 2.5
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int difference = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[difference]) {
				difference++;
				nums[difference] = nums[i];
			}
		}
		return difference + 1;
	}
}
