package Chapter7;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	// instance variables
	public static final int CAPACITY = 16;
	private E[] data;
	private int size = 0;
	// constructors
	public ArrayList() { this(CAPACITY); };
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return data[i];
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}
	/* insert element to be at index i */
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size + 1);
		if (size == data.length) {
//			throw new IllegalStateException();
//			resize(2 * data.length);
//			resize4N();
			// for R_7_9
			resize(e, i, 2 * data.length);
		} else {
			for (int k = size - 1; k >= i; k--) {
				data[k + 1] = data[k];
			}
			data[i] = e;
		}
		size++;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k < size - 1; k++) {
			data[k] = data[k + 1];
		}
		data[size - 1] = null;
		size--;
		return temp;
	}
	// utility method
	/* Checks whether the given index is in the range [0, n - 1] */
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("Illegal index : " + i);
		}
	}
	
	/* Resizes internal array to have given capacity >= size */
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int k = 0; k < size; k++) {
			temp[k] = data[k];
		}
		data = temp;
	}
	/* nested ArrayIterator */
	private class ArrayIterator<E> implements Iterator<E>{
		private int j = 0; // index of the next element to report
		private boolean removable = false; // can remove be called at this time?
		
		@Override
		public boolean hasNext() {
			return j < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if (j == size) {
				throw new NoSuchElementException("No next element");
			}
			removable = true;
			return (E) data[j++];
		}
		
		public void remove() throws IllegalStateException{
			if (!removable) {
				throw new IllegalStateException("nothing to remove");
			}
			ArrayList.this.remove(j - 1); // that was the last time return
			j--; // next element has shifted one call to the left
			removable = false; // do not allow remove again until next is called
		}
	}
	/* end of nested ArrayIterator class */
	
	/* returns an iterator of the elements stored in the list */
	public Iterator<E> iterator(){
		return new ArrayIterator(); // create a new instance of the inner class
	}
	
	// exercises
	/* 使陣列大小符合目前所存的元素數量 */
	public void trimToSize() {
		if (data.length > size) {
			E[] temp = (E[]) new Object[size];
			for (int i = 0; i < size; i++) {
				temp[i] = data[i];
			}
			data = temp;
		}
    }
	protected void resize4N() {
		int x = (int) Math.round((double) size + (size / 4) + 0.5d); 
		E[] temp = (E[]) new Object[x];
		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	
	protected void resize(E e, int i, int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int k = 0; k < size; k++) {
			if (k == i) {
				temp[k] = e;
				temp[k + 1] = data[k];
			} else {
				temp[k] = data[k];
			}
		}
		data = temp;
	}
	
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (data[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(data[i])) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		this.size = 0;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArrayList [data=");
		builder.append(Arrays.toString(data));
		builder.append(", size=");
		builder.append(size);
		builder.append("]");
		return builder.toString();
	}
	
}
