package com.trivedi.hardik.interviewcake;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * You wrote a trendy new messaging app, MeshMessage, to get around flaky cell
 * phone coverage.
 * 
 * Instead of routing texts through cell towers, your app sends messages via the
 * phones of nearby users, passing each message along from one phone to the next
 * until it reaches the intended recipient. (Don't worry—the messages are
 * encrypted while they're in transit.)
 * 
 * Some friends have been using your service, and they're complaining that it
 * takes a long time for messages to get delivered. After some preliminary
 * debugging, you suspect messages might not be taking the most direct route
 * from the sender to the recipient.
 * 
 * Given information about active users on the network, find the shortest route
 * for a message from one user (the sender) to another (the recipient). Return
 * an array of users that make up this route
 *
 */
public class MeshMessaging {

	public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

		// find the shortest route in the network between the two users

		if (graph.get(endNode) == null || graph.get(startNode) == null) {
			throw new IllegalArgumentException("Illegal start or end nodes");
		}

		Set<String> nodesAlreadySeen = new HashSet<String>();
		nodesAlreadySeen.add(startNode);

		Map<String, String> parents = new HashMap<>();

		Deque<String> queue = new ArrayDeque<>();
		queue.addLast(startNode);

		while (!queue.isEmpty()) {
			String node = queue.pollFirst();
			if (node.equals(endNode)) {
				break;
			}
			for (String neighbor : graph.get(node)) {
				if (!nodesAlreadySeen.contains(neighbor)) {
					queue.addFirst(neighbor);
					nodesAlreadySeen.add(neighbor);
					parents.put(neighbor, node);
				}
			}
		}
		List<String> path = new ArrayList<String>();
		String parent = endNode;
		while (parent != null) {
			path.add(parent);
			parent = parents.get(parent);
		}
		if (path.size() == 1 && !endNode.equals(startNode))
			return null;
		Collections.reverse(path);
		return path.toArray(new String[path.size()]);
	}

	// tests

	@Test
	public void twoHopPath1Test() {
		final String[] expected = { "a", "c", "e" };
		final String[] actual = getPath(getNetwork(), "a", "e");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void twoHopPath2Test() {
		final String[] expected = { "d", "a", "c" };
		final String[] actual = getPath(getNetwork(), "d", "c");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneHopPath1Test() {
		final String[] expected = { "a", "c" };
		final String[] actual = getPath(getNetwork(), "a", "c");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneHopPath2Test() {
		final String[] expected = { "f", "g" };
		final String[] actual = getPath(getNetwork(), "f", "g");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneHopPath3Test() {
		final String[] expected = { "g", "f" };
		final String[] actual = getPath(getNetwork(), "g", "f");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void zeroHopPath() {
		final String[] expected = { "a" };
		final String[] actual = getPath(getNetwork(), "a", "a");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void noPathTest() {
		final String[] actual = getPath(getNetwork(), "a", "f");
		assertNull(actual);
	}

	@Test(expected = Exception.class)
	public void startNodeNotPresentTest() {
		getPath(getNetwork(), "h", "a");
	}

	@Test(expected = Exception.class)
	public void endNodeNotPresentTest() {
		getPath(getNetwork(), "a", "h");
	}

	private static Map<String, String[]> getNetwork() {
		return new HashMap<String, String[]>() {
			{
				put("a", new String[] { "b", "c", "d" });
				put("b", new String[] { "a", "d" });
				put("c", new String[] { "a", "e" });
				put("d", new String[] { "a", "b" });
				put("e", new String[] { "c" });
				put("f", new String[] { "g" });
				put("g", new String[] { "f" });
			}
		};
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MeshMessaging.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
