package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 6, 2018
 * @since 2.5
 */
public class SortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBSTRecursive(nums, 0, nums.length - 1);
	}

	public TreeNode sortedArrayToBSTRecursive(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBSTRecursive(nums, start, mid - 1);
		root.right = sortedArrayToBSTRecursive(nums, mid + 1, end);
		return root;
	}
}
