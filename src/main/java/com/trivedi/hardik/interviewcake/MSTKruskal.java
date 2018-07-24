package com.trivedi.hardik.interviewcake;

import java.util.Arrays;

public class MSTKruskal {

	int V, E;
	Edge[] edge;

	private class Edge implements Comparable<Edge> {
		int src, dest, weight;

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	private class Subset {
		int parent, rank;
	}

	MSTKruskal(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[e];
		for (int i = 0; i < E; i++) {
			edge[i] = new Edge();
		}
	}

	int find(Subset[] subsets, int node) {
		if (subsets[node].parent != node) {
			subsets[node].parent = find(subsets, subsets[node].parent);
		}
		return subsets[node].parent;
	}

	void union(Subset[] subsets, int x, int y) {
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

	void KruskalMST() {
		Edge[] result = new Edge[V - 1];
		for (int i = 0; i < V - 1; i++) {
			result[i] = new Edge();
		}

		Arrays.sort(edge);

		Subset[] subsets = new Subset[V];
		for (int i = 0; i < V; i++) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}

		int mstEdgeCount = 0;
		int edgeCount = 0;
		while (mstEdgeCount < V - 1) {
			Edge nextEdge = edge[edgeCount++];
			int x = find(subsets, nextEdge.src);
			int y = find(subsets, nextEdge.dest);

			if (x != y) {
				// It is not a cycle
				result[mstEdgeCount++] = nextEdge;
				union(subsets, x, y);
			}
		}

		System.out.println("Following are the edges in " + "the constructed MST");
		for (int i = 0; i < V - 1; ++i)
			System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);

	}

	public static void main(String[] args) {
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of edges in graph
		MSTKruskal graph = new MSTKruskal(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 10;

		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 6;

		// add edge 0-3
		graph.edge[2].src = 0;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;

		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 15;

		// add edge 2-3
		graph.edge[4].src = 2;
		graph.edge[4].dest = 3;
		graph.edge[4].weight = 4;

		graph.KruskalMST();
	}

}
