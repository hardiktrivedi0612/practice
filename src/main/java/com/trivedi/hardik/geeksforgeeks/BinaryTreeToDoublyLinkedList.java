package com.trivedi.hardik.geeksforgeeks;

import com.trivedi.hardik.leetcode.TreeNode;

/**
 * @author hatrivedi
 * @date Dec 4, 2018
 * @since 2.5
 */
public class BinaryTreeToDoublyLinkedList {

	private TreeNode prev;

	public TreeNode convert(TreeNode root) {
		if (root == null) {
			return null;
		}
		prev = null;
		convertUtil(root);
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public void convertUtil(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;

		convertUtil(left);
		if (prev != null) {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		convertUtil(right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(12);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(25);
		root.left.right = new TreeNode(30);
		root.right.left = new TreeNode(36);

		BinaryTreeToDoublyLinkedList app = new BinaryTreeToDoublyLinkedList();
		TreeNode newRoot = app.convert(root);
		app.printTree(newRoot);
	}

	private void printTree(TreeNode root) {
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.right;
		}
	}

}
