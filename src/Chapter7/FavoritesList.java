package Chapter7;

import java.util.Iterator;

public class FavoritesList<E> {
	// nested Item class
	protected static class Item<E> {
		private E value;
		private int count = 0;

		public Item(E val) {
			this.value = val;
		}

		public int getCount() {
			return this.count;
		}

		public E getValue() {
			return this.value;
		}

		public void increment() {
			this.count++;
		}
	}
	// end of nested Item class

	PositionalList<Item<E>> list = new LinkedPositionalList<>();

	public FavoritesList() {
	};

	// nonpublic utilities
	protected E value(Position<Item<E>> p) {
		return p.getElement().getValue();
	}

	protected int count(Position<Item<E>> p) {
		return p.getElement().getCount();
	}

	protected Position<Item<E>> findPosition(E e) {
		Position<Item<E>> walk = list.first();
		while (walk != null && !e.equals(value(walk))) {
			walk = list.after(walk);
		}
		return walk;
	}

	/* Moves item at Position p earlier in the list based on access count */
	protected void moveUp(Position<Item<E>> p) {
		int cnt = count(p); // count 數比較大就丟到前面，一樣大不動
		Position<Item<E>> walk = p;
		while (walk != list.first() && count(list.before(walk)) < cnt) {
			walk = list.before(walk);
		}
		if (walk != p) {
			list.addBefore(walk, list.remove(p));
		}
	}

	// public methods
	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void access(E e) {
		Position<Item<E>> p = findPosition(e);
		if (p == null) {
			p = list.addLast(new Item<E>(e));
		}
		p.getElement().increment();
		moveUp(p);
	}

	public void remove(E e) {
		Position<Item<E>> p = findPosition(e);
		if (e != null) {
			list.remove(p);
		}
	}
	
	public Iterable<E> getFavorites(int k) throws IllegalArgumentException{
		if (k < 0 || k > size()) {
			throw new IllegalArgumentException("Invalid k");
		}
		PositionalList<E> result = new LinkedPositionalList<>();
		Iterator<Item<E>> iter = list.iterator();
		for (int j = 0; j < k; j++) {
			result.addLast(iter.next().getValue());
		}
		return result;
	}
}
