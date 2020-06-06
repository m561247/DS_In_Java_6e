package Chapter3;

public class SinglyLinkedList<E> {
	/**宣告static可以確保這個class不存取除他之外的資料
	 * 
	 * @author user
	 *
	 * @param <E>
	 */
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
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	public SinglyLinkedList() {};
	
	//access methods 
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
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
	//update methods
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
		}else {
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
	public static void main(String[] args) {
		SinglyLinkedList sl = new SinglyLinkedList();
		sl.addFirst(1);
		sl.addFirst(1);
		sl.addFirst(1);
		sl.addFirst(1);
		sl.addFirst(1);
		sl.addFirst(1);
		sl.addFirst(1);
		sl.addFirst(1);
		
	}
}
