package Chapter6_Exercises;

import Chapter6.Deque;
import Chapter6.LinkedDeque;
import Chapter6.Stack;

/**
 * Give a simple adapter that implements the stack ADT while using an instance
 * of a deque for storage.
 * @param <E>
 */
public class R_6_10<E> {
	private class stackToDeque implements Stack<E>{
		private Deque<E> dq = new LinkedDeque<>();
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return dq.size();
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return dq.isEmpty();
		}

		@Override
		public void push(E e) {
			dq.addFirst(e);
		}

		@Override
		public E top() {
			return dq.first();
		}

		@Override
		public E pop() {
			return dq.removeFirst();
		}
		
	}
}
