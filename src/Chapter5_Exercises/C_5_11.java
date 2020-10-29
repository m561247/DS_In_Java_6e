package Chapter5_Exercises;

public class C_5_11 {
	public static int logTwo(int n) {
		if (n < 2) {
			return 0;
		} else {
			return 1 + logTwo(n / 2);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(logTwo(i));
		}
	}
}
