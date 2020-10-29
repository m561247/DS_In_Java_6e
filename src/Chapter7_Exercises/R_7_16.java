package Chapter7_Exercises;

import Chapter7.LinkedPositionalList;

/**
 * Describe how to implement a method, alternateIterator( ), for a positional
 * list that returns an iterator that reports only those elements having even
 * index in the list.
 * @param <E>
 */
public class R_7_16<E> {
	public static void main(String[] args) {
		LinkedPositionalList list = new LinkedPositionalList<>();
		list.addFirst(1);
		list.addFirst(2);
		list.addLast(3);
		list.addAfter(list.first(), 4);
		list.addBefore(list.last(), 5);
		System.out.println(list);
		while (list.iterator().next() != null) {
			System.out.println("iterator");
		}
	}
}
