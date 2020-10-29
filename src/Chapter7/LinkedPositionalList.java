package Chapter7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {

	/* nested Node class */
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			this.element = e;
			this.prev = p;
			this.next = n;
		}

		@Override
		public E getElement() throws IllegalStateException {
			if (next == null) {
				throw new IllegalStateException("Position no longer valid");
			}
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setElement(E e) {
			this.element = e;
		}

		public void setPrev(Node<E> p) {
			this.prev = p;
		}

		public void setNext(Node<E> n) {
			this.next = n;
		}
	}
	/* end of nested class */

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public LinkedPositionalList() {
		this.header = new Node<>(null, null, null);
		this.trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	/* private utilities */
	/* 驗證加入的 node 是否合法 */
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("Invalid p");
		}
		Node<E> node = (Node<E>) p;
		if (node.getNext() == null) {
			throw new IllegalArgumentException("p is no longer in the list");
		}
		return node;
	}

	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer) {
			return null;
		}
		return node;
	}

	/* public accessor methods */
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Position<E> first() {
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		return position(trailer.getPrev());
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}

	/* private utilities */
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		this.size++;
		return newest;
	}

	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		this.size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}

	/* nested PositionIterator class */
	private class PositionIterator implements Iterator<Position<E>> {
		private Position<E> cursor = first(); // position of the next element to report
		private Position<E> recent = null; // position of last reported element

		@Override
		public boolean hasNext() {
			return (cursor != null);
		}

		@Override
		public Position<E> next() {
			if (cursor == null) {
				throw new NoSuchElementException("nothing left");
			}
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}

		public void remove() throws IllegalStateException {
			if (recent == null) {
				throw new IllegalStateException("nothing to remove");
			}
			LinkedPositionalList.this.remove(recent);
			recent = null;
		}
	}
	/* end of nested PositionIterable class */

	/* nested PositionIterable class */
	private class PositionIterable implements Iterable<Position<E>> {
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
	}
	/* end of nested PositionIterable class */

	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}

	/* nested ElementIterator class */
	/* this class adapts the iteration produced by [psitions() to return elements */
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = new PositionIterator();

		public boolean hasNext() {
			return posIterator.hasNext();
		}

		public E next() {
			return posIterator.next().getElement();
		}

		public void remove() {
			posIterator.remove();
		}
	}
	/* end of private class */

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	/* Insertion-sort of a positional list of integers into nondecreasing order */
	public static void insertionSort(PositionalList<Integer> list) {
		Position<Integer> marker = list.first(); // marker 一個指標，代表在它之前的都是已經排序過的 node
		while (marker != list.last()) {
			Position<Integer> pivot = list.after(marker);
			int value = pivot.getElement();
			if (value > marker.getElement()) {
				marker = pivot;
			} else {
				Position<Integer> walk = marker;
				while (walk != list.first() && list.before(walk).getElement() > value) {
					walk = list.before(walk);
				}
				list.remove(pivot);
				list.addBefore(walk, value);
			}
		}
	}

	// exercises
	public Position<E> addLastAlt(E e) {
		Node<E> node = validate(last());
		return addAfter(node, e);
	}

	public Position<E> addBeforeAlt(Position<E> p, E e) {
		Node<E> node = validate(p);
		return addAfter(node.getPrev(), e);
	}

	@Override
	public int indexOf(Position<E> p) {
		Node<E> node = validate(p);
		Node<E> walk = (Node<E>) first();
		for (int i = 0; i < size; i++) {
			if (node == walk) {
				return i;
			}
			walk = walk.getNext();
		}
		return -1;
	}

	@Override
	public Position<E> findPosition(E e) {
		Node<E> walk = validate(first());
		for (int i = 0; i < size; i++) {
			if (walk.getElement() == e) {
				return walk;
			}
			walk = walk.getNext();
		}
		return null;
	}
	
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		Node<E> walk = header.getNext();
		while (walk != trailer) {
			sb.append(walk.getElement());
			walk = walk.getNext();
			if (walk != trailer)
				sb.append(", ");
		}
		sb.append(")");
		return sb.toString();
	}

}
