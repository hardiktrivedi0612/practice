package com.trivedi.hardik.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/**
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
