package Chapter5;

public class EliminatingTailRecursion {
	public boolean binarySearchIterative(int[] data, int target) {
		int low = 0;
		int high = data.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] == target) {
				return true;
			} else if (target < data[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
	public static void reverseIterative(int[] data) {
		int low = 0, high = data.length - 1;
		while (low < high) {
			int temp = data[low];
			data[low] = data[high];
			data[high] = temp;
			low++;
			high--;
		}
	}
}
