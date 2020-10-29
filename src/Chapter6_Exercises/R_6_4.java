package Chapter6_Exercises;
import Chapter6.Stack;
/**
 * Implement a method with signature transfer(S, T) that transfers all elements
 * from stack S onto stack T, so that the element that starts at the top of S is
 * the first to be inserted onto T, and the element at the bottom of S ends up
 * at the top of T.
 */
public class R_6_4 {
	public <E> void transfer(Stack<E> S, Stack<E> T) {
		for (int i = 0; i < S.size(); i++) {
			T.push(S.pop());
		}
	}
	public static void main(String[] args) {
		
	}
}
