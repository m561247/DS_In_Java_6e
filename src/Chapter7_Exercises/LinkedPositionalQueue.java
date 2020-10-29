package Chapter7_Exercises;

import Chapter6.Queue;
import Chapter7.LinkedPositionalList;
import Chapter7.Position;

public class LinkedPositionalQueue<E> implements Queue<E> {
	LinkedPositionalList<E> list = new LinkedPositionalList<>();
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
		return (E) list.first();
	}

	@Override
	public E dequeue() {
		return list.remove(list.first());
	}
	
	public E remove(Position<E> p) {
		E temp = p.getElement();
		list.remove(p);
		return temp;
	}
}
