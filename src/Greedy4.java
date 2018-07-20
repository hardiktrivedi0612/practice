import java.util.Arrays;
import java.util.Random;


/**
 * 
 * 
 * Write a method for doing an in-place ↴ shuffle of an array.
 * 
 * The shuffle must be "uniform," meaning each item in the original array must
 * have the same probability of ending up in each spot in the final array.
 * 
 * Assume that you have a method getRandom(floor, ceiling) for getting a random
 * integer that is >= floor and <= ceiling.
 * 
 * @author hatrivedi
 * @date Jun 30, 2018
 * @since 2.5
 */
public class Greedy4 {

	/**
	 * @author hatrivedi
	 * @date Jun 30, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		final int[] initial = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		final int[] shuffled = Arrays.copyOf(initial, initial.length);
		shuffle(shuffled);
		System.out.printf("initial array: %s\n", Arrays.toString(initial));
		System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
	}

	private static Random rand = new Random();

	private static int getRandom(int floor, int ceiling) {
		return rand.nextInt((ceiling - floor) + 1) + floor;
	}

	public static void shuffle(int[] theArray) {
		// if it's 1 or 0 items, just return
		if (theArray.length <= 1) {
			return;
		}

		// walk through from beginning to end
		for (int indexWeAreChoosingFor = 0; indexWeAreChoosingFor < theArray.length - 1; indexWeAreChoosingFor++) {

			// choose a random not-yet-placed item to place there
			// (could also be the item currently in that spot)
			// must be an item AFTER the current item, because the stuff
			// before has all already been placed
			int randomChoiceIndex = getRandom(indexWeAreChoosingFor, theArray.length - 1);

			// place our random choice in the spot by swapping
			if (randomChoiceIndex != indexWeAreChoosingFor) {
				int valueAtIndexWeChoseFor = theArray[indexWeAreChoosingFor];
				theArray[indexWeAreChoosingFor] = theArray[randomChoiceIndex];
				theArray[randomChoiceIndex] = valueAtIndexWeChoseFor;
			}
		}
	}

}
