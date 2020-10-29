package Chapter5_Exercises;

public class C_5_13 {
	public static int multiplyInts(int a, int b) {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException();
		} else if (b == 0) {
			return 0;
		} else if (b == 1) {
			return a;
		} else {
			return a + multiplyInts(a, b - 1);
		}
	}
}
