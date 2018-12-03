package com.trivedi.hardik.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class KthLargestElementInAnArray {

	// Solution with heap
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> kLargest = new PriorityQueue<>(k);
		for (int num : nums) {
			if (kLargest.size() < k) {
				kLargest.add(num);
			} else if (kLargest.peek().compareTo(num) <= 0) {
				kLargest.poll();
				kLargest.add(num);
			}
		}
		return kLargest.peek();
	}

	// Solution with sorting
	public int findKthLargest2(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
