package com.trivedi.hardik.leetcode;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * @author hatrivedi
 * @date Dec 3, 2018
 * @since 2.5
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		int[] pos1 = new int[256];
		int[] pos2 = new int[256];
		
		//Not necessary to go in reverse order
		for (int i = s.length() - 1; i >= 0; --i) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			if (pos1[cs] != pos2[ct])
				return false;
			pos1[cs] = pos2[ct] = i;
		}
		return true;
	}
}
