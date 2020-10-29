package Chapter5;

public class ReversingASequenceWithRecursion {
	public static void reverseArray(int[] data, int low, int high) {
		if (low < high) {
			int temp = data[high];
			data[high] = data[low];
			data[low] = temp;
			reverseArray(data, low + 1, high - 1);
		}
	}
	public static void main(String[] args) {
		reverseArray(new int[] {1, 2, 3, 4, 5, 6, 7}, 0, 6);
	}
}
