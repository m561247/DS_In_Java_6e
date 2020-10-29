package Chapter6;

import Chapter3.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();

	public LinkedStack() {};

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(E element) {
		list.addFirst(element);
	}

	@Override
	public E top() {
		return list.first();
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}
	
	/* Test if delimiters in the given expression are properly matched */
	public static boolean isMatched(String expression) {
		final String opening = "({[";
		final String closing = ")}]";
		Stack<Character> buffer = new LinkedStack<>();
		for (char c : expression.toCharArray()) {
			if (opening.indexOf(c) != -1) {
				buffer.push(c);
			} else if (closing.indexOf(c) != -1) {
				if (buffer.isEmpty()) {
					return false;
				} else if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
					return false;
				}
			}
		}
		return buffer.isEmpty();
	}
	
	/* Tests if every opening tag has a matching closing tag in HTML string */
	public static boolean isHTMLMatched(String html) {
		Stack<String> buffer = new LinkedStack<>();
		int j = html.indexOf('<');
		while (j != -1) {
			int k = html.indexOf('>', j + 1);
			if (k == -1) {
				return false;
			}
			String tag = html.substring(j + 1, k);
			if (!tag.startsWith("/")) {
				buffer.push(tag);
			} else {
				if (buffer.isEmpty()) {
					return false;
				}
				if (!tag.substring(1).equals(buffer.pop())) {
					return false;
				}
			}
			j = html.indexOf('<', k + 1);// 從 k + 1 的位置繼續找下一個 '<'，回傳其索引值 
		}
		return buffer.isEmpty();
	}
	public static void main(String[] args) {
		String html = "<body>\r\n" + 
				"<center>\r\n" + 
				"<h1> The Little Boat </h1>\r\n" + 
				"</center>\r\n" + 
				"<p> The storm tossed the little\r\n" + 
				"boat like a cheap sneaker in an\r\n" + 
				"old washing machine. The three\r\n" + 
				"drunken fishermen were used to\r\n" + 
				"such treatment, of course, but\r\n" + 
				"not the tree salesman, who even as\r\n" + 
				"a stowaway now felt that he\r\n" + 
				"had overpaid for the voyage. </p>\r\n" + 
				"<ol>\r\n" + 
				"<li> Will the salesman die? </li>\r\n" + 
				"<li> What color is the boat? </li>\r\n" + 
				"<li> And what about Naomi? </li>\r\n" + 
				"</ol>\r\n" + 
				"</body>\r\n" + 
				"The Little Boat\r\n" + 
				"The storm tossed the little boat\r\n" + 
				"like a cheap sneaker in an\r\n" + 
				"old washing machine. The three\r\n" + 
				"drunken fishermen were used to\r\n" + 
				"such treatment, of course, but not\r\n" + 
				"the tree salesman, who even as\r\n" + 
				"a stowaway now felt that he had\r\n" + 
				"overpaid for the voyage.\r\n" + 
				"1. Will the salesman die?\r\n" + 
				"2. What color is the boat?\r\n" + 
				"3. And what about Naomi?";
		System.out.println(isHTMLMatched(html));
	}
}
