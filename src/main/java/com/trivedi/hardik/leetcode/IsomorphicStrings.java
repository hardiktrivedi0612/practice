package com.trivedi.hardik.leetcode;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		int[] pos1 = new int[256];
        int[] pos2 = new int[256];
        for (int i = s.length() - 1; i >= 0; --i) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (pos1[cs] != pos2[ct]) return false;
            pos1[cs] = pos2[ct] = i;
        }
        return true;
	}
}
