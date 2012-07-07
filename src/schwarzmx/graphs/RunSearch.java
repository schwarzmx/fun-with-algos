package schwarzmx.graphs;

import java.util.ArrayList;
import java.util.List;

public class RunSearch {

	public static void main(String[] args) {
		// create a sample (undirected) graph
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		
		List<Node> graph = new ArrayList<Node>();
		graph.add(one);
		graph.add(two);
		graph.add(three);
		graph.add(four);
		graph.add(five);
		graph.add(six);
		
		one.addNeighbor(two);
		one.addNeighbor(three);
		two.addNeighbor(one);
		two.addNeighbor(four);
		three.addNeighbor(one);
		three.addNeighbor(four);
		four.addNeighbor(two);
		four.addNeighbor(three);
		four.addNeighbor(five);
		four.addNeighbor(six);
		five.addNeighbor(four);
		six.addNeighbor(four);
		
		Search algorithms[] = {new BreadthFirstSearch(), new DepthFirstSearch()};
		
		for (Search algorithm : algorithms) {
			algorithm.search(one, six);
			
			// clear visited graph
			clearGraph(graph);
		}
	}
	
	private static void clearGraph(List<Node> graph) {
		for (Node node : graph) {
			node.clearVisited();
		}
	}

}
