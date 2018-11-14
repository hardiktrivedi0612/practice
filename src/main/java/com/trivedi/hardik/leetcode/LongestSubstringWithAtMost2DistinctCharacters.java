package com.trivedi.hardik.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hatrivedi
 * @date Nov 13, 2018
 * @since 2.5
 */
public class LongestSubstringWithAtMost2DistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> characterCount = new HashMap<>();
		int start = 0;
		int end = 0;
		int maxLength = 0;
		int distinctCount = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
			end++;
			if (characterCount.get(c) == 1) {
				distinctCount++;
			}
			while (distinctCount > 2) {
				// Do as soon as we find more than 2 distinct characters
				char temp = s.charAt(start);
				characterCount.put(temp, characterCount.get(temp) - 1);
				if (characterCount.get(temp) == 0) {
					distinctCount--;
				}
				start++;
			}
			maxLength = Math.max(maxLength, end - start);
		}
		return maxLength;
	}

	// Better solution
	public int lengthOfLongestSubstringTwoDistinctWithCharArray(String s) {
		int distinctCount = 0;
		int start = 0;
		int end = 0;
		int maxLength = 0;
		int[] map = new int[256];
		while (end < s.length()) {
			if (map[s.charAt(end++)]++ == 0) {
				distinctCount++;
			}

			while (distinctCount > 2) {
				if (map[s.charAt(start++)]-- == 1) {
					distinctCount--;
				}
			}
			maxLength = Math.max(maxLength, end - start);
		}
		return maxLength;
	}
}
