package Chapter10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap;
import java.util.Map.Entry;
public class HashMultimap<K, V> {
	Map<K, List<V>> map = new HashMap<>(); // the primary map
	int total = 0; // total number of entries in the multimap
	
	// Constructor
	public HashMultimap() {
	}

	// Returns the total number of entries in the mulitmap
	public int size() {
		return total;
	}
	
	// Returns whether the multimap is empty
	public boolean isEmpty() {
		return total == 0;
	}
	
	// Returns a (possibly empty) iteration of all values associated with the key
	Iterable<V> get(K key) {
		List<V> secondary = map.get(key);
		if (secondary != null) {
			return secondary;
		}
		return new ArrayList<>();
	}
	
	// Adds a new entry associating key with value
	void put(K key, V value) {
		List<V> secondary = map.get(key);
		if (secondary == null) {
			secondary = new ArrayList<>();
			map.put(key, secondary);
		}
		secondary.add(value);
		total++;
	}
	
	// Removes the (key, value) entry, if it exists
	boolean remove(K key, V value) {
		boolean wasRemoved = false;
		List<V> secondary = map.get(key);
		if (secondary != null) {
			wasRemoved = secondary.remove(value);
			if (wasRemoved) {
				total--;
				if (secondary.isEmpty()) {
					map.remove(key);
				}
			}
		}
		return wasRemoved;
	}
	
	Iterable<V> removeAll(K key) {
		List<V> secondary = map.get(key);
		if (secondary != null) {
			total -= secondary.size();
			map.remove(key);
		} else {
			secondary = new ArrayList<>();
		}
		return secondary;
	}
	
	// Returns an iteration of all entries in the multimap
	Iterable<Map.Entry<K, V>> entries() {
		List<Map.Entry<K, V>> result = new ArrayList<>();
		for (Map.Entry<K, List<V>> secondary : map.entrySet()) {
			K key = secondary.getKey();
			for (V value : secondary.getValue()) {
				result.add(new AbstractMap.SimpleEntry<K, V>(key, value));
			}
		}
		return result;
	}
}
