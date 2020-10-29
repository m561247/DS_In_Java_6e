package Chapter7_Exercises;

import Chapter6.Stack;
import Chapter7.ArrayList;
import Chapter7.List;

/**
 * Give an implementation of the stack ADT using an array list for storage
 * @param <E>
 */
public class R_7_2<E> implements Stack<E> {
	List<E> list = new ArrayList<>();
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		list.add(0, e);
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		return list.remove(0);
	}

}
