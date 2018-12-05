package com.trivedi.hardik.leetcode.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.trivedi.hardik.leetcode.NestedInteger;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * @author hatrivedi
 * @date Dec 4, 2018
 * @since 2.5
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

	List<Integer> list;
	int index;

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        index = 0;
        list = new ArrayList<>();
        createList(nestedList, list);
    }

	private void createList(List<NestedInteger> nestedList, List<Integer> list) {
		if (nestedList == null || nestedList.size() == 0) {
			return;
		}
		for (NestedInteger nestedInteger : nestedList) {
			if (nestedInteger.isInteger()) {
				list.add(nestedInteger.getInteger());
			} else {
				createList(nestedInteger.getList(), list);
			}
		}
	}

	@Override
	public Integer next() {
		return list.get(index++);
	}

	@Override
	public boolean hasNext() {
		return index < list.size();
	}

}
