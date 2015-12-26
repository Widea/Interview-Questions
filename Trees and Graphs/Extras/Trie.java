// Program to implement a simple trie data structure
// Implements addWord, searchWord, printTree methods. 
// For the purpose of this program we only consider words with all small case.

public class Trie {
	node root;
	
	Trie() {
		root = new node();
	}
	
	void insertWord(String word) {
		char[] input_word = word.toLowerCase().toCharArray();
		int l = input_word.length;
		node ptr = root;
		
		for(int i = 0 ; i < l ; i++) {
			char curr = input_word[i];
			if(ptr.links[curr - 97] == null)
				ptr.links[curr - 97] = new node(curr, i == l-1? true : false);
				
			ptr = ptr.links[curr - 97];
		}
	}
	
	void insertWords(String[] words) {
		if(words == null || words.length == 0)
			return;
		
		for(int i = 0 ; i < words.length ; i++) {
			insertWord(words[i]);
		}
	}
	
	boolean isPresent(String word) {
		if(root == null || word == null || word.length() == 0 )
			return false;
		node curr = root;
		char[] check_word = word.toLowerCase().toCharArray();
		int len = check_word.length;
		
		for(int i = 0 ; i < len ; i++) {
			if(curr.links[check_word[i] - 97] == null)
				return false;
			curr = curr.links[check_word[i] - 97];
		}
		
		if(curr != null && curr.is_word) {
			return true;
		}
		
		return false;
	}
	
	void print() {
		print(root, 0, new char[50]);
	}
	
	void print(node curr, int level, char[] word) {
		if(curr == null)
			return;
		
		for(int i = 0 ; i < curr.links.length; i++) {
			word[level] = curr.letter;
			print(curr.links[i], level+1, word);
		} 
		
		if(curr.is_word) {
			for(int i = 1 ; i <= level; i++) {
				System.out.print(word[i]);
			}
			System.out.println();
		}
	}
	
	class node {
		char letter;
		boolean is_word;
		node[] links;
		
		node() {
			letter = '\0';
			is_word = false;
			links = new node[26];
		}
		
		node(char letter, boolean is_word) {
			this.letter = letter;
			this.is_word = is_word;
			links = new node[26];
		}
	}
	
	public static void main(String[] a) {
		Trie trie = new Trie();
		trie.insertWord("apple");
		trie.insertWord("orange");
		trie.insertWords(new String[]{"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"});
		
		trie.print();
		
		System.out.println(trie.isPresent("Apple"));
		System.out.println(trie.isPresent("Viveka"));
		System.out.println(trie.isPresent("ANty"));
		
	}
}
