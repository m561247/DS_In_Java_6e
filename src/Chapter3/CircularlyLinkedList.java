package Chapter3;


public class CircularlyLinkedList<E> {
	/**Node*/
	private static class Node<E>{
		private E elemet;
		private Node<E> next;
		public Node(E element, Node next) {
			this.elemet = element;
			this.next = next;
		}
		public E getElment() { return this.elemet; }
		public Node<E> getNext(){ return this.next; }
		public void setNext(Node<E> n) { this.next = n; }
	}
	/**Node*/
	private Node<E> tail = null;
	private int size = 0;
	public CircularlyLinkedList() {};
	//access method
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return tail.getNext().getElment();
	}
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElment();
	}
	//update method
	public void rotate() {
		if (tail != null) {
			tail = tail.getNext();
		}
	}
	public void addFirst(E e) {
		if (size == 0) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		}else {
			Node<E> newNode = new Node<>(e, tail.getNext());
			tail.setNext(newNode);
		}
		size++;
	}
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}
	public E remvoeFirst() {
		if (isEmpty()) {
			return null;
		}
		Node<E> head = tail.getNext();
		if (head == tail) {
			tail = null;
		}else {
			tail.setNext(head.getNext());
			size--;
		}
		return head.getElment();
	}
	public static void main(String[] args) {
		CircularlyLinkedList cl = new CircularlyLinkedList();
	}
}
