package com.base.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.base.Node;

public class TreeOperation {

	/**
	 * Warpper method for constructing binary search tree from provided sorted
	 * array.
	 * 
	 * @param arr
	 *            - array sorted in ascending order.
	 */
	public static void buildBstFromArray(int[] arr) {
		Node rootNode = buildTree(arr, 0, arr.length - 1);
		new Traversal().traversalType(Traversal.PRE_ORDER, rootNode);
	}

	// Pass array and index positions that should be used for contructing sub nodes.
	private static Node buildTree(int[] a, int l, int r) {
		if (r < l) {
			return null;
		} else {
			int m = (l + r) / 2;
			Node node = new Node();
			node.setNode(a[m]);
			node.setlNode(buildTree(a, l, m - 1));
			node.setrNode(buildTree(a, m + 1, r));
			return node;
		}
	}

	/**
	 * Checks if tree is balanced. Checks if height of any difference between left
	 * and right node in the tree is not greater than 1.
	 * 
	 * @param node
	 *            - node from which difference in height should be checked.
	 * @return - true is tree is balanced.
	 */
	public boolean isBalanced(Node node) {
		if (node == null)
			return true;

		if (Math.abs(getHeight(node.getlNode()) - getHeight(node.getrNode())) > 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Get height of provided binary tree.
	 * 
	 * @param node
	 *            - node from which height should be calculated.
	 * @return - returns height of the binary tree.
	 */
	public int getHeight(Node node) {
		if (node == null)
			return 0;
		return Math.max(getHeight(node.getlNode()), getHeight(node.getrNode())) + 1;
	}

	/**
	 * Check's if provided tree is binary search tree using in order traversal
	 * method.
	 * 
	 * @param node
	 *            - root node of the binary search tree.
	 * @return - true if it is BST.
	 */
	public boolean isBinarySearchTree(Node node) {
		return checkBinarySearchTree(node);
	}

	// private method for checking if BST using in order traversal method.
	// Inorder traversal should show numbers in ascending order.
	private boolean checkBinarySearchTree(Node rootNode) {
		ArrayList<Integer> arrayList = new Traversal().inOrTraversal(rootNode);
		for (int i = 0; i < arrayList.size() - 1; i++) {
			if (!(arrayList.get(i) < arrayList.get(i + 1))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if tree is balanced using min and max approach.
	 * 
	 * @param rootNode
	 *            - node from which min and max should be calcualted.
	 * @return - true if it is BST.
	 */
	public boolean isBinarySearchTreeMinMax(Node rootNode) {
		return checkMinMax(rootNode.getlNode(), 0, 0);
	}

	private boolean checkMinMax(Node node, int min, int max) {
		if (node == null)
			return true;
		if ((min != 0 && node.getNode() >= min) || (max != 0 && node.getNode() > max)) {
			return false;
		}
		if (!checkMinMax(node.getlNode(), min, node.getNode()) || !checkMinMax(node.getrNode(), node.getNode(), max)) {
			return false;
		}
		return true;
	}

	public void printNextNode(Node rootNode, int searchFor) {
		searchNextNode(rootNode, searchFor, false);
	}

	private void searchNextNode(Node node, int searchFor, boolean isNextNull) {
		// Checks left sub tree.
		if (node != null && isNextNull == false) {
			searchNextNode(node.getlNode(), searchFor, false);
			if (searchFor == node.getNode()) {
				if (node.getrNode() != null) {
					System.out.println("Next node of " + searchFor + " is: " + node.getrNode().getNode());
				} else {
					searchNextNode(node, searchFor, true);
				}
			}
			searchNextNode(node.getrNode(), searchFor, false);
		}
		// Iterates backwards to check in right subtree.
		if (node != null && isNextNull == true) {
			Node parentNode = node.getParentNode();
			if (parentNode == null) {
				System.out.println("No Next node for " + searchFor);
			}
			if (parentNode != null && parentNode.getrNode().getNode() > searchFor) {
				System.out.println("Next node of " + searchFor + " is: " + parentNode.getrNode().getNode());
			} else {
				searchNextNode(node.getParentNode(), searchFor, true);
			}
		}
	}

	public Queue<Node> nodeElements = new LinkedList<Node>();
	private int currentLevel = 0;

	public void printNodesAtLevel(Node node, int level) {
		nodeElements.add(node);
		// printNodesBFS(level);
		printNodeAtLevel(node, level);
	}

	private void printNodeAtLevel(Node node, int level) {
		if (node == null)
			return;

		if (level == 0) {
			System.out.print(node.getNode() + ":");
		} else {
			printNodeAtLevel(node.getlNode(), level - 1);
			printNodeAtLevel(node.getrNode(), level - 1);
		}
	}

	private void printNodesBFS(int level) {
		if (nodeElements.isEmpty())
			return;

		Node node = nodeElements.poll();
		if (node == null)
			return;

		System.out.println("Element is " + node.getNode() + " at level: " + level);
		nodeElements.add(node.getlNode());
		nodeElements.add(node.getrNode());
		printNodesBFS(level - 1);
	}

	/**
	 * Prints all the nodes that are on the way to reach a child node.
	 * 
	 * @param node
	 *            - node from which we should start looking.
	 * @param find
	 *            - element to look for.
	 * @return - true if there are matches.
	 */
	public boolean printPath(Node node, int find) {
		if (node != null) {
			if (node.getNode() == find) {
				System.out.print(node.getNode() + ":");
				return true;
			}

			if ((printPath(node.getlNode(), find)) || (printPath(node.getrNode(), find))) {
				System.out.print(node.getNode() + ":");
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if two trees are identical.
	 * 
	 * @param node1
	 *            - root node of tree 1.
	 * @param node2
	 *            - root node of tree 2.
	 * @return
	 */
	public boolean checkIfTreesAreIdentical(Node node1, Node node2) {

		if (node1 == null && node2 == null)
			return true;

		if ((node1 != null && node2 == null) || (node1 == null && node2 != null))
			return false;

		if (node1.getNode() == node2.getNode() && checkIfTreesAreIdentical(node1.getlNode(), node2.getlNode())
				&& checkIfTreesAreIdentical(node1.getrNode(), node2.getrNode()))
			return true;

		return false;
	}

	/**
	 * Checks if tree 2 is subtree of tree 1.
	 * 
	 * @param node1
	 *            - root node of tree 1.
	 * @param node2
	 *            - root node of tree 2.
	 * @return - true if it is subtree.
	 */
	public boolean isSubTree(Node node1, Node node2) {

		if (node1 == null && node2 == null)
			return true;

		if ((node1 != null && node2 == null) || (node1 == null && node2 != null))
			return false;

		if (node1.getNode() == node2.getNode()) {
			return checkIfTreesAreIdentical(node1, node2);
		}

		return (isSubTree(node1.getlNode(), node2) || isSubTree(node1.getrNode(), node2));
	}

	/**
	 * Returns sum of all the elements in the binary tree.
	 * 
	 * @param node
	 *            - root node.
	 * @return - sum of all the elements.
	 */
	public int getSumOfAllNodes(Node node) {

		if (node == null)
			return 0;

		int sum = node.getNode() + getSumOfAllNodes(node.getlNode()) + getSumOfAllNodes(node.getrNode());
		return sum;
	}

	public int nVal = 0;

	/**
	 * Checks if give tree is a sum tree. This method is not completely implemented.
	 */
	public int isSumTree(Node node) {
		if (node != null) {
			nVal = isSumTree(node.getlNode()) + isSumTree(node.getrNode());
			if (!(nVal == node.getNode())) {
				System.out.println("Not a Sum Tree");
			} else {
				System.out.println("Sum Tree");
			}
			return node.getNode();
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param node
	 */
	public void giveNumberOfLeafNode(Node node) {
		if (node != null) {
			giveNumberOfLeafNode(node.getlNode());
			giveNumberOfLeafNode(node.getrNode());
			if (node.getlNode() == null && node.getrNode() == null)
				nVal++;
		}

	}

	private Queue<Integer> path = new LinkedList<>();

	/**
	 * Print path to leaf node.
	 * 
	 * @param node
	 */
	public void printPathToLeaf(Node node) {
		if (node != null) {
			path.add(node.getNode());
			printPathToLeaf(node.getlNode());
			if (node.getlNode() == null && node.getrNode() == null) {
				System.out.println(path.toString());
			}
			printPathToLeaf(node.getrNode());
			path.remove(node.getNode());
		}
	}

	/**
	 * Prints all diagonal elements in a Binary Tree.
	 * 
	 * @param node
	 *            - root node of binary tree.
	 */
	public void printDiagonalElements(Node node) {
		addDiagValue(node, 0);
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		Node n = null;
		while (!queue.isEmpty()) {
			n = queue.poll();
			if (n == null) {
				System.out.println("");
				queue.add(null);
				n = queue.poll();
				if (n == null)
					break;
			}
			while (n != null) {
				System.out.print(":" + n.getNode());
				if (n.getlNode() != null)
					queue.add(n.getlNode());
				n = n.getrNode();
			}
		}
	}

	private void addDiagValue(Node node, int value) {
		if (node != null) {
			node.setDigVal(value);
			addDiagValue(node.getlNode(), value + 1);
			addDiagValue(node.getrNode(), value);
		}
	}

	/**
	 * Print all nodes visible from top view.
	 * 
	 * @param node
	 *            - node.
	 * @param position
	 *            - position from which we pass.
	 */
	public void topView(Node node, int position) {
		if (node != null) {
			if (position == 0) {
				System.out.print(node.getNode() + ":");
				topView(node.getlNode(), 1);
				topView(node.getrNode(), 2);
			}
			if (position == 1) {
				if (node.getlNode() == null && node.getrNode() == null) {
					System.out.print(node.getNode() + ":");
					return;
				}
				System.out.print(node.getNode() + ":");
				topView(node.getlNode(), 1);
			}

			if (position == 2) {
				if (node.getlNode() == null && node.getrNode() == null) {
					System.out.print(node.getNode() + ":");
					return;
				}
				System.out.print(node.getNode() + ":");
				topView(node.getrNode(), 2);
			}
		}
	}

	/**
	 * Prints first common ancestor for two nodes in binary tree.
	 * 
	 * @param node
	 */
	public boolean printFirstAncestor(Node node, int a, int b) {
		boolean aFound = false;
		boolean bFound = false;
		if (node != null) {
			if (node.getNode() == a || node.getNode() == b)
				return true;
			aFound = printFirstAncestor(node.getlNode(), a, b);
			bFound = printFirstAncestor(node.getrNode(), a, b);
			if (aFound && bFound) {
				System.out.println(node.getNode());
			}
		}
		return aFound || bFound;
	}

}
