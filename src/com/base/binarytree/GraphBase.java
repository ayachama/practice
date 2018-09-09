package com.base.binarytree;

import java.util.LinkedList;

import com.base.GraphNode;

public class GraphBase {

	private GraphNode graphNode = new GraphNode();

	public static void main(String[] args) {
		GraphOperation graphOperation = new GraphOperation();
		// ****** Searches for a given node using BFS in graph.
		// System.out.println("Is 3 present using BFS? " +
		// graphOperation.searchBfs(loadGraph(), 3));
		// System.out.println("Is 15 present using BFS? " +
		// graphOperation.searchBfs(loadGraph(), 21));
		// System.out.println("Is -5 present using BFS? " +
		// graphOperation.searchBfs(loadGraph(), 18));

		// ****** Searches for a given node using DFS in graph.
		 System.out.println("Is 21 found using DFS: "+graphOperation.searchDfs(loadGraph(), 18));
	}

	
	/**
	 * Constructs a graph with below structure.
	 * 	  3---9---15
	 * 	/		\  |
	 * 0			   21
	 * 	\		/  |
	 * 	 6---12---18
	 * 
	 * @return - starting 0 of the graph.
	 */
	private static GraphNode loadGraph() {
		GraphNode node1 = new GraphNode();
		node1.setValue(0);
		GraphNode node2 = new GraphNode();
		node2.setValue(3);
		GraphNode node3 = new GraphNode();
		node3.setValue(6);
		GraphNode node4 = new GraphNode();
		node4.setValue(9);
		GraphNode node5 = new GraphNode();
		node5.setValue(12);
		GraphNode node6 = new GraphNode();
		node6.setValue(15);
		GraphNode node7 = new GraphNode();
		node7.setValue(18);
		GraphNode node8 = new GraphNode();
		node8.setValue(21);

		LinkedList<GraphNode> adj1 = new LinkedList<>();
		adj1.add(node2);
		adj1.add(node3);
		node1.setAdjacentVal(adj1);
		LinkedList<GraphNode> adj2 = new LinkedList<>();
		adj2.add(node4);
		adj2.add(node1);
		node2.setAdjacentVal(adj2);
		LinkedList<GraphNode> adj3 = new LinkedList<>();
		adj3.add(node5);
		adj3.add(node1);
		node3.setAdjacentVal(adj3);
		LinkedList<GraphNode> adj4 = new LinkedList<>();
		adj4.add(node2);
		adj4.add(node6);
		adj4.add(node8);
		node4.setAdjacentVal(adj4);
		LinkedList<GraphNode> adj5 = new LinkedList<>();
		adj5.add(node3);
		adj5.add(node8);
		adj5.add(node7);
		node5.setAdjacentVal(adj5);
		LinkedList<GraphNode> adj6 = new LinkedList<>();
		adj6.add(node4);
		adj6.add(node8);
		node6.setAdjacentVal(adj6);
		LinkedList<GraphNode> adj7 = new LinkedList<>();
		adj7.add(node5);
		adj7.add(node8);
		node7.setAdjacentVal(adj7);
		LinkedList<GraphNode> adj8 = new LinkedList<>();
//		adj8.add(node4);
//		adj8.add(node5);
		adj8.add(node6);
		adj8.add(node7);
		node8.setAdjacentVal(adj8);

		return node1;
	}

}
