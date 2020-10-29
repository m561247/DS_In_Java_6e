package Chapter7_Exercises;

import Chapter7.ArrayList;

/**
 * Consider an implementation of the array list ADT using a dynamic array, but
 * instead of copying the elements into an array of double the size (that is,
 * fromN to 2N) when its capacity is reached, we copy the elements into an array
 * with ⌈N/4⌉ additional cells, going from capacity N to N +⌈N/4⌉. Show that
 * performing a sequence of n push operations (that is, insertions at the end)
 * still runs in O(n) time in this case.
 */
public class R_7_7 {
	public static <E> void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(2);
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 4);
	}
}
