package Chapter5_Exercises;

public class R_5_8 {
	public static int convertToInt(String s) {
		if (s.length() == 1) {
			return s.charAt(0) - 48;
		}
		int c = s.charAt(s.length() - 1) - 48;
		int recur = 10 * convertToInt(s.substring(0, s.length() - 1));
		return c + recur;
	}

	public static void main(String[] args) {
		String str = "123456";
		System.out.println(convertToInt(str));
	}
}
