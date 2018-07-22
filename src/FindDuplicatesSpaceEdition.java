import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * 
 * Find a duplicate, Space Edition™.
 * 
 * We have an array of integers, where:
 * 
 * The integers are in the range 1....n The array has a length of n+1
 * 
 * It follows that our array has at least one integer which appears at least
 * twice. But it may have several duplicates, and each duplicate may appear more
 * than twice.
 * 
 * Write a method which finds an integer that appears more than once in our
 * array. (If there are multiple duplicates, you only need to find one of them.)
 * 
 * We're going to run this method on our new, super-hip MacBook Pro With Retina
 * Display™. Thing is, the damn thing came with the RAM soldered right to the
 * motherboard, so we can't upgrade our RAM. So we need to optimize for space!
 * 
 * @author hardik
 *
 */
public class FindDuplicatesSpaceEdition {

	public static int findRepeat(int[] theArray) {
		int floor = 1;
		int ceiling = theArray.length - 1;
		while (floor < ceiling) {
			int midpoint = floor + ((ceiling - floor) / 2);
			int lowerRangeFloor = floor;
			int lowerRangeCeiling = midpoint;
			int higherRangeFloor = midpoint + 1;
			int higherRangeCeiling = ceiling;

			int numbersInLowerRange = 0;
			for (int i : theArray) {
				if (i >= lowerRangeFloor && i <= lowerRangeCeiling) {
					numbersInLowerRange++;
				}
			}

			int distinctNumbersinLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

			if (numbersInLowerRange > distinctNumbersinLowerRange) {
				floor = lowerRangeFloor;
				ceiling = lowerRangeCeiling;
			} else {
				floor = higherRangeFloor;
				ceiling = higherRangeCeiling;
			}
		}
		return floor;
	}

	// tests

	@Test
	public void justTheRepeatedNumberTest() {
		final int[] numbers = { 1, 1 };
		final int expected = 1;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void shortArrayTest() {
		final int[] numbers = { 1, 2, 3, 2 };
		final int expected = 2;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void mediumArrayTest() {
		final int[] numbers = { 1, 2, 5, 5, 5, 5 };
		final int expected = 5;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void longArrayTest() {
		final int[] numbers = { 4, 1, 4, 8, 3, 2, 7, 6, 5 };
		final int expected = 4;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(FindDuplicatesSpaceEdition.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}

}
