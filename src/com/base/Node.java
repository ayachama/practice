package com.base;

public class Node {

	private int node;
	private Node lNode;
	private Node rNode;
	private Node parentNode;

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
}
