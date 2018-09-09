package com.base.binarytree;

import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.base.GraphNode;

public class GraphOperation {

	Queue<GraphNode> graphNodes = new LinkedList<>();
	HashSet<GraphNode> hasVisited = new HashSet<>();

	public boolean searchBfs(GraphNode node, int val) {
		return bfs(node, val);
	}

	private boolean bfs(GraphNode node, int val) {
		graphNodes.add(node);

		while (!graphNodes.isEmpty()) {
			GraphNode n = graphNodes.remove();
			if (hasVisited.contains(n)) {
				continue;
			}
			hasVisited.add(n);
			if (n.getValue() == val) {
				return true;
			}
			for (GraphNode gn : n.getAdjacentVal()) {
				graphNodes.add(gn);
			}
		}
		return false;
	}

	public boolean searchDfs(GraphNode node, int val) {
		hasVisited = new HashSet<>();
		boolean dfsPath = dfs(node, val);
		return dfsPath;
	}

	private boolean dfs(GraphNode node, int val) {
		if (node == null)
			throw new IllegalArgumentException("Not valid argument");
		if (!hasVisited.contains(node)) {
			System.out.println(node.getValue());
			hasVisited.add(node);
			if (node.getValue() == val)
				return true;
			boolean isFound = false;
			for (GraphNode gn : node.getAdjacentVal()) {
				if (gn != null) {
					isFound = isFound || dfs(gn, val);
				}
			}
			return isFound;
		}
		return false;
	}

}
