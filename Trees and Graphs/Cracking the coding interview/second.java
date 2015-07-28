import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Cracking the coding interview
 * Chapter : Trees and Graphs
 * Question: 4.2
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * Author : Viveka Aggarwal
 */

public class second {
	private int size;
	private node[] vertices;
	int max;
	
	second() {
		size = 0;
		max = 20;
		vertices = new node[max];
	}
	
	second(int inp) {
		this.size = 0;
		max = inp;
		vertices = new node[max];
	}
	
	int getSize() {
		return this.size;
	}
	
	node[] getVertices() {
		return vertices;
	}
	
	void addVertice(node in) {
		if(size >= max) {
			System.out.println("Graph full");
			return;
		}	
		vertices[size] = in;
		size++;
	}
	
	public static class node {
		String vertex;
		ArrayList<node> adjacent;
		public State state;				
		
		node() {
			vertex = "";
			adjacent = new ArrayList<>();
		}
		
		node(String vertex) {
			this.vertex = vertex;
			adjacent = new ArrayList<>();
		}
		
		void addAdjacent(node adj) {
			this.adjacent.add(adj);
		}
		
		node[] getAdjacent() {
			node[] adj = adjacent.toArray(new node[adjacent.size()]);
			return adj;
		}
		
		String getVertex() {
			return this.vertex;
		}		
	}
	
	static enum State {
		Visited, Unvisited, Visiting;
	}
	
	public boolean isConnected(node start,node end) {
		Queue<node> q = new LinkedList<node>();
		
		for(node n : this.getVertices())
			n.state = State.Unvisited;
		
		node temp;
		q.add(start);
		start.state = State.Visiting;
		
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp != null) {
				for(node n : temp.getAdjacent()) {					
					if(n.state == State.Unvisited) {
						if(n == end)
							return true;
						
						n.state = State.Visiting;
						q.add(n);
					}
				}
				temp.state = State.Visited;
			}
		}
		
		return false;
	}
	
	public static void main(String args[])
	{
		node[] temp = new node[6];
		second g = new second(6);
		
		temp[0] = new node("a");
		temp[1] = new node("b");
		temp[2] = new node("c");
		temp[3] = new node("d");
		temp[4] = new node("e");
		temp[5] = new node("f");
		
		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
	
		temp[1].addAdjacent(temp[3]);
		
		temp[3].addAdjacent(temp[2]);
		
		temp[3].addAdjacent(temp[4]);
		temp[2].addAdjacent(temp[5]);
		
		temp[4].addAdjacent(temp[5]);

		temp[5].addAdjacent(temp[2]);
		
		for(int i = 0 ; i < 6 ; i++){
			g.addVertice(temp[i]);
		}		
	
		System.out.println(g.isConnected(temp[1], temp[2]));
		System.out.println(g.isConnected(temp[2], temp[1]));

	}
	
}
