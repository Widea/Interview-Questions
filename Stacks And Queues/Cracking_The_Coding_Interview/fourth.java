import java.util.Stack;
/*
 * Cracking the coding interview 
 * Chapter: Stacks and Queues
 * Solution: 3.4
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks
 * of different sizes which can slide onto any tower. The puzzle starts with disks
 * sorted in ascending order of size from top to bottom (i.e., each disk sits
 * on top of an even larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next rod.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using Stacks.
 * Author: Viveka Aggarwal
 */

public class fourth {
	static class Tower {
		Stack<Integer> disks;
		int index;
		
		Tower(int index) {
			disks = new Stack<Integer>();
			this.index = index;
		}
		
		public int getIndex() {
			return index;
		}
		
		public void push(int disk) {
			if(!disks.isEmpty() && (disks.peek() <= disk))
				System.out.println("Disk cannot be placed in tower " +getIndex());
			else
				disks.push(disk);
		}
		
		public void moveTop(Tower des) {
			if(!disks.isEmpty()) {
				int top = disks.pop();
				des.push(top);
				System.out.println("Top disk moved from " +index +" tower to " +des.index +" tower");
			}
		}
		
		public void moveDisks(Tower des, Tower buffer, int n) {
			if(n > 0) {
				moveDisks(buffer, des, n-1); 
				moveTop(des);
				buffer.moveDisks(des, this, n-1); 
				}		
		}
		
		public static void main(String[] args) {
			Tower[] TOH = new Tower[3];
			for(int i = 0 ; i < 3 ; i++) {
				TOH[i] = new Tower(i+1);
			}
		
			TOH[0].push(4);
			TOH[0].push(3);
			TOH[0].push(2);
			TOH[0].push(1);
			
			System.out.println(TOH[0].disks.peek());
			System.out.println(TOH[1].disks.isEmpty());
			System.out.println(TOH[2].disks.isEmpty());
			
			TOH[0].moveDisks(TOH[2], TOH[1], 4);
			
			System.out.println(TOH[2].disks.peek());
			System.out.println(TOH[0].disks.isEmpty());
			System.out.println(TOH[1].disks.isEmpty());
			
			
		}
	}
}