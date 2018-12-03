package com.trivedi.hardik.leetcode;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * @author hatrivedi
 * @date Nov 13, 2018
 * @since 2.5
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int start = 0;
		int end = 0;
		int[] map = new int[256];
		int duplicateCounter = 0;
		int maxLength = 0;
		while (end < s.length()) {
			if (map[s.charAt(end++)]++ > 0) {
				duplicateCounter++;
			}
			while (duplicateCounter > 0) {
				if (map[s.charAt(start++)]-- > 1) {
					duplicateCounter--;
				}
			}
			maxLength = Math.max(maxLength, end - start);
		}
		return maxLength;
	}
}
