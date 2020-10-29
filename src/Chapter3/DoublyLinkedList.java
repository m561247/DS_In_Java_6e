package Chapter3;

public class DoublyLinkedList<E> {
	/* Node */
	private static class Node<E> {
		private E elemet;
		private Node<E> next;
		private Node<E> prev;

		public Node(E element, Node next, Node prev) {
			this.elemet = element;
			this.next = next;
			this.prev = prev;
		}

		public E getElement() {
			return this.elemet;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return this.next;
		}

		public void setNext(Node<E> n) {
			this.next = n;
		}
	}

	/* Node */
	// DLList實體變數
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	// 初始化DLList
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, null, header);
		header.setNext(trailer);
	}

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
		return header.getNext().getElement();
	}

	public E last() {
		if (isEmpty()) {
			return null;
		}
		return trailer.getPrev().getElement();
	}

	/*----------------------重要-------------------*/
	public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newNode = new Node<E>(e, predecessor, successor);
		predecessor.setNext(newNode);
		successor.setPrev(newNode);
		size++;
	}
	/*---------------------------------------------*/
	
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}

	/*----------------------重要-------------------*/
	public E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}
	/*---------------------------------------------*/
	
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		return remove(header.getNext());
	}

	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		return remove(trailer.getPrev());
	}

	public static void main(String[] args) {

	}
}
