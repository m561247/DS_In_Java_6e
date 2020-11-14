package Chapter7;

import java.util.Iterator;

import Chapter7.FavoritesList.Item;


public interface PositionalList<E> extends Iterable<E> {
	int size();
	
	boolean isEmpty();
	
	Position<E> first();
	
	Position<E> last();
	
	Position<E> before(Position<E> p) throws IllegalArgumentException;
	
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	
	Position<E> addFirst(E e);
	
	Position<E> addLast(E e);
	
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	E set(Position<E> p, E e) throws IllegalArgumentException;
	
	E remove(Position<E> p) throws IllegalArgumentException;
	
	Iterator<E> iterator();
	
	/* exercises */
	int indexOf(Position<E> p);
	
	Position<E> findPosition(E e);
	
	Iterable<Position<E>> positions();
}
