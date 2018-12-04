package com.trivedi.hardik.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word.
 * 
 * @author hatrivedi
 * @date Dec 3, 2018
 * @since 2.5
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<WordItem> queue = new LinkedList<>();
		queue.add(new WordItem(beginWord, 1));
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		while (!queue.isEmpty()) {
			WordItem wordItem = queue.poll();
			for (String word : wordList) {
				if (!visited.contains(word) && checkNumberOfLettersDifferent(wordItem.word, word) == 1) {
					WordItem newItem = new WordItem(word, wordItem.level + 1);
					queue.add(newItem);
					visited.add(word);
					if (word.equals(endWord)) {
						return wordItem.level + 1;
					}
				}
			}
		}
		return 0;
	}

	private int checkNumberOfLettersDifferent(String sourceWord, String destinationWord) {
		int count = 0;
		for (int i = 0; i < sourceWord.length(); i++) {
			if (sourceWord.charAt(i) != destinationWord.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	class WordItem {
		String word;
		int level;

		WordItem(String word, int level) {
			this.word = word;
			this.level = level;
		}
	}
}
