// Reference : http://www.careercup.com/question?id=14113740

import java.util.HashMap;

public class LRUCache {

	class Node{
		int key;
		int data;
		Node prev=null;
		Node next =null;
		public Node(int key, int data){
			this.data = data;
			this.key = key;
		}

		public int getKey(){
			return key;
		}
	}

	Node head = null;
	Node end = null;
	int capacity;
	int len=0;
	HashMap<Integer, Node> hm = new HashMap<Integer, Node>();

	public LRUCache(int capacity){
		this.capacity = capacity;
	}

	public void setValue(int key, int value){
		if(hm.containsKey(key)){
			Node n = hm.get(key);
			n.data = value;
			remove(n);
			setHead(n);
		}else{
			if(len<capacity){
				Node n= new Node(key, value);
				setHead(n);
				len = len+1;
				hm.put(key, n);
			}else{
				hm.remove(end.key);
				remove(end);
				Node n = new Node(key,value);
				setHead(n);
				hm.put(key, n);
			}
		}
	}
	public int getValue(int key){
		if(hm.containsKey(key)){
			Node n = hm.get(key);
			remove(n);
			setHead(n);
			return n.data;
		}
		return -1;
	}
	
	private void setHead(Node n){
		if(head == null){
			head = n;
			end =n;
		}else{
			head.prev = n;
			n.next = head;
			head = n;
		}
	}
	private void remove(Node n){
		Node pre = n.prev;
		Node post = n.next;
		if(pre==null)
			head = post;
		else
			pre.next = post;

		if(post == null)
			end = pre;
		else
			post.prev=pre;
	}
}
