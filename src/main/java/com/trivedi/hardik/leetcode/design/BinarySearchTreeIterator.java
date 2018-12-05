package com.trivedi.hardik.leetcode.design;

import java.util.Stack;

import com.trivedi.hardik.leetcode.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author hatrivedi
 * @date Dec 4, 2018
 * @since 2.5
 */
public class BinarySearchTreeIterator {

	Stack<TreeNode> stack;

	public BinarySearchTreeIterator(TreeNode root) {
		stack = new Stack<>();
		TreeNode current = root;
		while (current != null) {
			stack.push(current);
			current = current.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		TreeNode newNode = node.right;
		while (newNode != null) {
			stack.push(newNode);
			newNode = newNode.left;
		}
		return node.val;
	}
}
