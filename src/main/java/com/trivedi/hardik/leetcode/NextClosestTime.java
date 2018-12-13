package com.trivedi.hardik.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by
 * reusing the current digits. There is no limit on how many times a digit can
 * be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34",
 * "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * @author hatrivedi
 * @date Nov 8, 2018
 * @since 2.5
 */
public class NextClosestTime {
	public String nextClosestTime(String time) {
		int givenHour = Integer.parseInt(time.substring(0, 2));
		int givenMinute = Integer.parseInt(time.substring(3, 5));

		Set<Integer> allowedChars = new HashSet<>();
		for (char c : time.toCharArray()) {
			if (c != ':') {
				allowedChars.add(c - '0');
			}
		}

		int currentTime = givenMinute + (givenHour * 60);
		while (true) {
			currentTime = (currentTime + 1) % (24 * 60);
			int currentMinute1 = (currentTime % 60) / 10;
			int currentMinute2 = (currentTime % 60) % 10;
			int currentHour1 = (currentTime / 60) / 10;
			int currentHour2 = (currentTime / 60) % 10;

			if (allowedChars.contains(currentMinute1) && allowedChars.contains(currentMinute2)
					&& allowedChars.contains(currentHour1) && allowedChars.contains(currentHour2)) {
				return currentHour1 + "" + currentHour2 + ":" + currentMinute1 + "" + currentMinute2;
			}
		}

	}

	public static void main(String[] args) {
		NextClosestTime app = new NextClosestTime();
		System.out.println(app.nextClosestTime("12:09"));
	}
}
