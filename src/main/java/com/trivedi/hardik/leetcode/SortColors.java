package com.trivedi.hardik.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * @author hatrivedi
 * @date Oct 27, 2018
 * @since 2.5
 */
public class SortColors {

	// My Solution
	public void sortColors1(int[] nums) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			for (int j = 0; j < entry.getValue(); j++) {
				nums[i++] = entry.getKey();
			}
		}
	}

	// Optimized solution
	public void sortColors(int[] nums) {
		int index = 0;
		int zeroIndex = 0;
		int twoIndex = nums.length - 1;
		while (index <= twoIndex) {
			if (nums[index] == 0) {
				nums[index] = nums[zeroIndex];
				nums[zeroIndex] = 0;
				zeroIndex++;

			} else if (nums[index] == 2) {
				nums[index] = nums[twoIndex];
				nums[twoIndex] = 2;
				twoIndex--;

			} else {
				index++;
			}
			if (index < zeroIndex) {
				index = zeroIndex;
			}
		}
	}
}
