package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class StackLargestElement {
// fill in the definitions for push(), pop(), and getMax()

	public static class MaxStack {

		Deque<Integer> stack = new ArrayDeque<>();
		Deque<Integer> maxElements = new ArrayDeque<>();

		public void push(int item) {
			stack.push(item);
			if (maxElements.isEmpty() || maxElements.peek() <= item) {
				maxElements.push(item);
			}
		}

		public int pop() {
			Integer item = stack.pop();
			if (item == maxElements.peek()) {
				maxElements.pop();
			}
			return item;
		}

		public int getMax() {
			return maxElements.peek();
		}
	}

	// tests

	@Test
	public void maxStackTest() {
		final MaxStack s = new MaxStack();
		s.push(5);
		assertEquals("check max after 1st push", 5, s.getMax());
		s.push(4);
		s.push(7);
		s.push(7);
		s.push(8);
		assertEquals("check before 1st pop", 8, s.getMax());
		assertEquals("check pop #1", 8, s.pop());
		assertEquals("check max after 1st pop", 7, s.getMax());
		assertEquals("check pop #2", 7, s.pop());
		assertEquals("check max after 2nd pop", 7, s.getMax());
		assertEquals("check pop #3", 7, s.pop());
		assertEquals("check max after 3rd pop", 5, s.getMax());
		assertEquals("check pop #4", 4, s.pop());
		assertEquals("check max after 4th pop", 5, s.getMax());
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(StackLargestElement.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
