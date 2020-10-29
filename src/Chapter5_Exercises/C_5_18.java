package Chapter5_Exercises;

public class C_5_18 {
	public static boolean isPalindrome(String s) {
		if (s.length() <= 1) {
			return true;
		} else if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return isPalindrome(s.substring(1, s.length() - 1));
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome("gohangasalamiimalasagnahog"));
	}
}
