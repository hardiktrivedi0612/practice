package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class LinkedListDeleteNode {
	public static class LinkedListNode {

		public int value;
		public LinkedListNode next;

		public LinkedListNode(int value) {
			this.value = value;
		}
	}

	/*
	 * But be careful—there are some potential problems with this implementation:
	 * 
	 * First, it doesn't work for deleting the last node in the list. We could
	 * change the node we're deleting to have a value of null, but the
	 * second-to-last node's next pointer would still point to a node, even though
	 * it should be null. This could work—we could treat this last, "deleted" node
	 * with value null as a "dead node" or a "sentinel node," and adjust any node
	 * traversing code to stop traversing when it hits such a node. The trade-off
	 * there is we couldn't have non-dead nodes with values set to null. Instead we
	 * chose to throw an exception in this case.
	 * 
	 * There are two potential side-effects:
	 * 
	 * Any references to the input node have now effectively been reassigned to its
	 * next node. In our example, we "deleted" the node assigned to the variable b,
	 * but in actuality we just gave it a new value (2) and a new next! If we had
	 * another pointer to b somewhere else in our code and we were assuming it still
	 * had its old value (8), that could cause bugs.
	 * 
	 * If there are pointers to the input node's original next node, those pointers
	 * now point to a "dangling" node (a node that's no longer reachable by walking
	 * down our list). In our example above, c is now dangling. If we changed c,
	 * we'd never encounter that new value by walking down our list from the head to
	 * the tail.
	 * 
	 */
	public static void deleteNode(LinkedListNode nodeToDelete) {

		// delete the input node from the linked list
		if (nodeToDelete == null) {
			throw new IllegalArgumentException();
		}

		// get the input node's next node, the one we want to skip to
		LinkedListNode nextNode = nodeToDelete.next;

		if (nextNode != null) {

			// replace the input node's value and pointer with the next
			// node's value and pointer. the previous node now effectively
			// skips over the input node
			nodeToDelete.value = nextNode.value;
			nodeToDelete.next = nextNode.next;

		} else {

			// eep, we're trying to delete the last node!
			throw new IllegalArgumentException("Can't delete the last node with this technique!");
		}
	}

	// tests

	@Test
	public void nodeAtBeginningTest() {
		LinkedListNode head = new LinkedListNode(1);
		appendToList(head, 2);
		appendToList(head, 3);
		appendToList(head, 4);

		deleteNode(head);

		LinkedListNode node = head;
		assertEquals(2, node.value);

		node = node.next;
		assertEquals(3, node.value);

		node = node.next;
		assertEquals(4, node.value);

		assertNull(node.next);
	}

	@Test
	public void nodeInTheMiddleTest() {
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode nodeToDelete = appendToList(head, 2);
		appendToList(head, 3);
		appendToList(head, 4);

		deleteNode(nodeToDelete);

		LinkedListNode node = head;
		assertEquals(1, node.value);

		node = node.next;
		assertEquals(3, node.value);

		node = node.next;
		assertEquals(4, node.value);

		assertNull(node.next);
	}

	@Test(expected = Exception.class)
	public void nodeAtTheEndTest() {
		LinkedListNode head = new LinkedListNode(1);
		appendToList(head, 2);
		appendToList(head, 3);
		LinkedListNode nodeToDelete = appendToList(head, 4);

		deleteNode(nodeToDelete);
	}

	@Test(expected = Exception.class)
	public void oneNodeListTest() {
		LinkedListNode head = new LinkedListNode(1);
		deleteNode(head);
	}

	private static LinkedListNode appendToList(final LinkedListNode head, int value) {
		LinkedListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new LinkedListNode(value);
		return current.next;
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(LinkedListDeleteNode.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
