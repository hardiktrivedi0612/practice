package com.trivedi.hardik.leetcode;

import java.util.HashMap;

/**
 * Given the head of a graph, return a deep copy (clone) of the graph. Each node
 * in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of
 * its neighbors. There is an edge between the given node and each of the nodes
 * in its neighbors.
 * 
 * @author hatrivedi
 * @date Dec 6, 2018
 * @since 2.5
 */
public class CloneGraph {
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}

		UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
		map.put(node.label, clonedNode);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clonedNode.neighbors.add(cloneGraph(neighbor));
		}
		return clonedNode;
	}
}
