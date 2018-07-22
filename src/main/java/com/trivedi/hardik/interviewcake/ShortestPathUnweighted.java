package com.trivedi.hardik.interviewcake;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ShortestPathUnweighted {

	private int V;
	private LinkedList<Integer> adj[];

	ShortestPathUnweighted(int v) {
		this.V = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			this.adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	boolean BFS(int s, int d, int predecessors[]) {
		boolean[] visited = new boolean[V];

		Deque<Integer> queue = new ArrayDeque<>();

		visited[s] = true;
		queue.add(s);
		while (!queue.isEmpty()) {
			s = queue.poll();
			Iterator<Integer> iter = adj[s].iterator();
			while (iter.hasNext()) {
				int n = iter.next();
				if (!visited[n]) {
					visited[n] = true;
					predecessors[n] = s;

					if (n == d) {
						return true;
					}

					queue.add(n);
				}
			}
		}
		return false;
	}

	void printPath(int s, int d) {
		int[] predecessors = new int[V];
		for (int i = 0; i < V; i++) {
			predecessors[i] = -1;
		}
		if (!BFS(s, d, predecessors)) {
			System.out.println("Source and destination are not connected");
			return;
		}

		int predecessor = predecessors[d];
		Deque<Integer> stack = new ArrayDeque<>();
		do {
			stack.push(predecessor);
			predecessor = predecessors[predecessor];
		} while (predecessor != -1);

		System.out.println("Path = ");
		Integer node = stack.peek();
		while (node != null) {
			System.out.print(stack.pop() + " ");
			node = stack.peek();
		}
		System.out.print(d);
	}

	public static void main(String args[]) {
		ShortestPathUnweighted g = new ShortestPathUnweighted(8);

		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(3, 7);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(4, 7);
		g.addEdge(5, 6);
		g.addEdge(6, 7);

		g.printPath(0, 6);
	}
}
