package com.trivedi.hardik.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 
 * To some string S, we will perform some replacement operations that replace
 * groups of letters with new ones (not necessarily the same size).
 * 
 * Each replacement operation has 3 parameters: a starting index i, a source
 * word x and a target word y. The rule is that if x starts at position i in the
 * original string S, then we will replace that occurrence of x with y. If not,
 * we do nothing.
 * 
 * For example, if we have S = "abcd" and we have some replacement operation i =
 * 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the
 * original string S, we will replace it with "ffff".
 * 
 * Using another example on S = "abcd", if we have both the replacement
 * operation i = 0, x = "ab", y = "eee", as well as another replacement
 * operation i = 2, x = "ec", y = "ffff", this second operation does nothing
 * because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 * 
 * All these operations occur simultaneously. It's guaranteed that there won't
 * be any overlap in replacement: for example, S = "abc", indexes = [0, 1],
 * sources = ["ab","bc"] is not a valid test case.
 * 
 * @author hatrivedi
 * @date Nov 12, 2018
 * @since 2.5
 */
public class FindAndReplaceInString {

	// My Solution
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		TreeMap<Integer, Integer> indexTreeMap = new TreeMap<>();
		int temp = 0;
		for (int i : indexes) {
			indexTreeMap.put(i, temp++);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (indexTreeMap.containsKey(i)) {
				// We have to replace at this location
				int index = indexTreeMap.get(i);
				int endIndex = i + sources[index].length();
				String subString = S.substring(i, (endIndex > S.length()) ? S.length() : endIndex);
				if (subString.equals(sources[index])) {
					sb.append(targets[index]);
					i += sources[index].length() - 1;
				} else {
					sb.append(S.charAt(i));
				}
			} else {
				sb.append(S.charAt(i));
			}
		}
		return sb.toString();
	}

	// More optimized solution
	public String findReplaceString2(String S, int[] indexes, String[] sources, String[] targets) {
		int[] match = new int[S.length()];
		Arrays.fill(match, -1);
		for (int i = 0; i < indexes.length; i++) {
			int idx = indexes[i];
			if (S.substring(idx, (idx + sources[i].length())).equals(sources[i])) {
				match[idx] = i;
			}
		}

		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while (idx < S.length()) {
			if (match[idx] != -1) {
				sb.append(targets[match[idx]]);
				idx += sources[match[idx]].length();
			} else {
				sb.append(S.charAt(idx++));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		FindAndReplaceInString app = new FindAndReplaceInString();
		System.out.println(app.findReplaceString("abcd", new int[] { 2, 0 }, new String[] { "ec", "ab" },
				new String[] { "ffff", "eee" }));
	}
}
