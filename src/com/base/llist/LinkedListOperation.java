package com.base.llist;

import java.util.HashSet;
import java.util.LinkedHashSet;

import com.base.LinkedNode;

public class LinkedListOperation {

	public int findMiddle(LinkedNode node) {

		if (node == null)
			return -1;

		LinkedNode p = node.head;
		LinkedNode q = node.head;

		while (q != null && q.next != null) {
			q = q.next.next;
			p = p.next;
		}

		return p.value;
	}

	public int getNumberOfNodeInLoop(LinkedNode node) {

		if (node == null)
			throw new IllegalArgumentException("LL Head cannot be empty!");

		LinkedNode p = node.head;
		LinkedNode q = node.head;
		LinkedHashSet<LinkedNode> hashSet = new LinkedHashSet<>();
		boolean isFirst = true;

		// Detect collision.
		while (isFirst || (q != null && q.next != null && p != q)) {
			isFirst = false;
			hashSet.add(q);
			q = q.next.next;
			p = p.next;
		}
		hashSet.add(q);

		if (p == q) {
			// Complete iteration till we meet this node again.
			LinkedNode collision = q;
			q = q.next;
			int loopCounter = 1;
			while (q != null && q.value != collision.value) {
				loopCounter++;
				q = q.next;
			}
			return loopCounter;
		}
		return -1;
	}

	public int sumTwoLL(LinkedNode a, LinkedNode b) {

		StringBuffer sb = new StringBuffer();
		if (a == null)
			return b.value;

		if (b == null)
			return a.value;

		int add = 0;
		int div = 0;
		int rem = 0;
		int car = 0;

		LinkedNode p = a;
		LinkedNode q = b;

		while (p != null && q != null) {

			if (car != 0) {
				add = p.value + q.value + car;
				car = 0;
			} else {
				add = p.value + q.value;
			}

			if (p.next == null && q.next == null) {
				sb.append(new StringBuffer(String.valueOf(add)).reverse());
				break;
			}
			div = add / 10;
			// No Carry
			if (div == 0) {
				sb.append(add);
				p = p.next;
				q = q.next;
			} else {
				rem = add % 10;
				car = div;
				sb.append(rem);
				p = p.next;
				q = q.next;
			}
		}

		return Integer.parseInt(sb.reverse().toString());
	}

}
