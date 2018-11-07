package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 7, 2018
 * @since 2.5
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}
}
