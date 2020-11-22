package Chapter10;

import java.util.Iterator;

import Chapter9.Entry;

public class AbstractMap<K, V> implements Map<K, V> {
	//-------------------- nested MapEntry class ----------------
	protected static class MapEntry<K, V> implements Entry<K, V> {
		private K k;
		private V v;
		
		public MapEntry(K key, V value) {
			k = key;
			v = value;
		}
		
		protected void setKey(K key) {
			k = key;
		}
		
		protected V setValue(V value) {
			V old = v;
			v = value;
			return old;
		}
		
		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}
		
	}
	//---------------- end of nested MapEntry class --------------
	
	// Support for public ketSet method
	private class KeyIterator implements Iterator<K> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator();
		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}

		@Override
		public K next() {
			return entries.next().getKey();
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private class KeyIterable implements Iterable<K> {

		@Override
		public Iterator<K> iterator() {
			return new KeyIterator();
		}
		
	}

	// Support for public values methods
	private class ValueIterator implements Iterator<V> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator();
		
		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}

		@Override
		public V next() {
			return entries.next().getValue();
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	
	private class ValueIterable implements Iterable<V> {

		@Override
		public Iterator<V> iterator() {
			return new ValueIterator();
		}
		
	}
	
	public Iterable<V> values(){
		return new ValueIterable();
	}
	
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public V get(K key) {
		return null;
	}

	@Override
	public V put(K key, V value) {
		return null;
	}

	@Override
	public V remove(K key) {
		return null;
	}

	@Override
	public Iterable<K> keySet() {
		return new KeyIterable();
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		return null;
	}
	
}
