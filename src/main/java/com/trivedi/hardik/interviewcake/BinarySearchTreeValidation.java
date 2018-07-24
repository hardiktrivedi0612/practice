package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Write a method to check that a binary tree ↴ is a valid binary search tree. ↴
 *
 */
public class BinarySearchTreeValidation {

	public static BinaryTreeNode inOrderPrevious;

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

	public static boolean isBinarySearchTreeInterviewCake(BinaryTreeNode root) {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBinarySearchTree(BinaryTreeNode root, int lowerBound, int upperBound) {
		if (root == null) {
			return true;
		}

		if (root.value >= upperBound || root.value <= lowerBound) {
			return false;
		}

		return isBinarySearchTree(root.left, lowerBound, root.value)
				&& isBinarySearchTree(root.right, root.value, upperBound);
	}

	public static boolean isBinarySearchTree(BinaryTreeNode root) {
		// determine if the tree is a valid binary search tree
		if (root == null) {
			return true;
		}

		inOrderPrevious = null;
		return traverseTreeInOrder(root);

	}

	static boolean traverseTreeInOrder(BinaryTreeNode node) {
		if (node.left != null && !traverseTreeInOrder(node.left))
			return false;
		if (inOrderPrevious != null && node.value < inOrderPrevious.value) {
			return false;
		}
		inOrderPrevious = node;
		if (node.right != null && !traverseTreeInOrder(node.right))
			return false;
		return true;
	}

	// tests

	@Test
	public void validFullTreeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		final BinaryTreeNode b = root.insertRight(70);
		b.insertLeft(60);
		b.insertRight(80);
		final boolean result = isBinarySearchTree(root);
		assertTrue(result);
	}

	@Test
	public void bothSubtreesValidTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(20);
		a.insertRight(60);
		final BinaryTreeNode b = root.insertRight(80);
		b.insertLeft(70);
		b.insertRight(90);
		final boolean result = isBinarySearchTree(root);
		assertFalse(result);
	}

	@Test
	public void descendingLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		root.insertLeft(40).insertLeft(30).insertLeft(20).insertLeft(10);
		final boolean result = isBinarySearchTree(root);
		assertTrue(result);
	}

	@Test
	public void outOfOrderLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		root.insertRight(70).insertRight(60).insertRight(80);
		final boolean result = isBinarySearchTree(root);
		assertFalse(result);
	}

	@Test
	public void oneNodeTreeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final boolean result = isBinarySearchTree(root);
		assertTrue(result);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(BinarySearchTreeValidation.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}

}
