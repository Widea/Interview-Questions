// program to implement a simple trie data structure
// implements addWord, searchWord, printTree methods. 

public class trie {
	trieNode root;
	
	public trie(){
		root = new trieNode();
	}
	
	//subtracting from 97 'cause that's the ASCII value of 'a'
	public void insertWord(String word) {
		char[] input = word.toLowerCase().toCharArray();
		int l = word.length();		
		trieNode cur = root;
		
		for(int i = 0; i < l ; i++) {
			if(cur.links[input[i] - 97] == null) {
			   cur.links[input[i] - 97] = new trieNode(input[i], i == l-1? true:false);   
			}
			cur = cur.links[input[i] - 97];				
		}
	}
	
	public boolean isPresent(String word) {
		char[] letters = word.toLowerCase().toCharArray();
		trieNode cur = root;
		int i;
		for(i = 0; i < word.length() ; i++) {
			if(cur.links[letters[i] - 97] == null)
				return false;
			cur = cur.links[letters[i] - 97];
		}
				
		if (cur != null && cur.isWord == true)
            return true;
        
        return false;
	}
	
	static class trieNode {
		char letter;
		trieNode[] links;
		boolean isWord;
		
		trieNode() {
			letter = '\0';
			links = new trieNode[26];
			isWord = false;
		}
		
		trieNode(char letter, boolean isWord) {
			this.letter = letter;
			links = new trieNode[26];
			this.isWord = isWord;
		}
	}
	
	 public static void main(String[] args)
	    {
	        trie tree = new trie();
	        
	        String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
	        for (int i = 0; i < words.length; i++)
	            tree.insertWord(words[i]);
	        
	    //    char[] branch = new char[50];
	    //    printTree(tree, 0, branch);
	        
	        String searchWord = "all";
	        if (tree.isPresent(searchWord))
	        {
	            System.out.println("The word was found");
	        }
	        else
	        {
	            System.out.println("The word was NOT found");
	        }
	    }
	
	
}
