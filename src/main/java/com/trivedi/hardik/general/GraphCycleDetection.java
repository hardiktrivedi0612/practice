package com.trivedi.hardik.general;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Difference between cycle detection in directed and undirected graphs
 * https://stackoverflow.com/questions/10972028/finding-a-cycle-in-an-undirected-graph-vs-finding-one-in-a-directed-graph
 *
 */
public class GraphCycleDetection {

	private int V;
	private LinkedList<Integer> adj[];
	private boolean isUndirected;

	GraphCycleDetection(int v, boolean isUndirected) {
		this.V = v;
		this.isUndirected = isUndirected;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			this.adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		if (isUndirected) {
			adj[w].add(v);
		}
	}

	void detectCycle() {
		if (isUndirected) {
			System.out.println(detectCycleUndirected());
			return;
		}
		System.out.println(detectCycleDirected());
		return;
	}

	boolean detectCycleUndirected() {
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (detectCycleUndirectedUtil(i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	boolean detectCycleUndirectedUtil(int s, boolean[] visited, int parent) {
		visited[s] = true;
		Iterator<Integer> iter = adj[s].iterator();
		while (iter.hasNext()) {
			int i = iter.next();
			if (!visited[i]) {
				if (detectCycleUndirectedUtil(i, visited, s)) {
					return true;
				}
			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}

	boolean detectCycleDirected() {
		boolean visited[] = new boolean[V];
		boolean recursiveStack[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (detectCycleDirectedUtil(i, visited, recursiveStack)) {
				return true;
			}
		}
		return false;
	}

	boolean detectCycleDirectedUtil(int s, boolean[] visited, boolean[] recursiveStack) {
		if (recursiveStack[s]) {
			return true;
		}
		if (visited[s]) {
			return false;
		}
		visited[s] = true;
		recursiveStack[s] = true;

		Iterator<Integer> iter = adj[s].iterator();
		while (iter.hasNext()) {
			int i = iter.next();
			if (detectCycleDirectedUtil(i, visited, recursiveStack)) {
				return true;
			}
		}

		recursiveStack[s] = false;
		return false;
	}

	public static void main(String args[]) {
		GraphCycleDetection g = new GraphCycleDetection(8, true);

		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(3, 7);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(7, 4);
		g.addEdge(5, 6);
		g.addEdge(6, 7);

		g.detectCycle();
	}
}