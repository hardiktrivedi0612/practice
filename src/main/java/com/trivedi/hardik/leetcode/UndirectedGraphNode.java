package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hatrivedi
 * @date Dec 6, 2018
 * @since 2.5
 */
public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
