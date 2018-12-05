package com.trivedi.hardik.leetcode.design;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * @author hatrivedi
 * @date Dec 4, 2018
 * @since 2.5
 */
public class Trie {
	private TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!node.containsKey(c)) {
				node.put(c, new TrieNode());
			}
			node = node.get(c);
		}
		node.setEnd();
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}

	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.containsKey(c)) {
				node = node.get(c);
			} else {
				return null;
			}
		}
		return node;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}

	class TrieNode {
		private TrieNode[] links;
		private final int R = 26;
		private boolean isEnd;

		public TrieNode() {
			links = new TrieNode[R];
		}

		public boolean containsKey(char c) {
			return links[c - 'a'] != null;
		}

		public TrieNode get(char c) {
			return links[c - 'a'];
		}

		public void put(char c, TrieNode node) {
			links[c - 'a'] = node;
		}

		public void setEnd() {
			isEnd = true;
		}

		public boolean isEnd() {
			return isEnd;
		}
	}
}
