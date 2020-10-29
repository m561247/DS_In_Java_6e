package Chapter7_Exercises;

import java.util.Collections;

import java.util.*;

/**
 * Demonstrate how to use the java.util.Colletions.reverse method to reverse an
 * array of objects.
 */
public class R_7_20 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(0, 1);
		list.add(0, 2);
		list.add(0, 3);
		list.add(0, 4);
		list.add(0, 5);
//		Collections.reverse(list);
		for (int i : list) {
			System.out.println(i);
		}
	}
}
