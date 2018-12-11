package com.trivedi.hardik.leetcode;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * @author hatrivedi
 * @date Dec 10, 2018
 * @since 2.5
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0 && carry > 0; i--) {
			int sum = digits[i] + carry;
			digits[i] = sum % 10;
			carry = sum / 10;
		}
		if (carry == 0) {
			return digits;
		}
		int[] response = new int[digits.length + 1];
		response[0] = carry;
		for (int i = 0; i < digits.length; i++) {
			response[i + 1] = digits[i];
		}
		return response;
	}
}
