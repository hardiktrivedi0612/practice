package com.trivedi.hardik.leetcode;

/**
 * Design a HashMap without using any built-in hash table libraries.
 * 
 * To be specific, your design should include these functions:
 * 
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value
 * already exists in the HashMap, update the value. get(key): Returns the value
 * to which the specified key is mapped, or -1 if this map contains no mapping
 * for the key. remove(key) : Remove the mapping for the value key if this map
 * contains the mapping for the key.
 * 
 * @author hatrivedi
 * @date Dec 3, 2018
 * @since 2.5
 */
public class MyHashMap {

	private Entry[] entries;
	private int MAP_SIZE;

	/** Initialize your data structure here. */
	public MyHashMap() {
		this.entries = new Entry[1000000];
		this.MAP_SIZE = 1000000;
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int index = getKeyIndex(key);
		if (this.entries[index] == null) {
			this.entries[index] = new Entry(key, value);
		} else {
			Entry runner = this.entries[index];
			while (runner.next != null) {
				if (runner.key == key) {
					runner.val = value;
					return;
				}
				runner = runner.next;
			}
			if (runner.key == key) {
				runner.val = value;
				return;
			}
			runner.next = new Entry(key, value);
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int index = getKeyIndex(key);
		if (this.entries[index] == null) {
			return -1;
		}
		Entry runner = this.entries[index];
		while (runner != null) {
			if (runner.key == key) {
				return runner.val;
			}
			runner = runner.next;
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a
	 * mapping for the key
	 */
	public void remove(int key) {
		int index = getKeyIndex(key);
		if (this.entries[index] != null) {
			Entry prev = null;
			Entry runner = this.entries[index];
			while (runner != null) {
				if (runner.key == key) {
					if (prev == null) {
						this.entries[index] = runner.next;
					} else {
						prev.next = runner.next;
					}
				}
				prev = runner;
				runner = runner.next;
			}
		}
	}

	private int getKeyIndex(int key) {
		return Integer.hashCode(key) % this.MAP_SIZE;
	}

	class Entry {
		int key, val;
		Entry next;

		Entry(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
