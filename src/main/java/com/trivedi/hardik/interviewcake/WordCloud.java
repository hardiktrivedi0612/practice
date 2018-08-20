package com.trivedi.hardik.interviewcake;
import java.util.HashMap;


/**
 * You want to build a word cloud, an infographic where the size of a word
 * corresponds to how often it appears in the body of text.
 * 
 * To do this, you'll need data. Write code that takes a long string and builds
 * its word cloud data in a hash map ↴ , where the keys are words and the values
 * are the number of times the words occurred.
 * 
 * Think about capitalized words. For example, look at these sentences:
 * 
 * "After beating the eggs, Dana read the next step:" "Add milk and eggs, then
 * add flour and sugar."
 * 
 * What do we want to do with "After", "Dana", and "add"? In this example, your
 * final hash map should include one "Add" or "add" with a value of 222. Make
 * reasonable (not necessarily perfect) decisions about cases like "After" and
 * "Dana".
 * 
 * Assume the input will only contain words and standard punctuation.
 * 
 * @author hatrivedi
 * @date Jun 12, 2018
 * @since 2.5
 */
public class WordCloud {

	/**
	 * @author hatrivedi
	 * @date Jun 12, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "After beating the eggs, Dana read the next step:\n"
				+ "Add milk and eggs, then add flour and sugar.";
		HashMap<String, Integer> wordCloud = createWordCloud(str);
		System.out.println(wordCloud);
	}

	/**
	 * @author hatrivedi
	 * @date Jun 12, 2018
	 * @since 2.5
	 * @param str
	 * @return
	 */
	private static HashMap<String, Integer> createWordCloud(String str) {
		HashMap<String, Integer> wordCount = new HashMap<>();
		StringBuilder word = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (Character.isLetter(c)) {
				word.append(c);
			} else if (c.equals(' ') || c.equals('\n')) {
				// One word is complete
				String wordLower = word.toString().toLowerCase();
				if (wordCount.containsKey(wordLower)) {
					wordCount.put(wordLower, wordCount.get(wordLower) + 1);
				} else {
					wordCount.put(wordLower, 1);
				}
				word = new StringBuilder();
			}
		}
		return wordCount;
	}

}
