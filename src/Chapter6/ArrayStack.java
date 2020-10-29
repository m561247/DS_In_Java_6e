package Chapter6;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E>{
	public static final int CAPACITY = 1000;
	private E[] data;
	private int t = -1; // index of the top element in stack
	public ArrayStack() { this(CAPACITY); }; // 重要
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}
	@Override
	public int size() {
		return (t + 1);
	}

	@Override
	public boolean isEmpty() {
		return (t == -1);
	}

	@Override
	public void push(E e) throws IllegalStateException {
		if (size() == data.length) {
			throw new IllegalStateException("Stack is Full");
		}
		data[++t] = e;
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return data[t];
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}
	
	/* reverse array */
	public static <E> void reverse(E[] a) {
		Stack<E> buffer = new ArrayStack<>();
		for (int i = 0; i < a.length; i++) {
			buffer.push(a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = buffer.pop();
		}
	}
	public static void main(String args[]) {
		Integer[] a = {4, 8, 15, 16, 23, 42};
		String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
		reverse(a);
		reverse(s);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(s));
	}
}
