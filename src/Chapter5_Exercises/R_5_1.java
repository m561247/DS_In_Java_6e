package Chapter5_Exercises;

/**
 * Describe a recursive algorithm for finding the maximum element in an array,
 * A, of n elements. What is your running time and space usage?
 *
 */
public class R_5_1 {
	public static <E extends Comparable<E>> E findMaxElement(E[] arr, int n) {
		if (n == 1) {
			return arr[0];
		} else {
			E lastElement = findMaxElement(arr, n - 1);
			return (lastElement.compareTo(arr[n - 1]) > 0) ? lastElement : arr[n - 1];
		}
	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(findMaxElement(arr, arr.length));
	}
}
