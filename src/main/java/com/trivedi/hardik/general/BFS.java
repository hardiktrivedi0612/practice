package com.trivedi.hardik.general;

import java.util.Iterator;
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

	public void performBFS(int s) {
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);
		while (queue.size() != 0) {
			s = queue.poll();// Remove from the head of the queue
			System.out.print(s + " ");
			Iterator<Integer> iter = adj[s].iterator();
			while (iter.hasNext()) {
				int n = iter.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n); // Add to the rear of the queue
				}
			}
		}
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

		g.performBFS(2);
	}

}
