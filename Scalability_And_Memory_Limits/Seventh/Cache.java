import java.util.HashMap;

// Program to implement a simple cache data structure, which is going to store
// the most recently used 10 Strings or a user specified capacity. 
// For the strings to be same, the characters in the string should be exactly same
// The comparison being case insensitive. 
// Since for a cache system it is important to have ease of access in terms of inputting 
// the string and removal of the same, we are going to use linked list. 
// For the purpose of ease of querying the cache, we are going to use a hash table, of these nodes. 

public class Cache {
	node start, end;
	HashMap<String, node> map;
	int capacity;
	
	Cache() {
		capacity = 10;
		map = new HashMap<>();
	}
	
	Cache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}
	
	void moveToFront(node input) {
		if(input == null)
			return;
		
		remove(input);
		
		input.next = start;
		if(start != null)
			start.prev = input;
		start = input;
		
		if(end == null)
			end = input;
	}
	
	void remove(node input) {
		if(input == null)
			return;
		
		if(input.prev != null)
			input.prev = input.next;
		
		if(input.next != null) 
			input.next.prev = input.prev;
		
		if(input == start)
			start = input.next;
		
		if(input == end) 
			end = input.prev;
		
		input.next = input.prev = null;
	}
	
	String[] getResults(String query) {
		if(map.containsKey(query)) {
			node curr = map.get(query);
			moveToFront(curr);
			return curr.results;
		}
		
		return null;
	}
	
	void insert(String query, String[] results) {
		if(query == null)
			return;

		if(map.containsKey(query)) {
			node curr = map.get(query);
			curr.results = results;
			moveToFront(curr);
			return;
		}
		
		node new_node = new node(query, results);
		moveToFront(new_node);
		map.put(query, new_node);
		
		if(map.size() > capacity) {
			remove(end);
			map.remove(end.query);
		}		
	}
	
	class node {
		String query;
		String[] results;
		node prev;
		node next;
		
		node(String query, String[] results) {
			this.query = query;
			this.results = results;
		}
	}
}
