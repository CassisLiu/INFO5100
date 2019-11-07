package Assignment06.AlgoProblems;

public class MyHashMap<K, V> {
//		To be specific, your design should include these functions:
//
//		put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
//		get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
//		remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
//
//		Example:
//
//		MyHashMap hashMap = new MyHashMap();
//		hashMap.put(1, 1);          
//		hashMap.put(2, 2);         
//		hashMap.get(1);            // returns 1
//		hashMap.get(3);            // returns -1 (not found)
//		hashMap.put(2, 1);          // update the existing value
//		hashMap.get(2);            // returns 1 
//		hashMap.remove(2);          // remove the mapping for 2
//		hashMap.get(2);            // returns -1 (not found) 
//
//		Note:
//
//		All keys and values will be in the range of [0, 1000000].
//		The number of operations will be in the range of [1, 10000].
//		Please do not use the built-in HashMap library.
	private static final int initialCapacity = 1 << 4;
	private Entry<K, V>[] buckets;
	private int size = 0;
	public MyHashMap() {
		this(initialCapacity);
	}
	public MyHashMap(int capacity) {
		this.buckets = new Entry[capacity];
	}
	
	public void put(K key, V value) {
		Entry<K, V> entry = new Entry(key, value, null);
		
		int bucket = hashCode(key) % buckets.length;
		
		Entry<K, V> existing = buckets[bucket];
		if(existing == null) {
			buckets[bucket] = entry;
			size++;
		} else {
			// compare the keys see if key already existed
			while(existing.next != null) {
				if(existing.key == key) {
					existing.value = value;
					return ;
				}
				existing = existing.next;
			}
			// 要剩下最后一个node 和key比较是否想同 相同的话更新value, 不同的话把新的node加到最后
			if(existing.key.equals(key)) {
				existing.value = value;
			} else {
				existing.next = entry;
				size++;
			}
		}
	}	
	
	private int hashCode(K key) {
		// TODO Auto-generated method stub
		int hash = Integer.valueOf((String)key);
		return hash;
	}
	
	
}

class Entry<K, V> {
	final K key;
	V value;
	Entry<K, V> next;
	public Entry(K key, V value, Entry<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
}


