package Chapter5;


public class FibonecciGood {
	/** Returns array containing the pair of Fibonacci numbers, F(n) and F(n−1). */
	public static long[] fibonecciGood(int n) {
		if (n <= 1) {
			long[] answer = {n, 0};
			return answer;
		} else {
			long[] temp = fibonecciGood(n - 1);
			long[] answer = {temp[0] + temp[1], temp[0]};
			return answer;
		}
	}
}
