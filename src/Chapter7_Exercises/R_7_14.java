package Chapter7_Exercises;

import Chapter7.LinkedPositionalList;

/**
 * The LinkedPositionalList implementation of Code Fragments 7.9–7.12 does not
 * do any error checking to test if a given position p is actually a member of
 * the relevant list. Give a detailed explanation of the effect of a call
 * L.addAfter(p, e) on a list L, yet with a position p that belongs to some
 * other list M.
 */
public class R_7_14 {
	public static void main(String[] args) {
		   LinkedPositionalList L = new LinkedPositionalList();
	        LinkedPositionalList M = new LinkedPositionalList();

	        L.addFirst("A");
	        L.addLast("B");
	        L.addLast("C");
	        L.addBefore(L.first(), 1);

	        System.out.println("Lista L: " + L.toString());

	        M.addFirst("F");
	        M.addLast("G");
	        M.addLast("H");

	        System.out.println("Lista M: " +M.toString());

	        L.addAfter(M.last(), 2);

	        System.out.println("Lista L: " + L.toString());
	        System.out.println("Lista M: " +M.toString());
	}
}
