package Chapter6;

import Chapter3.CircularlyLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {

	private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();
	public LinkedCircularQueue() {};
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}

	@Override
	public E first() {
		return list.first();
	}

	@Override
	public E dequeue() {
		return list.remvoeFirst();
	}

	@Override
	public void rotate() {
		list.rotate();
	}

}
