package com.trivedi.hardik.leetcode;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * 
 * @author hatrivedi
 * @date Nov 30, 2018
 * @since 2.5
 */
public class AddTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> l1Stack = new Stack<>();
		Stack<Integer> l2Stack = new Stack<>();
		while (l1 != null) {
			l1Stack.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			l2Stack.push(l2.val);
			l2 = l2.next;
		}
		Stack<Integer> answerStack = new Stack<>();
		int carry = 0;
		while (!l1Stack.isEmpty() && !l2Stack.isEmpty()) {
			Integer l1Val = l1Stack.pop();
			Integer l2Val = l2Stack.pop();
			int answerNewVal = l1Val + l2Val + carry;
			answerStack.push(answerNewVal % 10);
			carry = answerNewVal / 10;
		}

		while (!l1Stack.isEmpty()) {
			Integer l1Val = l1Stack.pop();
			int answerNewVal = l1Val + carry;
			answerStack.push(answerNewVal % 10);
			carry = answerNewVal / 10;
		}

		while (!l2Stack.isEmpty()) {
			Integer l2Val = l2Stack.pop();
			int answerNewVal = l2Val + carry;
			answerStack.push(answerNewVal % 10);
			carry = answerNewVal / 10;
		}

		if (carry > 0) {
			answerStack.push(carry);
		}

		ListNode head = null;
		ListNode current = null;
		while (!answerStack.isEmpty()) {
			Integer val = answerStack.pop();
			ListNode newNode = new ListNode(val);
			if (head == null) {
				head = newNode;
				current = newNode;
			} else {
				current.next = newNode;
				current = newNode;
			}
		}
		return head;
	}

}
