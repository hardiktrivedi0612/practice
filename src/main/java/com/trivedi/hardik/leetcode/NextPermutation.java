package com.trivedi.hardik.leetcode;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2 | 3,2,1 → 1,2,3 | 1,1,5 → 1,5,1
 * 
 * @author hatrivedi
 * @date Dec 11, 2018
 * @since 2.5
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {

		// If the input is all nums in decreasing order, then there can be no
		// combinations

		// So start from the left till you stop at a decreasing order

		// Traverse from right and then stop at i where a[i] < a[i+1]
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}

		// If everything was not decreasing order
		if (i >= 0) {
			int j = nums.length - 1;
			// Finding a number just greater than a[i] after i
			while (j >= i && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}

		reverse(nums, i + 1);
	}

	private void reverse(int[] nums, int i) {
		int j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
