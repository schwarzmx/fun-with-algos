package schwarzmx.graphs;

import java.util.Stack;

public class DepthFirstSearch extends Search {

	public void search(Node startNode, Node goalNode) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(startNode);
		startNode.markVisited();
		
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			
			System.out.println("Current: " + current.getLabel());
			
			if (goalNode.equals(current)) {
				System.out.println("Found!");
				break;
			}
			
			for (Node neighbor : current.getNeighbors()) {
				if (!neighbor.wasVisited()) {
					System.out.println("Neighbor: " + neighbor.getLabel() + ", visited:" + neighbor.wasVisited());
					
					stack.add(neighbor);
					neighbor.markVisited();
				}
			}
		}
	}

}
