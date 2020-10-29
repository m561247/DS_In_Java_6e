package Chapter3;

public class SinglyLinkedList<E> implements Cloneable {
	private static class Node<E> {
		private E elemet;
		private Node<E> next;

		public Node(E element, Node next) {
			this.elemet = element;
			this.next = next;
		}

		public E getElment() {
			return this.elemet;
		}

		public Node<E> getNext() {
			return this.next;
		}

		public void setNext(Node<E> n) {
			this.next = n;
		}
	}

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	public SinglyLinkedList() {
	};

	// access methods
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
		return head.getElment();
	}

	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElment();
	}

	// update methods
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0) {
			tail = head;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newest = new Node(e, null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		E answer = head.getElment();
		head = head.getNext();
		size--;
		if (size == 0) {
			tail = null;
		}
		return answer;
	}

	// SLList的equals方法
	public boolean eaquals(Object o) {
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) o;
		if (size != other.size) {
			return false;
		}
		Node<E> walkA = head;
		Node<E> walkB = other.head;
		while (walkA != null) {
			if (!walkA.getElment().equals(walkB.getElment())) {
				return false;
			}
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}

	// Linked List 的複製
	@Override
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		SinglyLinkedList<E> other = (SinglyLinkedList) super.clone();
		if (size > 0) {
			other.head = new Node<>(head.getElment(), null);
			Node<E> walk = head.getNext();
			Node<E> otherTail = other.head;
			while (walk != null) {
				Node<E> newestNode = new Node<>(walk.getElment(), null);
				otherTail.setNext(newestNode);
				otherTail = newestNode;
				walk = walk.getNext();
			}
		}
		return other;
	}

	/*
	 * reverse linked list iteration
	 */
//	public void reverseList() {
//		tail = head;
//		Node<E> next = null;
//	    while (head != null) {
//	        Node<E> last = head.next;
//	        head.next = next;
//	        next = head;
//	        head = last;
//	    }
//	    head = next;
//	}
	/*
	 * reverse linked list recursion
	 */
	public void reverse() {
		reverseList(this.head);
	}

	public Node<E> reverseList(Node<E> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<E> nextNode = head.next;
//        Node<E> newHead=reverseList(nextNode);
		this.head = reverseList(nextNode);
		nextNode.next = head;
		head.next = null;
		this.tail = head;
		return this.head;
	}

	public static void main(String[] args) {
		SinglyLinkedList sl = new SinglyLinkedList();
		sl.addFirst(1);
		sl.addFirst(1);
		sl.addFirst(1);
		sl.addFirst(1);
		sl.reverse();

	}
}
