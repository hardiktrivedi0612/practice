package com.trivedi.hardik.general;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestOrSmallestElement {

	public static void main(String[] args) {

		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		int k = 3;

		// kth Smallest
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
		for (int i : inputArray) {
			if (maxHeap.size() < k) {
				maxHeap.add(i);
			} else if (maxHeap.peek().compareTo(i) >= 0) {
				maxHeap.poll();
				maxHeap.add(i);
			}
		}

		System.out.println("Kth smallest = " + maxHeap.peek());

		// Kth largest
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
		for (int i : inputArray) {
			if (minHeap.size() < k) {
				minHeap.add(i);
			} else if (minHeap.peek().compareTo(i) <= 0) {
				minHeap.poll();
				minHeap.add(i);
			}
		}

		System.out.println("Kth largest = " + minHeap.peek());

	}

}
