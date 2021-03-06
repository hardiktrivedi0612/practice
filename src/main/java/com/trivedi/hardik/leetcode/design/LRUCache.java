package com.trivedi.hardik.leetcode.design;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * @author hatrivedi
 * @date Nov 30, 2018
 * @since 2.5
 */
public class LRUCache {

	ConcurrentHashMap<Integer, DLinkedNode> cache = new ConcurrentHashMap<>();
	private DLinkedNode head, tail;
	int count;
	int capacity;

	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		this.head = new DLinkedNode();
		this.tail = new DLinkedNode();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		DLinkedNode node = cache.getOrDefault(key, null);
		if (node != null) {
			moveToHead(node);
		} else {
			return -1;
		}
		return node.value;
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.getOrDefault(key, null);
		if (node == null) {
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			addNode(newNode);
			cache.put(key, newNode);
			count++;
			if (count > capacity) {
				DLinkedNode tailNode = popTail();
				cache.remove(tailNode.key);
				count--;
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
	}

	// Add node after the head
	private void addNode(DLinkedNode node) {
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
	}

	// Remove a node
	private void removeNode(DLinkedNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void moveToHead(DLinkedNode node) {
		removeNode(node);
		addNode(node);
	}

	private DLinkedNode popTail() {
		DLinkedNode tailNode = tail.prev;
		removeNode(tailNode);
		return tailNode;
	}

	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev = null;
		DLinkedNode next = null;
	}
}
