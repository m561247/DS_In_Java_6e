package Chapter5;

public class RecursiveAlgorithmsForComputingPowers {
//	public static double power(double x, int n) {
//		if (n == 0) {
//			return 1;
//		} else {
//			return x * power(x, n - 1);
//		}
//	}

//更快的方式
	public static double power(double x, int n) {
		if (n == 0) {
			return 1;
		} else {
			double partial = power(x, n / 2);
			double result = partial * partial;
			if (n % 2 == 1) {
				result *= x;
			}
			return result;
		}
	}
}
