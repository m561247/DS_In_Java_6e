package Chapter6;

public class ArrayQueue<E> implements Queue<E> {
	public static final int CAPACITY = 10;
	private E[] data;
	private int f = 0; // index of the front element
	private int sz = 0; // current number of elements
	
	// constructors
	public ArrayQueue() {
		this(CAPACITY);
	}
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	// methods
	@Override
	public int size() {
		return sz;
	}

	@Override
	public boolean isEmpty() {
		return sz == 0;
	}
	/* inserts an element at the rear of the queue */
	@Override
	public void enqueue(E e) throws IllegalStateException  {
		if (sz == data.length) {
			throw new IllegalStateException();
		}
		int avail = (f + sz) % data.length; // use modular arithmetic
		data[avail] = e;
		sz++;
	}
	
	/* Returns, but does not remove, the first element of the queue (null if empty) */
	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return data[f];
	}

	/* Romoves and returns the first element of the queue */
	@Override
	public E dequeue() {
		if (isEmpty()) {
			return null;
		}
		E answer = data[f];
		data[f] = null;
		f = (f + 1) % data.length;
		sz--;
		return answer;
	}
	
}
