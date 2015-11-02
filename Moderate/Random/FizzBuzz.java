/*
 * Program to illustrate the famous interview problem "FizzBuzz"
 * Problem statement: 
 * write a program which return "fizz" if number is multiplier of 3, return "buzz" if its 
 * multiplier of 5 and return "fizzbuzz" if number is divisible by both 3 and 5. 
 * If number is not divisible by either 3 or 5 then it should just return the number itself.
 */

public class FizzBuzz {
	static void printFizzBuzz(int in) {
		for(int i = 1 ; i <= in; i++) {
			if(i % 15 == 0)
				System.out.print("fizzbuzz ");
			else if(i % 3 == 0)
				System.out.print("fizz ");
			else if(i % 5 == 0)
				System.out.print("buzz ");
			else
				System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		printFizzBuzz(50);
	}
}
