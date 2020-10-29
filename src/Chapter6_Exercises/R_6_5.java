package Chapter6_Exercises;
import Chapter6.LinkedStack;
import Chapter6.Stack;

/**
 * Give a recursive method for removing all the elements from a stack.
 * @param <E>
 */
public class R_6_5<E> {
	public static Stack<Integer> reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return stack;
		}
		System.out.println(stack.top());
		stack.pop();
		return reverse(stack);
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new LinkedStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(reverse(stack));
	}
}
