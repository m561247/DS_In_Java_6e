package Chapter8;


import java.util.ArrayList;
import java.util.List;

import Chapter7.Position;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
	public Position<E> sibling(Position<E> p){
		Position<E> parent = parent(p);
		if (parent == null) { // p must be the root
			return null;
		}
		if (p == left(parent)) { // p is a left child
			return right(parent); // (right child migtht be null)
		} else { // p is a right child
			return left(parent); // left child might be null
		}
	}
	/* Return the numbers of children of p */
	public int numChildren(Position<E> p) {
		int count = 0;
		if (left(p) != null) {
			count++;
		}
		if (right(p) != null) {
			count++;
		}
		return count;
	}
	/* Returns an iterable collection of the Position representing p's children */
	public Iterable<Position<E>> children(Position<E> p){
		List<Position<E>> snapshot = new ArrayList<>(2);
		if (left(p) != null) {
			snapshot.add(left(p));
		}
		if (right(p) != null) {
			snapshot.add(p);
		}
		return snapshot;
	}
	
	//inorder
	/* Adds positions of the subtree rooted at Position p to the given snapshot */
	private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		if (left(p) != null) {
			inorderSubtree(left(p), snapshot);
		}
		snapshot.add(p);
		if (right(p) != null) {
			inorderSubtree(right(p), snapshot);
		}
	}
	/* Returns an iterable collection of positions of the tree, reported inorder */
	public Iterable<Position<E>> inorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			inorderSubtree(root(), snapshot);
		}
		return snapshot;
	}
	/* Overrides positions to make inorder the default order for binary trees */
	public Iterable<Position<E>> positions(){
		return inorder();
	}
}
