package schwarzmx.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private List<Node> neighbors;
	private int label;
	private boolean visited;
	
	public Node(int label) {
		this.label = label;
		neighbors = new ArrayList<Node>();
		this.visited = false;
	}
	
	public void addNeighbor(Node neighbor) {
		neighbors.add(neighbor);
	}
	
	public List<Node> getNeighbors() {
		return neighbors;
	}
	
	public int getLabel() {
		return label;
	}
	
	public void markVisited() {
		visited = true;
	}
	
	public boolean wasVisited() {
		return visited;
	}
	
	public void clearVisited() {
		visited = false;
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Node) obj).label == this.label;
	}
}
