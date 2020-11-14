package Chapter9;

import java.util.Comparator;

import Chapter7.LinkedPositionalList;
import Chapter7.Position;
import Chapter7.PositionalList;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	// primary collection of priority queue entries
	private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

	// Creates an empty priority queue based on the natural ordering of its keys
	public UnsortedPriorityQueue() {
		super();
	}

	// Creates an empty priority queue using the given comparator to order keys
	public UnsortedPriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	// Returns the Position of an entry having minimal key
	private Position<Entry<K, V>> findMin() {
		Position<Entry<K, V>> small = list.first();
		for (Position<Entry<K, V>> walk : list.positions()) {
			if (compare(walk.getElement(), small.getElement()) < 0) {
				small = walk;
			}
		}
		return small;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	// Inserts a key-value pair and returns the entry created
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K, V> newest = new PQEntry<>(key, value);
		list.addLast(newest);
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		if (list.isEmpty()) return null;
		return findMin().getElement();
	}

	@Override
	public Entry<K, V> removeMin() {
		if (list.isEmpty()) return null;
		return list.remove(findMin());
	}

}
