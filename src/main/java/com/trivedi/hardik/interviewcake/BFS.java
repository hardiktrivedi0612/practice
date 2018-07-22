package com.trivedi.hardik.interviewcake;
import java.util.LinkedList;

public class BFS {

	private int V;
	private LinkedList<Integer> adj[];

	BFS(int v) {
		this.V = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			this.adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void BFS(int startNode) {
		boolean[] visited = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[startNode] = true;
		queue.add(startNode);
	}

	public static void main(String[] args) {
		BFS g = new BFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}

}
