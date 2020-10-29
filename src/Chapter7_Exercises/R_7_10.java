package Chapter7_Exercises;

import Chapter6.Stack;
import Chapter7.ArrayList;
import Chapter7.List;

/**
 * Reimplement the ArrayStack class, from Section 6.1.2, using dynamic arrays to
 * support unlimited capacity.
 * @param <E>
 */
public class R_7_10<E> implements Stack<E>{
	private List<E> data;
	public R_7_10() {
		data = new ArrayList<>();
	};
	
	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public void push(E e) throws IllegalStateException{
		data.add(size(), e);
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return data.get(size() - 1);
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E answer = data.get(size() - 1);
		data.remove(size() - 1);
		return answer;
	}
}
