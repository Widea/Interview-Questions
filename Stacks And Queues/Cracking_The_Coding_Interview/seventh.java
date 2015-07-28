import java.util.LinkedList;

/*
 * Cracking the coding interview 
 * Chapter: Stacks and Queues
 * Solution: 3.7
 * An animal shelter holds only dogs and cats, and operates on a
 * strictly "first in, first out" basis. People must adopt either 
 * the "oldest" (based on arrival time) of all animals at the shelter, 
 * or they can select whether they would prefer a dog or a cat 
 * (and will receive the oldest animal of that type). They cannot 
 * select which specific animal they would like. Create the data 
 * structures to maintain this system and implement operations such as 
 * enqueue, dequeueAny, dequeueDog and dequeueCat. 
 * You may use the built-in Linked List data structure.
 * Author: Viveka Aggarwal
 */

public class seventh {
	abstract class animal {
		int order;
		String name;
		
		public animal(String name) {
			this.name = name;
		}
		
		public void setOrder(int order) {
			this.order = order;
		}
		
		public int getOrder() {
			return this.order;
		}
		
		public boolean isOlderThan(animal a) {
			return order < a.getOrder();
		}
	}
	
	public class Cat extends animal {
		Cat(String name) {
			super(name);
			}
	}
	
	public class Dog extends animal {
		Dog(String name) {
			super(name);
			}
	}
	
	public class animalQueue {
		LinkedList<animal> Dogs;
		LinkedList<animal> Cats;
		private int order = 0;
		
		animalQueue() {
			Dogs = new LinkedList<animal>();
			Cats = new LinkedList<animal>();
		}
		
		public void enqueue(animal a) {
			a.setOrder(order);
			if(a instanceof Cat)
				Cats.addLast(a);
			if(a instanceof Dog)
				Dogs.addLast(a);
		}
		
		public animal dequeueAny() {
			
			if(Cats.isEmpty() && Dogs.isEmpty())
				return null;
			if(Cats.isEmpty())
				return Dogs.poll();
			if(Dogs.isEmpty())
				return Cats.poll();
			
			animal c = Cats.peek();
			animal d = Dogs.peek();
			
			if(c.isOlderThan(d))
				return dequeueCat();
			else 
				return dequeueDog();
		}
		
		public animal dequeueCat() {
			if(!Cats.isEmpty())
				return Cats.poll();
			else 
				return null;
		}
		
		public animal dequeueDog() {
			if(!Dogs.isEmpty())
				return Dogs.poll();
			else 
				return null;
		}
	}
}