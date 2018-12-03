package com.trivedi.hardik.leetcode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author hatrivedi
 * @date Dec 3, 2018
 * @since 2.5
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode begin = dummy;
		int i = 0;
		while (head != null) {
			i++;
			if (i % k == 0) {
				begin = reverse(begin, head.next);
				head = begin.next;
			} else {
				head = head.next;
			}
		}

		return dummy.next;
	}

	public ListNode reverse(ListNode beg, ListNode end) {
		ListNode prev = beg;
		ListNode curr = beg.next;
		ListNode first = beg.next;
		ListNode next;
		while (curr != end) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		beg.next = prev;
		first.next = curr;

		return first;
	}
}
