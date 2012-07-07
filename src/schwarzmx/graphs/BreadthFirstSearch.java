package schwarzmx.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Search {
	
	public void search(Node startNode, Node goalNode) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(startNode);
		startNode.markVisited();
		
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			
			System.out.println("Current: " + current.getLabel());
			
			if (goalNode.equals(current)) {
				System.out.println("Found!");
				break;
			}
			
			for (Node neighbor : current.getNeighbors()) {
				if (!neighbor.wasVisited()) {
					System.out.println("Neighbor: " + neighbor.getLabel() + ", visited:" + neighbor.wasVisited());
					
					queue.add(neighbor);
					neighbor.markVisited();
				}
			}
		}
	}

}
