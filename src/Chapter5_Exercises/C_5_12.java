package Chapter5_Exercises;

public class C_5_12 {

	public static boolean testUnique(int[] arr) {
		return testUniqueHelper(arr, arr.length);
	}

	public static boolean testUniqueHelper(int[] arr, int n) {
		if (n == 1) {
			return true;
		} else {
			int first = arr[arr.length - n];
			for (int i = arr.length - n + 1; i < arr.length; i++) {
				if (arr[i] == first) {
					return false;
				}
			}
			return testUniqueHelper(arr, n - 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 3, 4, 5, 7 };
		System.out.println(testUnique(arr));
	}
}
