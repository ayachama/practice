package com.base;

public class Node {

	public int node;
	public Node lNode;
	public Node rNode;
	public Node parentNode;
	private int digVal;

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public Node getlNode() {
		return lNode;
	}

	public void setlNode(Node lNode) {
		this.lNode = lNode;
	}

	public Node getrNode() {
		return rNode;
	}

	public void setrNode(Node rNode) {
		this.rNode = rNode;
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	public int getDigVal() {
		return digVal;
	}

	public void setDigVal(int digVal) {
		this.digVal = digVal;
	}

	public void insertBst(Node node, int val) {
		if (node != null) {
			if (val < node.getNode() && node.getlNode() != null && val < node.getlNode().getNode()) {
				insertBst(node.getlNode(), val);
			} else if (val < node.getNode()) {
				Node temp = node.getlNode();
				Node newNode = new Node();
				newNode.setNode(val);
				newNode.setlNode(temp);
				node.setlNode(newNode);
			}
			if (val > node.getNode() && node.getrNode() != null && val > node.getrNode().getNode()) {
				insertBst(node.getrNode(), val);
			} else if (val > node.getNode()) {
				Node temp = node.getrNode();
				Node newNode = new Node();
				newNode.setNode(val);
				newNode.setrNode(temp);
				node.setrNode(newNode);
			}
		}
	}

}
