package Chapter6_Exercises;

import Chapter6.ArrayStack;
import Chapter6.Stack;

/**
 * What values are returned during the following series of stack operations, if
 * executed upon an initially empty stack? push(5), push(3), pop(), push(2),
 * push(8), pop(), pop(), push(9), push(1), pop(), push(7), push(6), pop(),
 * pop(), push(4), pop(), pop().
 */
public class R_6_3 {
	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayStack<>();
		stack.push(5);
		stack.push(3);
		System.out.println(stack.pop());
		stack.push(2);
		stack.push(8);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(9);
		stack.push(1);
		System.out.println(stack.pop());
		stack.push(7);
		stack.push(6);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}	
