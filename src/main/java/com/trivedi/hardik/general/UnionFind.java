package com.trivedi.hardik.general;

/**
 * Cycle detection for undirected graphs
 * 
 * Condition: There should not be any self cycles
 * 
 * @author hatrivedi
 * @date Jul 23, 2018
 * @since 2.5
 */
public class UnionFind {
	int V, E;
	Edge edge[];

	private class Edge {
		int src, dest;
	};

	UnionFind(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; i++) {
			edge[i] = new Edge();
		}
	}

	int find(int parent[], int node) {
		if (parent[node] == -1) {
			return node;
		}
		return find(parent, parent[node]);
	}

	void union(int parent[], int x, int y) {
		int xSet = find(parent, x);
		int ySet = find(parent, y);
		parent[xSet] = ySet;
	}

	int isCycle(UnionFind graph) {
		int parent[] = new int[graph.V];
		for (int i = 0; i < graph.V; i++) {
			parent[i] = -1;
		}
		for (int i = 0; i < graph.E; i++) {
			int x = graph.find(parent, graph.edge[i].src);
			int y = graph.find(parent, graph.edge[i].dest);
			if (x == y)
				return 1;
			graph.union(parent, x, y);
		}
		return 0;
	}

	// Driver Method
	public static void main(String[] args) {

		int V = 3, E = 3;
		UnionFind graph = new UnionFind(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (graph.isCycle(graph) == 1)
			System.out.println("graph contains cycle");
		else
			System.out.println("graph doesn't contain cycle");
	}

}
