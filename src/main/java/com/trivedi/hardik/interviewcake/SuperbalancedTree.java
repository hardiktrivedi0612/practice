package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author hatrivedi
 * @date Jul 23, 2018
 * @since 2.5
 */
public class SuperbalancedTree {
	public static class BinaryTreeNode {

		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;

		public BinaryTreeNode(int value) {
			this.value = value;
		}

		public BinaryTreeNode insertLeft(int leftValue) {
			this.left = new BinaryTreeNode(leftValue);
			return this.left;
		}

		public BinaryTreeNode insertRight(int rightValue) {
			this.right = new BinaryTreeNode(rightValue);
			return this.right;
		}
	}

	// My Solution
	public static boolean isBalanced(BinaryTreeNode treeRoot) {
		if (treeRoot == null) {
			return true;
		}
		int[] depths = new int[2];
		int currentDepth = 0;

		return isBalancedUtil(treeRoot, depths, currentDepth);
	}

	public static boolean isBalancedUtil(BinaryTreeNode treeNode, int[] depths, int currentDepth) {

		if (treeNode.left == null && treeNode.right == null) {
			// Update the depths and return true
			if (depths[0] == 0 && depths[1] == 0) {
				depths[0] = currentDepth;
				depths[1] = currentDepth;
			} else if (currentDepth < depths[0]) {
				depths[0] = currentDepth;
			} else if (currentDepth > depths[1]) {
				depths[1] = currentDepth;
			}
			// This is a leaf node
			if (depths[1] - depths[0] > 1) {
				return false;
			} else {
				return true;
			}
		}

		if (treeNode.left != null && !isBalancedUtil(treeNode.left, depths, currentDepth + 1))
			return false;
		if (treeNode.right != null && !isBalancedUtil(treeNode.right, depths, currentDepth + 1))
			return false;
		return true;
	}

	// Their solution
	private static class NodeDepthPair {

		BinaryTreeNode node;
		int depth;

		NodeDepthPair(BinaryTreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public static boolean isBalancedInterviewCake(BinaryTreeNode treeRoot) {

		// a tree with no nodes is superbalanced, since there are no leaves!
		if (treeRoot == null) {
			return true;
		}

		// we short-circuit as soon as we find more than 2
		List<Integer> depths = new ArrayList<>(3);

		Deque<NodeDepthPair> nodes = new ArrayDeque<>();
		nodes.push(new NodeDepthPair(treeRoot, 0));

		while (!nodes.isEmpty()) {

			// pop a node and its depth from the top of our stack
			NodeDepthPair nodeDepthPair = nodes.pop();
			BinaryTreeNode node = nodeDepthPair.node;
			int depth = nodeDepthPair.depth;

			// case: we found a leaf
			if (node.left == null && node.right == null) {

				// we only care if it's a new depth
				if (!depths.contains(depth)) {
					depths.add(depth);

					// two ways we might now have an unbalanced tree:
					// 1) more than 2 different leaf depths
					// 2) 2 leaf depths that are more than 1 apart
					if (depths.size() > 2 || (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
						return false;
					}
				}

				// case: this isn't a leaf - keep stepping down
			} else {
				if (node.left != null) {
					nodes.push(new NodeDepthPair(node.left, depth + 1));
				}
				if (node.right != null) {
					nodes.push(new NodeDepthPair(node.right, depth + 1));
				}
			}
		}

		return true;
	}

	// tests

	@Test
	public void fullTreeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(5);
		final BinaryTreeNode a = root.insertLeft(8);
		final BinaryTreeNode b = root.insertRight(6);
		a.insertLeft(1);
		a.insertRight(2);
		b.insertLeft(3);
		b.insertRight(4);
		final boolean result = isBalanced(root);
		assertTrue(result);
	}

	@Test
	public void bothLeavesAtTheSameDepthTest() {
		final BinaryTreeNode root = new BinaryTreeNode(3);
		root.insertLeft(4).insertLeft(1);
		root.insertRight(2).insertRight(9);
		final boolean result = isBalanced(root);
		assertTrue(result);
	}

	@Test
	public void leafHeightsDifferByOneTest() {
		final BinaryTreeNode root = new BinaryTreeNode(6);
		root.insertLeft(1);
		root.insertRight(0).insertRight(7);
		final boolean result = isBalanced(root);
		assertTrue(result);
	}

	@Test
	public void leafHeightsDifferByTwoTest() {
		final BinaryTreeNode root = new BinaryTreeNode(6);
		root.insertLeft(1);
		root.insertRight(0).insertRight(7).insertRight(8);
		final boolean result = isBalanced(root);
		assertFalse(result);
	}

	@Test
	public void bothSubTreesSuperbalancedTest() {
		final BinaryTreeNode root = new BinaryTreeNode(1);
		root.insertLeft(5);
		final BinaryTreeNode b = root.insertRight(9);
		b.insertLeft(8).insertLeft(7);
		b.insertRight(5);
		final boolean result = isBalanced(root);
		assertFalse(result);
	}

	@Test
	public void onlyOneNodeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(1);
		final boolean result = isBalanced(root);
		assertTrue(result);
	}

	@Test
	public void treeIsLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(1);
		root.insertRight(2).insertRight(3).insertRight(4);
		final boolean result = isBalanced(root);
		assertTrue(result);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SuperbalancedTree.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
