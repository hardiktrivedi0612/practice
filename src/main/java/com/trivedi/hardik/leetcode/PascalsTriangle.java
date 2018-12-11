package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * @author hatrivedi
 * @date Dec 11, 2018
 * @since 2.5
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		if (numRows == 0) {
			return Collections.emptyList();
		}

		List<List<Integer>> response = new ArrayList<>();

		response.add(new ArrayList<Integer>());
		response.get(0).add(1);

		for (int i = 1; i < numRows; i++) {
			List<Integer> currentList = new ArrayList<>();
			List<Integer> prevList = response.get(i - 1);

			currentList.add(1);

			for (int j = 1; j < prevList.size(); j++) {
				currentList.add(prevList.get(j) + prevList.get(j - 1));
			}

			currentList.add(1);

			response.add(currentList);
		}

		return response;
	}
}
