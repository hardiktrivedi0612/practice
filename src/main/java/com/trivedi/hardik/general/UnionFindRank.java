package com.trivedi.hardik.general;

public class UnionFindRank {

	int V, E;
	Edge edge[];

	private class Edge {
		int src, dest;
	};

	class subset {
		int parent, rank;
	};

	UnionFindRank(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; i++) {
			edge[i] = new Edge();
		}
	}

	int find(subset[] subsets, int node) {
		// find root and make root as parent of i (path compression)
		if (subsets[node].parent != node) {
			subsets[node].parent = find(subsets, subsets[node].parent);
		}
		return subsets[node].parent;
	}

	void union(subset[] subsets, int x, int y) {
		int xRoot = find(subsets, x);
		int yRoot = find(subsets, y);

		if (subsets[xRoot].rank < subsets[yRoot].rank) {
			subsets[xRoot].parent = yRoot;
		} else if (subsets[xRoot].rank > subsets[yRoot].rank) {
			subsets[yRoot].parent = xRoot;
		} else {
			subsets[yRoot].parent = xRoot;
			subsets[xRoot].rank++;
		}
	}

	int isCycle(UnionFindRank graph) {
		subset[] subsets = new subset[graph.V];
		for (int i = 0; i < graph.V; i++) {
			subsets[i] = new subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		for (int i = 0; i < E; i++) {
			int x = find(subsets, edge[i].src);
			int y = find(subsets, edge[i].dest);

			if (x == y) {
				return 1;
			}

			union(subsets, x, y);
		}
		return 0;
	}

	public static void main(String[] args) {

		int V = 3, E = 3;
		UnionFindRank graph = new UnionFindRank(V, E);

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
