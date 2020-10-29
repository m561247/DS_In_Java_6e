package Chapter7_Exercises;

import Chapter7.ArrayList;
import Chapter7.List;

/**
 * The java.util.ArrayList includes a method, trimToSize( ), that replaces the
 * underlying array with one whose capacity precisely equals the number of
 * elements currently in the list. Implement such a method for our dynamic
 * version of the ArrayList class from Section 7.2.
 */
public class R_7_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList(16);
		list.add(0, "A");
		list.add(1, "B");
		list.add(2, "C");
		list.trimToSize();
		System.out.println(list);
	}
}
