package Chapter5;

public class SummingtheElementsofanArrayRecursively {

//	Summing the Elements of an Array Recursively
	public static int linearSum(int[]data, int n) {
		if (n == 1) {
			return data[n - 1];
		} else {
			int recur = linearSum(data, n - 1);
			return recur + data[n - 1];
		}
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		System.out.println(linearSum(arr, arr.length));
	}
}
