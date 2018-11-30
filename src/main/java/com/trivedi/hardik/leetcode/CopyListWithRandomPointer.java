package com.trivedi.hardik.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hatrivedi
 * @date Nov 6, 2018
 * @since 2.5
 */
public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode pointer = head;
		while (pointer != null) {
			map.put(pointer, new RandomListNode(pointer.label));
			pointer = pointer.next;
		}
		pointer = head;
		while (pointer != null) {
			map.get(pointer).next = map.get(pointer.next);
			map.get(pointer).random = map.get(pointer.random);
			pointer = pointer.next;
		}
		return map.get(head);
	}
}
