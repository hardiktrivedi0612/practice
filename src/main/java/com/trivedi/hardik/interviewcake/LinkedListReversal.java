package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class LinkedListReversal {
	public static class LinkedListNode {

		public int value;
		public LinkedListNode next;

		public LinkedListNode(int value) {
			this.value = value;
		}
	}

	public static LinkedListNode reverse(LinkedListNode headOfList) {

		// reverse the linked list in place
		if (headOfList == null) {
			return null;
		}

		LinkedListNode prev = null;
		LinkedListNode current = headOfList;
		LinkedListNode next = headOfList.next;

		while (next != null) {
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;
		}

		return current;
	}

	public static LinkedListNode reverse1(LinkedListNode headOfList) {
		// reverse the linked list in place
		if (headOfList == null) {
			return null;
		}
		LinkedListNode prev = null;
		LinkedListNode curr = headOfList;
		while (headOfList != null) {
			LinkedListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	// tests

	@Test
	public void shortLinkedListTest() {
		final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] { 1, 2 });
		final LinkedListNode result = reverse(nodes[0]);
		assertTrue(isListReversed(result, nodes));
	}

	@Test
	public void longLinkedListTest() {
		final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4, 5, 6 });
		final LinkedListNode result = reverse(nodes[0]);
		assertTrue(isListReversed(result, nodes));
	}

	@Test
	public void oneElementLinkedListTest() {
		final LinkedListNode node = new LinkedListNode(1);
		final LinkedListNode result = reverse(node);
		assertSame(node, result);
	}

	@Test
	public void emptyLinkedListTest() {
		final LinkedListNode result = reverse(null);
		assertNull(result);
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

	private static boolean isListReversed(LinkedListNode list, LinkedListNode[] originalNodes) {
		int i = originalNodes.length - 1;
		while (list != null && i >= 0) {
			if (originalNodes[i] != list) {
				return false;
			}
			list = list.next;
			i--;
		}
		return list == null;
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(LinkedListReversal.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
