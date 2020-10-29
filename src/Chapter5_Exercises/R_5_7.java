package Chapter5_Exercises;

public class R_5_7 {

	public static double harmonicNumber(int n) {
		if (n == 1) {
			return 1;
		} else {
			return 1.0 / n + harmonicNumber(n - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(harmonicNumber(20));
	}
}
