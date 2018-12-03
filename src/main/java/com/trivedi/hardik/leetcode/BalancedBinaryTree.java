package com.trivedi.hardik.leetcode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * a binary tree in which the depth of the two subtrees of every node never
 * differ by more than 1.
 * 
 * 
 * @author hatrivedi
 * @date Oct 26, 2018
 * @since 2.5
 */
public class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// O(n2) solution
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		int leftHeight = depth(root.left);
		int rightHeight = depth(root.right);

		return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);

	}

	int depth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}

	// DFS approach O(n)
	public boolean isBalancedDFS(TreeNode root) {
		return dfsDepth(root) != -1;
	}

	int dfsDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = dfsDepth(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = dfsDepth(root.right);
		if (rightHeight == -1)
			return -1;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
