package Chapter5_Exercises;

public class R_5_10 {
	public static int sum2dArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr.length != arr[i].length) {
				return -1;
			}
		}
		return sum2dArrayHelper(arr, arr.length, 0, 0);
	}

	public static int sum2dArrayHelper(int[][] arr, int n, int x, int y) {
		if (n == 1) {
			return arr[x][y];
		} else if (n % 2 == 0) {
			int factorial = n / 2;
			return sum2dArrayHelper(arr, factorial, x, y) + sum2dArrayHelper(arr, factorial, x + factorial, y)
					+ sum2dArrayHelper(arr, factorial, x, y + n / 2)
					+ sum2dArrayHelper(arr, factorial, x + factorial, y + factorial);
		} else {
			int edgeSum = 0, deltaX = x, deltaY = y;
			for (int i = 0; i < n; i++) {
				edgeSum += arr[x][deltaY++];
				edgeSum += arr[deltaX++][y];
			}
			edgeSum -= arr[x][y];
			n--;
			x++;
			y++;
			int factorial = n / 2;
			return edgeSum + sum2dArrayHelper(arr, factorial, x, y) + sum2dArrayHelper(arr, factorial, x + factorial, y)
					+ sum2dArrayHelper(arr, factorial, x, y + n / 2)
					+ sum2dArrayHelper(arr, factorial, x + factorial, y + factorial);
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 },
				{ 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 } };
		System.out.println(sum2dArray(arr));
	}
}
