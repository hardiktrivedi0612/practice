package com.trivedi.hardik.interviewcake;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class TopologicalSorting {

	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List

	// Constructor
	TopologicalSorting(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void topologicalSort() {
		Deque<Integer> stack = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	void topologicalSortUtil(int node, boolean[] visited, Deque<Integer> stack) {
		visited[node] = true;
		Iterator<Integer> iter = adj[node].iterator();
		while (iter.hasNext()) {
			int i = iter.next();
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		stack.push(node);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a graph given in the above diagram
		TopologicalSorting g = new TopologicalSorting(6);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort();
	}

}
