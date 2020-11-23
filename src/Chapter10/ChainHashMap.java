package Chapter10;

import java.util.ArrayList;

import Chapter9.Entry;

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
	// a fixed capacity array of UnsortedTableMap that serve as buckets
	private UnsortedTableMap<K, V>[] table;

	public ChainHashMap() {
		super();
	}

	public ChainHashMap(int cap) {
		super(cap);
	}
	
	public ChainHashMap(int cap, int p) {
		super(cap, p);
	}

	@Override
	protected void createTable() {
		table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
	}

	// Returns value associated with key k in bucket with hash value h, or else null
	@Override
	protected V bucketGet(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null) return null;
		return bucket.get(k);
	}
	
	// Associates key k with value v in bucket with hash value h; returns old value
	@Override
	protected V bucketPut(int h, K k, V v) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null) {
			bucket = table[h] = new UnsortedTableMap<>();
		}
		int oldSize = bucket.size();
		V answer = bucket.put(k, v);
		n += (bucket.size() - oldSize);
		return answer;
	}

	// Removes entry having key k from bucket with hash value h (if any)
	@Override
	protected V bucketRemove(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null) return null;
		int oldSize = bucket.size();
		V answer = bucket.remove(k);
		n -= (oldSize - bucket.size());
		return answer;
	}
	
	// Returns an iterable collection of all key-value entries of the map
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>();
		for (int h = 0; h < capacity; h++) {
			if (table[h] != null) {
				for (Entry<K, V> entry : table[h].entrySet()) {
					buffer.add(entry);
				}
			}
		}
		return buffer;
	}
	
}
