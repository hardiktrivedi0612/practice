package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> response = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				response.add("FizzBuzz");
			} else if (i % 3 == 0) {
				response.add("Fizz");
			} else if (i % 5 == 0) {
				response.add("Buzz");
			} else {
				response.add(Integer.toString(i));
			}
		}
		return response;
	}
}
