package Chapter7_Exercises;

import Chapter6.Deque;
import Chapter7.ArrayList;
import Chapter7.List;

/**
 * Give an implementation of the deque ADT using an array list for storage.
 * @param <E>
 */
public class R_7_3<E> implements Deque<E>{
	List<E> list = new ArrayList<>();
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return list.get(size() - 1);
	}

	@Override
	public void addFirst(E e) {
		list.add(0, e);
	}

	@Override
	public void addLast(E e) {
		list.add(size(), e);
	}

	@Override
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		return list.remove(size() - 1);
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		return list.remove(0);
	}

}
