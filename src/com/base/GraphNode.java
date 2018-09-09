package com.base;

import java.util.LinkedList;

public class GraphNode {

	private int value;
	private LinkedList<GraphNode> adjacentVal = new LinkedList<GraphNode>();
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LinkedList<GraphNode> getAdjacentVal() {
		return adjacentVal;
	}

	public void setAdjacentVal(LinkedList<GraphNode> adjacentVal) {
		this.adjacentVal = adjacentVal;
	}
}
