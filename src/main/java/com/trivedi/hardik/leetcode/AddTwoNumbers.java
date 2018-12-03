package com.trivedi.hardik.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * @author hatrivedi
 * @date Dec 3, 2018
 * @since 2.5
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(-1);
		ListNode head = dummyHead;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int val = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + carry;
			ListNode newNode = new ListNode(val % 10);
			head.next = newNode;
			head = newNode;
			carry = val / 10;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry > 0) {
			ListNode newNode = new ListNode(carry);
			head.next = newNode;
		}
		return dummyHead.next;
	}
}
