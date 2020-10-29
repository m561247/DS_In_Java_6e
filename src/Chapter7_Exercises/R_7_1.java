package Chapter7_Exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Draw a representation, akin to Example 7.1, of an initially empty list L
 * after performing the following sequence of operations: add(0, 4), add(0, 3),
 * add(0, 2), add(2, 1), add(1, 5), add(1, 6), add(3, 7), add(0, 8).
 */
public class R_7_1 {
	public static void main(String[] args) {
		   List list = new ArrayList<>();

	        list.add(0, 4);
	        list.add(0, 3);
	        list.add(0, 2);
	        list.add(2, 1);
	        list.add(1, 5);
	        list.add(1, 6);
	        list.add(3, 7);
	        list.add(0, 8);

	        System.out.println(list.toString());
	}
}
