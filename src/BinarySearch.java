
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binarySearchIterative(3, new int[] {1,2,3,4}));
		System.out.println(binarySearchRecursive(1, new int[] {1,2,3,4}, -1, 4));
	}

	public static boolean binarySearchIterative(int target, int[] nums) {
		int floorIndex = -1;
		int ceilingIndex = nums.length;

		while (floorIndex + 1 < ceilingIndex) {
			int halfway = (ceilingIndex - floorIndex) / 2;
			int guessIndex = floorIndex + halfway;
			int guessValue = nums[guessIndex];
			if (guessValue == target) {
				return true;
			}
			if (guessValue > target) {
				ceilingIndex = guessIndex;
			} else {
				floorIndex = guessIndex;
			}
		}
		return false;
	}
	
	public static boolean binarySearchRecursive(int target, int nums[], int floorIndex, int ceilingIndex) {
		if(floorIndex + 1 >= ceilingIndex)
			return false;
		int halfway = (ceilingIndex - floorIndex) / 2;
		int guessIndex = floorIndex + halfway;
		int guessValue = nums[guessIndex];
		if (guessValue == target) {
			return true;
		}
		if (guessValue > target) {
			return binarySearchRecursive(target, nums, floorIndex, guessIndex);
		} else {
			return binarySearchRecursive(target, nums, guessIndex, ceilingIndex);
		}
	}
	
	
}
