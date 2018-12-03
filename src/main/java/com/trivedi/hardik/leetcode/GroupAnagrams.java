package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 * 
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String string : strs) {
			char[] chars = string.toCharArray();
			Arrays.sort(chars);
			String sortedString = String.valueOf(chars);
			if (map.containsKey(sortedString)) {
				map.get(sortedString).add(string);
			} else {
				ArrayList<String> values = new ArrayList<>();
				values.add(string);
				map.put(sortedString, values);
			}
		}

		return new ArrayList<List<String>>(map.values());
	}
}
