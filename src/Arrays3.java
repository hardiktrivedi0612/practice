
/**
 * You're working on a secret team solving coded transmissions.
 * 
 * Your team is scrambling to decipher a recent message, worried it's a plot to
 * break into a major European National Cake Vault. The message has been mostly
 * deciphered, but all the words are backwards! Your colleagues have handed off
 * the last step to you.
 * 
 * Write a method reverseWords() that takes a message as an array of characters
 * and reverses the order of the words in-place.
 * 
 * @author hatrivedi
 * @date Jun 10, 2018
 * @since 2.5
 */
public class Arrays3 {
	public static void main(String args[]) {
		char[] message = { 'c', 'a', 'k', 'e', ' ', 'p', 'o', 'u', 'n', 'd', ' ', 's', 't', 'e', 'a', 'l' };
		reverseWords(message);
		System.out.println(message);
	}

	/**
	 * @author hatrivedi
	 * @date Jun 10, 2018
	 * @since 2.5
	 * @param message
	 */
	private static void reverseWords(char[] message) {
		reverseWord(message, 0, message.length - 1);
		int left = 0;
		int spaceIndex = 0;
		while (left <= message.length) {
			if (left == message.length || message[left] == ' ' ) {
				reverseWord(message, spaceIndex, left - 1);
				spaceIndex = left + 1;
			}
			left++;
		}
	}

	private static void reverseWord(char[] message, int left, int right) {
		while (left < right) {
			char temp = message[left];
			message[left] = message[right];
			message[right] = temp;
			left++;
			right--;
		}
	}

}
