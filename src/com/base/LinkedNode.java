package com.base;

public class LinkedNode {

	public int value;
	public LinkedNode next;
	public LinkedNode prev;
	public LinkedNode head;

	public int getLength() {
		int count = 0;
		LinkedNode p = head;
		while (p.next != null) {
			count++;
			p = p.next;
		}
		return count;
	}
}
