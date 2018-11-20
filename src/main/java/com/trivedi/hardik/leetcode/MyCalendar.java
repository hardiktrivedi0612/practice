package com.trivedi.hardik.leetcode;

import java.util.TreeMap;

/**
 * @author hatrivedi
 * @date Nov 15, 2018
 * @since 2.5
 */
public class MyCalendar {

	TreeMap<Integer, Integer> calendar;

	public MyCalendar() {
		this.calendar = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		Integer floorKey = calendar.floorKey(start);
		if (floorKey != null && calendar.get(floorKey) > start)
			return false;
		Integer ceilingKey = calendar.ceilingKey(start);
		if (ceilingKey != null && ceilingKey < end)
			return false;

		calendar.put(start, end);
		return true;
	}
}
