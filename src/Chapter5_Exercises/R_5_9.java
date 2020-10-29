package Chapter5_Exercises;

public class R_5_9 {
//	public static double power(double x, int n) {
//		if (n == 0) {
//			return 1;
//		} else {
//			double partial = power(x, n / 2);
//			double result = partial * partial;
//			if (n % 2 == 1) {
//				result *= x;
//			}
//			return result;
//		}
//	}
	public static double power(double x, int n) {
		double result = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				result *= x;
			}
			x *= x;
			n /= 2;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(power(2, 4));
	}
}
