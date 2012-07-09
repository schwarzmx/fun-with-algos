package schwarzmx.trees;

public class BinarySearchTree {
	
	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public boolean search(int data) {
		return binarySearch(root, data);
	}
	
	public boolean insert(int data) {
		root = binaryInsert(root, data);
		return true;
	}
	
	public boolean remove(int data) {
		if (root != null) {
			Node parent = null;
			Node current = root;
			Node successor = null;
			
			while (true) {
				if (current == null) {
					return false;
				} else if (current.getData() == data) {
					break;
				}
				
				parent = current;
				current = data < current.getData() ?
						current.getLeft()
						: current.getRight();
			}
			
			if (current.getLeft() != null && current.getRight() != null) {
				// with two children, look for successor
				parent = current;
				successor = current.getRight();
				
				while (successor.getLeft() != null) {
					parent = successor;
					successor = successor.getLeft();
				}
				
				current.setData(successor.getData());
				
				if (parent.getRight().equals(successor)) {
					parent.setRight(null);
				} else {
					parent.setLeft(null);
				}
			} else {
				// just one child
				Node child = current.getLeft() == null ?
						current.getRight()
						: current.getLeft();
						
				if (parent == null) {
					root = child;
				} else {
					if (parent.getRight().equals(current)) {
						parent.setRight(child);
					} else {
						parent.setLeft(child);
					}						
				}
				
				current = null;
			}
		}
		
		return true;
	}
	
	public void clear() {
		root = null;
	}
	
	public void inOrder() {
		System.out.println("In-order: ");
		inOrderRecursive(root);
	}
	
	public void preOrder() {
		System.out.println("Pre-order: ");
		preOrderRecursive(root);
	}
	
	public void postOrder() {
		System.out.println("Post-order: ");
		postOrderRecursive(root);
	}
	
	private boolean binarySearch(Node current, int data) {
		if (current == null) {
			System.out.println("current null");
			return false;
		} else if (current.getData() == data) {
			return true;
		} else {
			return data < current.getData() ? 
					binarySearch(current.getLeft(), data) 
					: binarySearch(current.getRight(), data);
		}		
	}
	
	private Node binaryInsert(Node current, int data) {
		if (current == null) {
			return new Node(data);
		} else if (current.getData() == data) {
			return current;
		} else {
			if (data < current.getData()) {
				current.setLeft(binaryInsert(current.getLeft(), data)); 
			} else {
				current.setRight(binaryInsert(current.getRight(), data));
			}
					
			return current;
		}
	}
	
	private void inOrderRecursive(Node current) {
		if (current != null) {
			inOrderRecursive(current.getLeft());
			System.out.println(current.getData());
			inOrderRecursive(current.getRight());
		}
	}
	
	private void preOrderRecursive(Node current) {
		if (current != null) {
			System.out.println(current.getData());
			preOrderRecursive(current.getLeft());
			preOrderRecursive(current.getRight());
		}
	}
	
	private void postOrderRecursive(Node current) {
		if (current != null) {
			postOrderRecursive(current.getLeft());
			postOrderRecursive(current.getRight());
			System.out.println(current.getData());
		}
	}
}
