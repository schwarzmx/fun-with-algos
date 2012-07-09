package schwarzmx.trees;

public class Node {
	
	private int data;
	private Node left;
	private Node right;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node node) {
		this.right = node;
	}

	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node node) {
		this.left = node;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	@Override
	public boolean equals(Object obj) {
	
		return ((Node) obj).data == this.data;
	}
}
