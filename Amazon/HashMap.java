import java.util.Arrays;

// Program to implement a hash map, with o(1) get and add time!

public class HashMap {
	class Entry {
		int key;
		int value;
		//long timeStamp;
		Entry next;
		
		Entry(int key, int value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}
	
	Entry[] map;
	double loadFactor;
	private int size;
	
	HashMap() {
		map = new Entry[16];
		Arrays.fill(map, null);
		loadFactor = 0.75;
		size = 0;
	}
	
	HashMap(int capacity, int loadFactor) {
		map = new Entry[capacity];
		Arrays.fill(map, null);
		this.loadFactor = loadFactor;
		size = 0;
	}
	
	public void put(int key, int value) {
		// resize if the map reaches the threshold
		if(size == loadFactor * map.length ) {
			resize();
		}
		
		Entry curr = new Entry(key, value);
		int index = getHash(key);
		if(map[index] == null) {
			map[index] = curr;
			size++;
		} else {
			Entry iterator = map[index];
			while(iterator.next != null) {
				if(iterator.key == curr.key) {
					iterator.value = curr.value;
					break;
				} else {
					iterator = iterator.next;	
				}
			}	
			
			if(iterator.next == null) {
				if(iterator.key == key) {
					iterator.value = value;
				} else {
					iterator.next = curr;
					size++;
				}
			}	
			
		}
	}
	
	public int length() {
		return size;
	}
	
	int get(int key) {
		int index = getHash(key);
		if(map[index] == null) {
			System.out.println("Key doesn't exist in the map");
			return -1;
		}

		Entry iterator = map[index];

		
		if(iterator.key == key) {
			return iterator.value;
		} 
		
		while(iterator.next != null) {
			if(iterator.key == key) {
				return iterator.value;
			}
			iterator = iterator.next;
		}
		
		System.out.println("Key doesn't exist in the map");
		return -1;	
	}
	
	
	void resize() {
		System.out.println("Array is being resized! Reached load factor of " +size +" elements...");
		int new_length = map.length * 2;
		Entry[] newMap = new Entry[new_length];
		
		for(int i = 0 ; i < map.length ; i++) {
			newMap[i] = map[i];
		}
		map = newMap;
	}
	
	int getHash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		int hashCode = h ^ (h >>> 7) ^ (h >>> 4);
	    return hashCode % map.length;
	}
	
	public static void main(String[] args) {
		HashMap hashMap = new HashMap();
	    hashMap.put(10, 20);
	    hashMap.put(20, 11);
	    hashMap.put(21, 1);
	    hashMap.put(20, 10);

	    int value = hashMap.get(20);
	    
	    System.out.println(value);
	}
}
