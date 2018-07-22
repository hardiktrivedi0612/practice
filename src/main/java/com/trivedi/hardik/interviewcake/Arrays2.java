package com.trivedi.hardik.interviewcake;

/**
 * Write a method that takes an array of characters and reverses the letters
 * in-place.
 * 
 * @author hatrivedi
 * @date Jun 10, 2018
 * @since 2.5
 */
public class Arrays2 {

	/**
	 * @author hatrivedi
	 * @date Jun 10, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		char[] input = { 'a', 'b', 'c', 'd' };
		System.out.println(input);
		reverseString(input);
		System.out.println(input);
	}

	public static void reverseString(char[] input) {
		int half = input.length / 2;
		int i = 0;
		while (i < half) {
			char left = input[i];
			input[i] = input[input.length - i - 1];
			input[input.length - i - 1] = left;
			i++;
		}
	}

}
