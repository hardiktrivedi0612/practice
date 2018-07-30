package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertSame;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class LinkedListKthToLastNode {
	public static class LinkedListNode {

		public int value;
		public LinkedListNode next;

		public LinkedListNode(int value) {
			this.value = value;
		}
	}

	public static LinkedListNode kthToLastNodeMySolution(int k, LinkedListNode head) {

		// return the kth to last node in the linked list
		if (head == null) {
			return null;
		}
		if (k < 0) {
			throw new IllegalArgumentException();
		}

		int count = 0;
		LinkedListNode backRunner = (k == 1) ? head : null;
		LinkedListNode frontRunner = head;
		while (frontRunner.next != null) {
			frontRunner = frontRunner.next;
			count++;
			if (count == k - 1) {
				backRunner = head;
			} else if (count > k - 1) {
				backRunner = backRunner.next;
			}
		}
		if (backRunner == null) {
			throw new IllegalArgumentException();
		}
		return backRunner;
	}

	/**
	 * First approach: use the length of the list.
	 * 
	 * walk down the whole list, counting nodes, to get the total listLength.
	 * subtract kkk from the listLength to get the distance from the head node to
	 * the target node (the kth to last node). walk that distance from the head to
	 * arrive at the target node.
	 * 
	 * @param k
	 * @param head
	 * @return
	 */
	public static LinkedListNode kthToLastNode1(int k, LinkedListNode head) {

		if (k < 1) {
			throw new IllegalArgumentException("Impossible to find less than first to last node: " + k);
		}

		// STEP 1: get the length of the list
		// start at 1, not 0
		// else we'd fail to count the head node!
		int listLength = 1;
		LinkedListNode currentNode = head;

		// traverse the whole list,
		// counting all the nodes
		while (currentNode.next != null) {
			currentNode = currentNode.next;
			listLength += 1;
		}

		// if k is greater than the length of the list, there can't
		// be a kth-to-last node, so we'll return an error!
		if (k > listLength) {
			throw new IllegalArgumentException("k is larger than the length of the linked list: " + k);
		}

		// STEP 2: walk to the target node
		// calculate how far to go, from the head,
		// to get to the kth to last node
		int howFarToGo = listLength - k;

		currentNode = head;
		for (int i = 0; i < howFarToGo; i++) {
			currentNode = currentNode.next;
		}

		return currentNode;
	}

	/**
	 * Second approach: maintain a kkk-wide "stick" in one walk down the list.
	 * 
	 * Walk one pointer kkk nodes from the head. Call it rightNode. Put another
	 * pointer at the head. Call it leftNode. Walk both pointers, at the same speed,
	 * towards the tail. This keeps a distance of kkk between them. When rightNode
	 * hits the tail, leftNode is on the target (since it's kkk nodes from the end
	 * of the list).
	 * 
	 * @param k
	 * @param head
	 * @return
	 */
	public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {

		if (k < 1) {
			throw new IllegalArgumentException("Impossible to find less than first to last node: " + k);
		}

		LinkedListNode leftNode = head;
		LinkedListNode rightNode = head;

		// move rightNode to the kth node
		for (int i = 0; i < k - 1; i++) {

			// but along the way, if a rightNode doesn't have a next,
			// then k is greater than the length of the list and there
			// can't be a kth-to-last node! we'll raise an error
			if (rightNode.next == null) {
				throw new IllegalArgumentException("k is larger than the length of the linked list: " + k);
			}

			rightNode = rightNode.next;
		}

		// starting with leftNode on the head,
		// move leftNode and rightNode down the list,
		// maintaining a distance of k between them,
		// until rightNode hits the end of the list
		while (rightNode.next != null) {
			leftNode = leftNode.next;
			rightNode = rightNode.next;
		}

		// since leftNode is k nodes behind rightNode,
		// leftNode is now the kth to last node!
		return leftNode;
	}

	// tests

	@Test
	public void firstToLastNodeTest() {
		final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final int k = 1;
		final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
		final LinkedListNode expected = listNodes[listNodes.length - k];
		assertSame(expected, actual);
	}

	@Test
	public void secondToLastNodeTest() {
		final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final int k = 2;
		final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
		final LinkedListNode expected = listNodes[listNodes.length - k];
		assertSame(expected, actual);
	}

	@Test
	public void firstNodeTest() {
		final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final int k = 4;
		final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
		final LinkedListNode expected = listNodes[listNodes.length - k];
		assertSame(expected, actual);
	}

	@Test(expected = Exception.class)
	public void kIsGreaterThanLinkedListLengthTest() {
		final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final int k = 5;
		kthToLastNode(k, listNodes[0]);
	}

	@Test(expected = Exception.class)
	public void kIsZeroTest() {
		final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final int k = 0;
		kthToLastNode(k, listNodes[0]);
	}

	private static LinkedListNode[] valuesToLinkedListNodes(int[] values) {
		final LinkedListNode[] nodes = new LinkedListNode[values.length];
		for (int i = 0; i < values.length; i++) {
			nodes[i] = new LinkedListNode(values[i]);
			if (i > 0) {
				nodes[i - 1].next = nodes[i];
			}
		}
		return nodes;
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(LinkedListKthToLastNode.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
