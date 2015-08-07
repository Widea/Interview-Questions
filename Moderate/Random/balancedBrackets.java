import java.util.HashMap;
import java.util.Stack;

/*
 * Write a function that accepts a string consisting entering of brackets ([](){}) and 
 * returns whether it is balanced. Every "opening" bracket must be followed by a closing bracket of the same type. 
 * There can also be nested brackets, which adhere to the same rule.
 * f('()[]{}(([])){[()][]}') // true
 * f('())[]{}') // false
 * f('[(])') // false
 * Author : Viveka Aggarwal
 */

public class balancedBrackets {
	public static boolean isBalanced(String inp) {
		HashMap<Character, Character>  check = new HashMap<>();
		check.put('{', '}');
		check.put('[', ']');
		check.put('(', ')');
		Stack<Character> checker = new Stack<>();
		for(char c : inp.toCharArray()) {
			if(check.containsKey(c))
				checker.push(c);
			else if(!checker.isEmpty() && check.get(checker.peek()) == c)
				checker.pop();
			else return false;
		}
		
		return checker.isEmpty();
	}
	
	public static void main(String[] a) {
		System.out.println(isBalanced("()[]{}(([])){[()][]}"));
		System.out.println(isBalanced("())[]{}"));
		System.out.println(isBalanced("[(])"));
	}
}
