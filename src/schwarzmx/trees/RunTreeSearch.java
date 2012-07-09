package schwarzmx.trees;

public class RunTreeSearch {

	public static void main(String[] args) {
		int values[] = {5, 8, 3, 4, 7, 12, 1, 6};
		BinarySearchTree tree = new BinarySearchTree();
		
		boolean found = tree.search(3);
		System.out.println("Found? " + found);
		
		for (int data : values) {
			tree.insert(data);
			tree.inOrder();
		}
		
		found = tree.search(3);
		System.out.println("Found? " + found);
		
		tree.remove(3);
		found = tree.search(3);
		System.out.println("Found? " + found);
		
		
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
	}

}
