package com.trivedi.hardik.leetcode;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class FirstUniqueCharacterInAString {

	public int firstUniqChar(String s) {
		int[] frequencies = new int[26];
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			frequencies[chars[i] - 'a']++;
		}
		for (int i = 0; i < chars.length; i++) {
			if (frequencies[chars[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}
