package Chapter8;

import java.util.Iterator;

import Chapter7.Position;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	
	// nested Node class
	protected static class Node<E> implements Position<E>{
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		// constructor
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			this.element = e;
			this.parent = above;
			this.left = leftChild;
			this.right = rightChild;
		}
		// accessor methods
		public E getElement() {
			return element;
		}
		public Node<E> getParent(){
			return this.parent;
		}
		public Node<E> getLeft(){
			return this.left;
		}
		public Node<E> getRight(){
			return this.right;
		}
		
		// update methods
		public void setElement(E e) {
			this.element = e;
		}
		public void setParent(Node<E> parentNode) {
			this.parent = parentNode;
		}
		public void setLeft(Node<E> leftChild) {
			this.left = leftChild;
		}
		public void setRight(Node<E> rightChild) {
			this.right = rightChild;
		}
	}
	// end of nested Node class
	
	/* Factory function to create a new node storing element e */
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
		return new Node<E>(e, parent, left, right);
	}
	
	// LinkedBinaryTree instance variable
	protected Node<E> root = null;
	private int size = 0;
	
	// constructor
	public LinkedBinaryTree() {};
	
	// nonpublic utility
	/* Validates the position and returns it as a Node */
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException();
		}
		Node<E> node = (Node<E>) p;
		if (node.getParent() == node) {
			throw new IllegalArgumentException();
		}
		return node;
	}
	
	// accessor method (not already implemented in AbstractBinaryTree)
	/* Returns the number of nodes in the tree */
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Position<E> root() {
		return root;
	}
	
	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}
	
	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}
	
	// update methods supported by this class
	/* Places element at the root of an empty tree and returns its new Position */
	public Position<E> addRoot(E e) throws IllegalStateException{
		if (!isEmpty()) {
			throw new IllegalStateException("Tree is not Empty");
		}
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}
	
	/* Creates a new left child of Position p storing element e; returns its Position */
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if (parent.getLeft() != null) {
			throw new IllegalArgumentException();
		}
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		this.size++;
		return child;
	}
	
	/* Creates a new right child of Position p storing element e; returns its Position */
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if (parent.getRight() != null) {
			throw new IllegalArgumentException();
		}
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		this.size++;
		return child;
	}
	
	/* Replaces the element at Position p with e and returns the replaced element */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	
	/* Attaches trees t1 and t2 as left and right subtrees of external p */
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) {
		Node<E> node = validate(p);
		if (isInternal(p)) {
			throw new IllegalArgumentException("p must be a leaf");
		}
		size += t1.size() + t2.size();
		if (!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}
	
	/* Removes the node at Position p and replaces it with its child, if any */
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if (numChildren(p) == 2) {
			throw new IllegalArgumentException("p has two children");
		}
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if (child != null) {
			child.setParent(node.getParent());
		}
		if (node == root) {
			root = child;
		} else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		this.size--;
		E temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		return temp;
	}
	
	// nested ElemetIterator class
	/* This class adapts the iteration produced by positions() to return elements */
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = positions().iterator();

		public boolean hasNext() {
			return posIterator.hasNext();
		}

		@Override
		public E next() {
			return posIterator.next().getElement();
		}
		
		public void remove() {
			posIterator.remove();
		}
		
	}
	
	
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	@Override
	public Iterable<Position<E>> positions() {
		return null;
	}

}
