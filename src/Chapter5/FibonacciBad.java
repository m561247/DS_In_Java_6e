package Chapter5;

public class FibonacciBad {
	public static long fibonacciBad(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacciBad(n - 1) + fibonacciBad(n - 2);
	}
}
