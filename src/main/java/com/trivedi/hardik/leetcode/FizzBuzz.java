package com.trivedi.hardik.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to
 * n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 * 
 * 
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
