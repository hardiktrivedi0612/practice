
/**
 * 
 * 
 * I figured out how to get rich: online poker.
 * 
 * I suspect the online poker game I'm playing shuffles cards by doing a single
 * riffle. ↴
 * 
 * To prove this, let's write a method to tell us if a full deck of cards
 * shuffledDeck is a single riffle of two other halves half1 and half2.
 * 
 * We'll represent a stack of cards as an array of integers in the range 1...52
 * (since there are 52 distinct cards in a deck).
 * 
 * Here's a rigorous definition of the riffle algorithm:
 * 
 * cut the deck into halves half1 and half2 grab a random number of cards from
 * the top of half1 (could be 0, must be less than or equal to the number of
 * cards left in half1) and throw them into the shuffledDeck grab a random
 * number of cards from the top of half2 (could be 0, must be less than or equal
 * to the number of cards left in half2) and throw them into the shuffledDeck
 * repeat steps 2-3 until half1 and half2 are empty.
 * 
 * 
 * @author hatrivedi
 * @date Jun 11, 2018
 * @since 2.5
 */
public class Arrays5 {

	/**
	 * @author hatrivedi
	 * @date Jun 11, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {
		int half1Index = 0;
		int half2Index = 0;

		for (int card : shuffledDeck) {

			// if we still have cards in half1
			// and the "top" card in half1 is the same
			// as the top card in shuffledDeck
			if (half1Index < half1.length && card == half1[half1Index]) {
				half1Index++;

				// if we still have cards in half2
				// and the "top" card in half2 is the same
				// as the top card in shuffledDeck
			} else if (half2Index < half2.length && card == half2[half2Index]) {
				half2Index++;

				// if the top card in shuffledDeck doesn't match the top
				// card in half1 or half2, this isn't a single riffle.
			} else {
				return false;
			}
		}

		// all cards in shuffledDeck have been "accounted for"
		// so this is a single riffle!
		return true;
	}

}
