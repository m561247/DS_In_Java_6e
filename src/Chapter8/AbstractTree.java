package Chapter8;

import java.util.ArrayList;
import java.util.List;

import Chapter6.LinkedQueue;
import Chapter6.Queue;
import Chapter7.Position;

public abstract class AbstractTree<E> implements Tree<E> {
	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}

	public boolean isExternal(Position<E> p) {
		return numChildren(p) == 0;
	}

	public boolean isRoot(Position<E> p) {
		return p == root();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int depth(Position<E> p) {
		if (isRoot(p)) {
			return 0;
		} else {
			return 1 + depth(parent(p));
		}
	}

	/* Returns the height of the tree */
	private int heightBad() {
		int h = 0;
		for (Position<E> p : positions()) {
			if (isExternal(p)) {
				h = Math.max(h, depth(p));
			}
		}
		return h;
	}

	/* Returns the height of the subtree rooted at Position p */
	public int height(Position<E> p) {
		int h = 0;
		for (Position<E> c : children(p)) { // base case if p is external
			h = Math.max(h, 1 + height(c));
		}
		return h;
	}

	// preorder
	/* Adds positions of the subtree rooted at Position p to the given snapshot */
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p); // for preorder, we add position p before exploring subtree
		for (Position<E> c : children(p)) {
			preorderSubtree(c, snapshot);
		}
	}

	/*
	 * Returns an iterable collection of positions of the tree, reported in preorder
	 */
	public Iterable<Position<E>> preorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			preorderSubtree(root(), snapshot);
		}
		return snapshot;
	}

	// postorder
	/* Adds positions of the subtree rooted at Position p to the given snapshot */
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		for (Position<E> c : children(p)) {
			postorderSubtree(c, snapshot);
		}
		snapshot.add(p);
	}

	/*
	 * Returns an iterable collection of positions of the tree, reported in
	 * postorder
	 */
	public Iterable<Position<E>> postorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			postorderSubtree(root(), snapshot);
		}
		return snapshot;
	}

	// breadth-first order
	/*
	 * Returns an iterable collection of positions of the tree in breadth-first
	 * order
	 */
	public Iterable<Position<E>> breadthfirst() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			Queue<Position<E>> fringe = new LinkedQueue<>();
			fringe.enqueue(root());
			while (!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue();
				snapshot.add(p);
				for (Position<E> c : children(p)) {
					fringe.enqueue(c);
				}
			}
		}
		return snapshot;
	}

	// Print preorder
	/* print preorder representation of subtree of T rooted at p having depth d */
	public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d) {
		System.out.println(spaces(2 * d) + p.getElement());
		for (Position<E> c : T.children(p)) {
			printPreorderIndent(T, c, d + 1);
		}
	}

	/* Prints lableed representation of subtree of T rooted at p having depth d */
	public static <E> void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path) {
		int d = path.size();
		System.out.print(spaces(2 * d)); // 縮排
		for (int j = 0; j < d; j++) {
			System.out.print(path.get(j) + (j == d - 1 ? " " : "."));
		}
		System.out.println(p.getElement());
		path.add(1);
		for (Position<E> c : T.children(p)) {
			printPreorderLabeled(T, c, path);
			path.set(d, 1 + path.get(d));
		}
		path.remove(d);

	}

	// computing disk space postorder
	/* Returns total disk space for subtree of T rooted at p */
	public static int diskSpace(Tree<Integer> T, Position<Integer> p) {
		int subtotal = p.getElement();
		for (Position<Integer> c : T.children(p)) {
			subtotal += diskSpace(T, c);
		}
		return subtotal;
	}

	// Parenthetic Representations of a Tree
	/* Prints parenthesized representation of T rooted at p */
	public static <E> void parenthesize(Tree<E> T, Position<E> p) {
		System.out.println(p.getElement());
		if (T.isInternal(p)) {
			boolean firstTime = true;
			for (Position<E> c : T.children(p)) {
				System.out.println(firstTime ? " (" : ", ");
				firstTime = false;
				parenthesize(T, c);
			}
			System.out.println(")");
		}
	}

	// inorder draw binary tree
	
	// fake interface for geometric layout problem
	public interface Geometric {
		public void setX(int x);
		public void setY(int y);
	}
	/* The initial call should be layout(T, T.root( ), 0, 0). */
	public static <E extends Geometric> int layout(BinaryTree<E> T, Position<E> p, int d, int x) {
		if (T.left(p) != null) { // 找到最左下的 node
			x = layout(T, T.left(p), d + 1, x);
		}
		p.getElement().setX(x++);
		p.getElement().setY(d);
		if (T.right(p) != null) {
			x = layout(T, T.right(p), d + 1, x);
		}
		return x;
	}

	/** Returns a string containing n spaces. */
	public static String spaces(int n) {
		return dsaj.asymptotics.StringExperiment.repeat2(' ', n);
	}
}
