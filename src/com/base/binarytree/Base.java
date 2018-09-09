package com.base.binarytree;

import com.base.Node;

public class Base {

	static Traversal traversal = new Traversal();
	static Node rootNode = new Node();
	static Node rootNode4 = new Node();
	static Node rootNode2 = new Node();
	static Node rootNode3 = new Node();
	static TreeOperation operation = new TreeOperation();

	public static void main(String[] args) {
		loadSkewedTree();
		loadTree();
		loadSubTree();
		loadTreeSum();
		// ****** Traverse tree BFS and DFS.
		 traversal.traversalType(Traversal.IN_ORDER, rootNode);
		 traversal.traversalType(Traversal.PRE_ORDER, rootNode);
		 traversal.traversalType(Traversal.POST_ORDER, rootNode);
		 traversal.traversalType(Traversal.BFS_ORDER, rootNode);

		// ****** Build Tree From Sorted Array
		// int[] arr = {1, 2, 3, 4, 5, 6, 7};
		// operation.buildBstFromArray(arr);
		// ****** Get Height and Check Balanced.
		// System.out.println("Height is " + (operation.getHeight(rootNode) - 1));
		// System.out.println("Is balanced? " + operation.isBalanced(rootNode));
		// ****** Check if Binary tree is BST.
		// System.out.println("Is Binary Tree:
		// "+operation.isBinarySearchTree(rootNode));
		// System.out.println("Is Binary Tree Min Max:
		// "+operation.isBinarySearchTreeMinMax(rootNode));
		// operation.printNextNode(rootNode, 5);
		// operation.printNextNode(rootNode, 27);
		// operation.printNextNode(rootNode, 1);
		// ****** Check for elements at given level.
		// operation.printNodesAtLevel(rootNode, 2);
		// ****** Prints path of all the nodes that are enroute to a child node.
		// operation.printPath(rootNode, 13);
		// ****** Checks if two trees are equal.
		// System.out.println("Are trees matching?" +
		// operation.checkIfTreesAreIdentical(rootNode2, rootNode2));
		// ****** Check if subtree.
		// System.out.println("Is subtree? " + operation.isSubTree(rootNode,
		// rootNode3));
		// ****** Get Sum of all nodes.
		// System.out.println("Sum of all nodes: " +
		// operation.getSumOfAllNodes(rootNode));
		// ****** Check if given tree is sumTree
		// operation.isSumTree(loadTreeSum());
		// ****** Give count of number of leaf nodes.
		// operation.giveNumberOfLeafNode(loadSubTree());
		// System.out.println("Number of leaf nodes:" + operation.nVal);
		// ****** Print path to leaf node.
		// operation.printPathToLeaf(loadTree());
		// ****** Print all diagonal nodes.
		// operation.printDiagonalElements(rootNode);
		// ****** Print all nodes from top view.
		// operation.topView(rootNode4, 0);
		// ****** Searches for ancestor of two nodes.
		// operation.printFirstAncestor(rootNode, 7, 27);
		// ****** Insert into BST without Balancing.
		// traversal.traversalType(Traversal.BFS_ORDER, rootNode);
		// rootNode.insertBst(rootNode, 6);
		// traversal.traversalType(Traversal.BFS_ORDER, rootNode);
		// rootNode.insertBst(rootNode, 4);
		// traversal.traversalType(Traversal.BFS_ORDER, rootNode);
	}

	private static Node loadTree() {

		rootNode.setNode(10);
		Node nodeL1 = new Node();
		nodeL1.setNode(5);
		Node nodeL1L = new Node();
		nodeL1L.setNode(1);
		nodeL1L.setParentNode(nodeL1);
		Node nodeL1R = new Node();
		nodeL1R.setNode(7);
		nodeL1R.setParentNode(nodeL1);

		nodeL1.setlNode(nodeL1L);
		nodeL1.setrNode(nodeL1R);
		nodeL1.setParentNode(rootNode);

		Node nodeR1 = new Node();
		nodeR1.setNode(20);
		Node nodeR1L = new Node();
		nodeR1L.setNode(13);
		nodeR1L.setParentNode(nodeR1);
		Node nodeR1R = new Node();
		nodeR1R.setNode(27);
		nodeR1R.setParentNode(nodeR1);
		// Node nodeR1R2R = new Node();
		// nodeR1R2R.setNode(30);

		nodeR1.setlNode(nodeR1L);
		nodeR1.setrNode(nodeR1R);
		nodeR1.setParentNode(rootNode);
		// nodeR1R.setrNode(nodeR1R2R);

		rootNode.setlNode(nodeL1);
		rootNode.setrNode(nodeR1);
		return rootNode;
	}

	private static Node loadTreeSum() {

		rootNode4.setNode(30);
		Node nodeL1 = new Node();
		nodeL1.setNode(10);
		Node nodeL1L = new Node();
		nodeL1L.setNode(3);
		nodeL1L.setParentNode(nodeL1);
		Node nodeL1R = new Node();
		nodeL1R.setNode(7);
		nodeL1R.setParentNode(nodeL1);

		nodeL1.setlNode(nodeL1L);
		nodeL1.setrNode(nodeL1R);
		nodeL1.setParentNode(rootNode4);

		Node nodeR1 = new Node();
		nodeR1.setNode(20);
		Node nodeR1L = new Node();
		nodeR1L.setNode(13);
		nodeR1L.setParentNode(nodeR1);
		Node nodeR1R = new Node();
		nodeR1R.setNode(7);
		nodeR1R.setParentNode(nodeR1);

		nodeR1.setlNode(nodeR1L);
		nodeR1.setrNode(nodeR1R);
		nodeR1.setParentNode(rootNode4);

		rootNode4.setlNode(nodeL1);
		rootNode4.setrNode(nodeR1);
		return rootNode4;
	}

	private static Node getNode4() {

		Node rootNode = new Node();

		rootNode.node = 20;
		rootNode.lNode.node = 10;
		rootNode.rNode.node = 30;
		rootNode.lNode.lNode.node = 5;
		rootNode.lNode.rNode.node = 13;
		rootNode.rNode.lNode.node = 25;
		rootNode.rNode.rNode.node = 33;

		return rootNode;
	}

	private static Node loadSkewedTree() {

		rootNode2.setNode(10);
		Node nodeL1 = new Node();
		nodeL1.setNode(7);
		Node nodeL1L = new Node();
		nodeL1L.setNode(5);
		Node nodeL1LL1 = new Node();
		nodeL1LL1.setNode(3);
		Node nodeL1LL1L1 = new Node();
		nodeL1LL1L1.setNode(1);

		nodeL1.setlNode(nodeL1L);
		nodeL1L.setlNode(nodeL1LL1);
		nodeL1LL1.setlNode(nodeL1LL1L1);
		rootNode2.setlNode(nodeL1);
		return rootNode2;
	}

	private static Node loadSubTree() {
		rootNode3.setNode(27);
		Node nodeL = new Node();
		nodeL.setNode(13);
		Node nodeR = new Node();
		nodeR.setNode(30);
		rootNode3.setlNode(nodeL);
		rootNode3.setrNode(nodeR);
		return rootNode3;
	}
}
