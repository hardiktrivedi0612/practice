package com.trivedi.hardik.leetcode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * 
 * @author hatrivedi
 * @date Dec 6, 2018
 * @since 2.5
 */
public class ConvertSortedListToBinarySearchTree {

	// My Solution
	public TreeNode sortedListToBSTMySol(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode prev = null;
		ListNode slowRunner = head;
		ListNode fastRunner = head;
		while (fastRunner != null && fastRunner.next != null) {
			prev = slowRunner;
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}

		// SlowRunner is the middle

		TreeNode root = new TreeNode(slowRunner.val);
		if (prev != null) {
			prev.next = null;
		}
		if (head == slowRunner) {
			return root;
		}
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slowRunner.next);
		return root;
	}

	// Optimal solution
	private ListNode node;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		int size = 0;
		ListNode runner = head;
		node = head;

		while (runner != null) {
			runner = runner.next;
			size++;
		}

		return inorderHelper(0, size - 1);
	}

	public TreeNode inorderHelper(int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode left = inorderHelper(start, mid - 1);

		TreeNode treenode = new TreeNode(node.val);
		treenode.left = left;
		node = node.next;

		TreeNode right = inorderHelper(mid + 1, end);
		treenode.right = right;

		return treenode;
	}
}
