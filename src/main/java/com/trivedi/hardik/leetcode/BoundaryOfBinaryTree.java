package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return the values of its boundary in anti-clockwise
 * direction starting from root. Boundary includes left boundary, leaves, and
 * right boundary in order without duplicate nodes.
 * 
 * Left boundary is defined as the path from root to the left-most node. Right
 * boundary is defined as the path from root to the right-most node. If the root
 * doesn't have left subtree or right subtree, then the root itself is left
 * boundary or right boundary. Note this definition only applies to the input
 * binary tree, and not applies to any subtrees.
 * 
 * The left-most node is defined as a leaf node you could reach when you always
 * firstly travel to the left subtree if exists. If not, travel to the right
 * subtree. Repeat until you reach a leaf node.
 * 
 * The right-most node is also defined by the same way with left and right
 * exchanged.
 * 
 * @author hatrivedi
 * @date Dec 10, 2018
 * @since 2.5
 */
public class BoundaryOfBinaryTree {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<Integer> response = new ArrayList<>();
		response.add(root.val);
		leftBoundary(root.left, response);
		leafNodes(root.left, response);
		leafNodes(root.right, response);
		rightBoundary(root.right, response);
		return response;
	}

	private void leftBoundary(TreeNode root, List<Integer> response) {
		if (root == null || root.left == null && root.right == null) {
			return;
		}
		response.add(root.val);
		if (root.left != null) {
			leftBoundary(root.left, response);
		} else if (root.right != null) {
			leftBoundary(root.right, response);
		}
	}

	private void leafNodes(TreeNode root, List<Integer> response) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			response.add(root.val);
		}
		leafNodes(root.left, response);
		leafNodes(root.right, response);
	}

	private void rightBoundary(TreeNode root, List<Integer> response) {
		if (root == null || root.left == null && root.right == null) {
			return;
		}
		if (root.right != null) {
			rightBoundary(root.right, response);
		} else if (root.left != null) {
			rightBoundary(root.left, response);
		}
		response.add(root.val);
	}
}
