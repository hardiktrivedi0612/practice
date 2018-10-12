package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Write a method to find the 2nd largest element in a binary search tree. ↴
 *
 */
public class BinarySearchTree2ndLargest {

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

	public static int findSecondLargest(BinaryTreeNode rootNode) {
		BinaryTreeNode current = rootNode;
		while (true) {
			// case: current is largest and has a left subtree
			// 2nd largest is the largest in that subtree
			if (current.left != null && current.right == null) {
				return findLargest(current.left);
			}

			// case: current is parent of largest, and largest has no children,
			// so current is 2nd largest
			if (current.right != null && current.right.left == null && current.right.right == null) {
				return current.value;
			}

			current = current.right;
		}
	}

	private static int findLargest(BinaryTreeNode rootNode) {
		BinaryTreeNode largest = null;
		BinaryTreeNode current = rootNode;

		while (current != null) {
			if (current.right == null) {
				largest = current;
			}
			current = current.right;
		}
		return largest.value;
	}

	// tests

	@Test
	public void findSecondLargestTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		final BinaryTreeNode b = root.insertRight(70);
		b.insertLeft(60);
		b.insertRight(80);
		final int actual = findSecondLargest(root);
		final int expected = 70;
		assertEquals(expected, actual);
	}

	@Test
	public void largestHasLeftChildTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		root.insertRight(70).insertLeft(60);
		final int actual = findSecondLargest(root);
		final int expected = 60;
		assertEquals(expected, actual);
	}

	@Test
	public void largestHasLeftSubtreeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		final BinaryTreeNode b = root.insertRight(70).insertLeft(60);
		b.insertLeft(55).insertRight(58);
		b.insertRight(65);
		final int actual = findSecondLargest(root);
		final int expected = 65;
		assertEquals(expected, actual);
	}

	@Test
	public void secondLargestIsRootNodeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		root.insertRight(70);
		final int actual = findSecondLargest(root);
		final int expected = 50;
		assertEquals(expected, actual);
	}

	@Test
	public void descendingLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		root.insertLeft(40).insertLeft(30).insertLeft(20);
		final int actual = findSecondLargest(root);
		final int expected = 40;
		assertEquals(expected, actual);
	}

	@Test
	public void ascendingLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		root.insertRight(60).insertRight(70).insertRight(80);
		final int actual = findSecondLargest(root);
		final int expected = 70;
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void exceptionWithTreeThatHasOneNodeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		findSecondLargest(root);
	}

	@Test(expected = Exception.class)
	public void exceptionWithEmptyTreeTest() {
		findSecondLargest(null);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(BinarySearchTree2ndLargest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}

}
