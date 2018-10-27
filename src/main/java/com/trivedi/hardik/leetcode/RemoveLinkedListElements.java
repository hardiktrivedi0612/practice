package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class RemoveLinkedListElements {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null) {
			return null;
		}
		ListNode prev = head;
		ListNode current = prev.next;
		while (prev.next != null) {
			if (current.val == val) {
				prev.next = current.next;
				current = current.next;
			} else {
				prev = current;
				current = current.next;
			}
		}
		return head;
	}

}
