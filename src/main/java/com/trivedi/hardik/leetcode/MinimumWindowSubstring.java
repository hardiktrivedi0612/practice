package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 13, 2018
 * @since 2.5
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int start = 0;
		int end = 0;
		int minWindowBegining = 0;
		int minLength = Integer.MAX_VALUE;
		int[] map = new int[256];
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		int counter = t.length();
		while (end < s.length()) {
			if (map[s.charAt(end++)]-- > 0) {
				counter--;
			}
			while (counter == 0) {
				if (end - start < minLength) {
					minWindowBegining = start;
					minLength = end - start;
				}
				if (map[s.charAt(start++)]++ == 0) {
					counter++;
				}
			}
		}
		return minLength == Integer.MAX_VALUE ? "" : s.substring(minWindowBegining, minWindowBegining + minLength);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring app = new MinimumWindowSubstring();
		System.out.println(app.minWindow("ADOBECODEBANC", "ABC"));
	}
}
