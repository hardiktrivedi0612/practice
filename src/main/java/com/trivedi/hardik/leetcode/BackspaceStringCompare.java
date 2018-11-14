package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 14, 2018
 * @since 2.5
 */
public class BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1;
		int j = T.length() - 1;
		while (true) {
			for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i)
				back += S.charAt(i) == '#' ? 1 : -1;
			for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j)
				back += T.charAt(j) == '#' ? 1 : -1;
			if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
				i--;
				j--;
			} else {
				return i == -1 && j == -1;
			}
		}
	}
}
