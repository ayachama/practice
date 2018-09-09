package com.base.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.base.Node;

public class Traversal {

	public static final int IN_ORDER = 11;
	public static final int PRE_ORDER = 21;
	public static final int POST_ORDER = 31;
	public static final int BFS_ORDER = 41;

	private ArrayList<Integer> treeElements = new ArrayList<>();
	private Queue<Node> queue = null;

	/**
	 * Traverses binary tree using BFS and DFS approach.
	 * 
	 * @param type
	 *            - Type of traversal - IN_ORDER, PRE_ORDER, POST_ORDER, BFS_ORDER.
	 * @param rootNode
	 *            - root node of the tree.
	 */
	public void traversalType(int type, Node rootNode) {

		switch (type) {
		case IN_ORDER:
			inOrderTraversal(rootNode);
			System.out.println("|| In Order");
			break;

		case PRE_ORDER:
			preOrderTraversal(rootNode);
			System.out.println("|| Pre Order");
			break;

		case POST_ORDER:
			postOrderTraversal(rootNode);
			System.out.println("|| Post Order");
			break;

		case BFS_ORDER:
			queue = new LinkedList<Node>();
			bfsTraversal(rootNode);
			System.out.println("|| BFS Traversal");
			break;

		default:
			break;
		}
	}

	public ArrayList<Integer> inOrTraversal(Node rootNode) {
		inOrderTraversal(rootNode);
		return treeElements;
	}

	private void bfsTraversal(Node node) {
		// if (node != null) {
		// perform(node);
		// queue.add(node.getlNode());
		// queue.add(node.getrNode());
		// for (int i = 0; i < queue.size(); i++) {
		// bfsTraversal(queue.poll());
		// }
		// }
		if (node != null) {
			perform(node);
			queue.add(node);
			for (int i = 0; i < queue.size(); i++) {
				Node n = queue.poll();
				bfsTraversal(n.getlNode());
				bfsTraversal(n.getrNode());
			}
		}
	}

	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.getlNode());
			perform(node);
			inOrderTraversal(node.getrNode());
		}
	}

	private void preOrderTraversal(Node node) {
		if (node != null) {
			perform(node);
			preOrderTraversal(node.getlNode());
			preOrderTraversal(node.getrNode());
		}
	}

	private void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.getlNode());
			postOrderTraversal(node.getrNode());
			perform(node);
		}
	}

	private void perform(Node node) {
		System.out.print(node.getNode());
		treeElements.add(node.getNode());
		System.out.print(">");
	}

}
