// Source: http://www.careercup.com/question?id=5639512665358336 (Solution - 1)

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class T9Dictionary {

	Trie trie;

	public static void main (String [] args) {
		if (args.length != 1) {
			System.err.println("There should only be one and only one command line argument.");
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(args[0]));
		}
		catch (FileNotFoundException e) {
			System.err.println("File not found");
			return;
		}
		
		List<String> words = new ArrayList<String>();
		String str;
		try {
			while ((str = reader.readLine()) != null) {
				words.add(str.toLowerCase());
			}
		}
		catch (IOException e) {
			System.err.println("Some error while reading file");
			System.exit(1);
		}
		

		T9Dictionary t9Dict = new T9Dictionary();
		t9Dict.createTrie(words);

		System.out.println("Enter the numeric string to search: ");
		Scanner s = new Scanner(System.in);
		String numString = s.nextLine();

		List<String> suggestions = t9Dict.getSuggestions(numString);
		System.out.println("Suggestions: ");
		if (suggestions != null) {
			for (String word : suggestions) {
				System.out.print(word + "\t");
			}
		}
		else {
			System.out.println("No suggestions");
		}

	}

	public T9Dictionary() {
		trie = new Trie();
	}

	private void createTrie(List<String> words) {
		for (String word : words) {
			trie.add(word);
		}
	}

	// Returns the first three suggestion based on the string passed.
	public List<String> getSuggestions(String numString) {
		List<String> results = trie.search(numString);
		if (results != null) {
			return results.subList(0, Math.min(3, results.size()));
		}
		return null;
	}
}

class Trie {
	Node node;
	Trie[] children;

	// Create an empty trie
	Trie() {
		node = new Node();
		children = new Trie[8];
	}

	void add(String str) {
		char [] chrs = str.toCharArray();
		Trie node = this;
		for (int i = 0; i < chrs.length; i++) {
			int index = getNodeIndexFromChar(chrs[i]);
			if (node.children[index] == null) {
				node.children[index] = new Trie();
			}
			node = node.children[index];
		}
		node.node.addWord(str);
	}

	// The str passed should be a string with digits only between (2 to 9)
	List<String> search(String str) {
		System.out.println("Searching for " + str);
		List<String> list = null;
		Trie trie = this;
		char[] chrs = str.toCharArray();
		for (char chr : chrs) {
			if (chr < '2' || chr > '9') {
				System.err.println("Wrong search string: " + str);
				return null;
			}
			else {
				trie = trie.children[getNodeIndexFromNumChar(chr)];
				if (trie == null) {
					System.out.println("No matching string found.");
					return null;
				}
			}
		}
		if (!trie.node.isLeafNode()) {
			System.out.println("Node found but not a leaf node.");
		}
		else {
			PriorityQueue<Word> pq = trie.node.pq;
			list = new ArrayList<String>();
			List<Word> wordList = new ArrayList<Word>();
			int size = pq.size();
			for (int i = 0; i < 3 && i < size; i++) {
				Word word = pq.poll();
				list.add(word.word);
				wordList.add(word);
			}
			for (Word word : wordList) {
				pq.offer(word);
			}
		}
		return list;
	}

	 int getNodeIndexFromChar(char ch) {
	 	if (ch == 'a' || ch == 'b' || ch == 'c') {
	 		return 0;
	 	}
	 	if (ch == 'd' || ch == 'e' || ch == 'f') {
	 		return 1;
	 	}
	 	if (ch == 'g' || ch == 'h' || ch == 'i') {
	 		return 2;
	 	}
	 	if (ch == 'j' || ch == 'k' || ch == 'l') {
	 		return 3;
	 	}
	 	if (ch == 'm' || ch == 'n' || ch == 'o') {
	 		return 4;
	 	}
	 	if (ch == 'p' || ch == 'q' || ch == 'r' || ch == 's') {
	 		return 5;
	 	}
	 	if (ch == 't' || ch == 'u' || ch == 'v') {
	 		return 6;
	 	}
	 	if (ch == 'w' || ch == 'x' || ch == 'y' || ch == 'z') {
	 		return 7;
	 	}
	 	return -1;
	 }

	 int getNodeIndexFromNumChar(char chr) {
	 	return chr - '0' - 2;
	 }
}

class Node {
	public static WordComparator comp = new WordComparator();
	private boolean isLeaf;
	PriorityQueue<Word> pq;

	Node () {
		isLeaf = false;
	}

	public boolean isLeafNode() {
		return isLeaf;
	}

	public void addWord(String str) {
		if (this.isLeaf == false) {
			this.isLeaf = true;
			WordComparator comp = new WordComparator();
			pq = new PriorityQueue<Word>(10, comp);
		}
		// Check if the word is in the queue, if yes, increase its frequency
		Word w = new Word(str, 1);
		for (Word word : pq) {
			if (word.word.compareTo(str) == 0) {
				pq.remove(word);
				word.frequency++;
				w = word;
				break;
			}
		}
		pq.offer(w);
	}
}

class Word{
	int frequency;
	String word;

	Word (String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}
}

class WordComparator implements Comparator<Word>{
	public int compare(Word w1, Word w2) {
		return w2.frequency - w1.frequency;
	}
}
