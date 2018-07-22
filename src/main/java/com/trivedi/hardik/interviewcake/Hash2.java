package com.trivedi.hardik.interviewcake;
import java.util.HashSet;


/**
 * Write an efficient method that checks whether any permutation ↴ of an input
 * string is a palindrome. ↴
 * 
 * You can assume the input string only contains lowercase letters.
 * 
 * Examples:
 * 
 * "civic" should return true "ivicc" should return true "civil" should return
 * false "livci" should return false
 * 
 * @author hatrivedi
 * @date Jun 12, 2018
 * @since 2.5
 */
public class Hash2 {

	/**
	 * @author hatrivedi
	 * @date Jun 12, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		char[] chars = { 'c', 'i', 'v', 'i', 'l' };
		System.out.println(checkIfAnyPermutationIsPalindrome(chars));
	}

	/**
	 * @author hatrivedi
	 * @date Jun 12, 2018
	 * @since 2.5
	 * @param chars
	 * @return
	 */
	private static boolean checkIfAnyPermutationIsPalindrome(char[] chars) {
		// HashMap<Character, Integer> charCount = new HashMap<>();
		// for (char c : chars) {
		// if (charCount.containsKey(c)) {
		// charCount.put(c, charCount.get(c) + 1);
		// } else {
		// charCount.put(c, 1);
		// }
		// }
		// System.out.println(charCount);
		// return (charCount.values().stream().filter(x -> x % 2 !=
		// 0).collect(Collectors.counting()) > 1) ? false : true;

		HashSet<Character> unpairedCharacters = new HashSet<Character>();
		for (char c : chars) {
			if (unpairedCharacters.contains(c)) {
				unpairedCharacters.remove(c);
			} else {
				unpairedCharacters.add(c);
			}
		}
		return unpairedCharacters.size() <= 1;

	}

}
