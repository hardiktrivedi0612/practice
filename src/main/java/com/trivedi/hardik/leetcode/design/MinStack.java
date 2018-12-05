package com.trivedi.hardik.leetcode.design;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * @author hatrivedi
 * @date Dec 4, 2018
 * @since 2.5
 */
public class MinStack {

	Stack<Integer> mainStack;
	Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		mainStack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		mainStack.push(x);
		if (minStack.isEmpty() || minStack.peek() >= x) {
			minStack.push(x);
		}
	}

	public void pop() {
		Integer poppedValue = mainStack.pop();
		if (poppedValue.equals(minStack.peek())) {
			minStack.pop();
		}
	}

	public int top() {
		return mainStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
