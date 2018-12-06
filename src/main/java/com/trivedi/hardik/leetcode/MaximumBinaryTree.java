package com.trivedi.hardik.leetcode;

/**
 * Given an integer array with no duplicates. A maximum tree building on this
 * array is defined as follow:
 * 
 * The root is the maximum number in the array. The left subtree is the maximum
 * tree constructed from left part subarray divided by the maximum number. The
 * right subtree is the maximum tree constructed from right part subarray
 * divided by the maximum number. Construct the maximum tree by the given array
 * and output the root node of this tree.
 * 
 * @author hatrivedi
 * @date Dec 5, 2018
 * @since 2.5
 */
public class MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTreeUtil(nums, 0, nums.length - 1);
	}

	public TreeNode constructMaximumBinaryTreeUtil(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		} else if (left == right) {
			return new TreeNode(nums[left]);
		}
		int maxIndex = left;
		for (int i = left; i <= right; i++) {
			if (nums[i] > nums[maxIndex]) {
				maxIndex = i;
			}
		}
		TreeNode root = new TreeNode(nums[maxIndex]);
		root.left = constructMaximumBinaryTreeUtil(nums, left, maxIndex - 1);
		root.right = constructMaximumBinaryTreeUtil(nums, maxIndex + 1, right);
		return root;
	}
}
