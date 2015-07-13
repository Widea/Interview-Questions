// hashmap implementation using arrays

public class HashMap {
    double loadFactor = 0.75;
    HashEntry[] table;
    private int elemCount;
    
    HashMap() {
    	table = new HashEntry[5];
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    public void put(int key, int value) {
    	if (elemCount == (int)(loadFactor*table.length)) {
    	    resize();
    	}
        int index = getHash(key);
        HashEntry hashEntry = new HashEntry(key, value);
        if (table[index] == null) {
            table[index] = hashEntry;
            elemCount++;
        } else {
            HashEntry runner = table[index];
            while (runner.next != null) {
                if (runner.key == hashEntry.key) {
                    runner.value = hashEntry.value;
                    break;
                } else {
                    runner = runner.next;
                }
            }
            if (runner.next == null) {
                if (runner.key == hashEntry.key) {
                    runner.value = hashEntry.value;
                } else {
                    runner.next = hashEntry;
                    elemCount++;
                }
            }
        }
    }
    
    public void resize() {
    	System.out.println("Array is being resized! Reached load factor of " +elemCount +" elements...");    	int newLength = table.length * 2;
    	
    	HashEntry[] newTable = new HashEntry[newLength];
    	for(int i = 0; i < table.length ; i++) {
    		newTable[i] = table[i];
    	}
    	
    	table = newTable;
    }

    public int get(int key) {
        int index = getHash(key);
        if (table[index] == null) {
            return -1;
        } else {
            HashEntry runner = table[index];
            if (runner.key == key) {
                return runner.value;
            }
            while (runner.next != null) {
                if (runner.key == key) {
                    return runner.value;
                }
            }
            return -1;
        }
    }

    public int getHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        int hashCode = h ^ (h >>> 7) ^ (h >>> 4);
        return hashCode % table.length;
    }


class HashEntry {
    int key;
    int value;
    HashEntry next = null;

    public HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }
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
