package com.base.llist;

import com.base.LinkedNode;

public class LinkedMain {

	LinkedListOperation linkedListOperation = new LinkedListOperation();
	static LinkedNode linkedNode = new LinkedNode();
	static LinkedNode loopLinkedNode = new LinkedNode();

	public static void main(String[] args) {
		linkedNode = loadLL();
		loopLinkedNode = loadLinkedLoop();
		LinkedListOperation linkedListOperation = new LinkedListOperation();
		// ***** Find middle element in LL.
		// System.out.println("Middle is: " +
		// linkedListOperation.findMiddle(linkedNode));
		// ***** Find Collision and number of elements in loop.
		// System.out.println("Collision value is: " +
		// linkedListOperation.getNumberOfNodeInLoop(loopLinkedNode));
		// ***** Linked list addition. Linked list is supplied to the method in reverse
		// order.
		System.out.println("Sum is : " + linkedListOperation.sumTwoLL(numA(), numB()));
	}

	private static LinkedNode numA() {
		linkedNode = new LinkedNode();
		linkedNode.value = 0;
		linkedNode.head = linkedNode;

		LinkedNode linkedNode1 = new LinkedNode();
		LinkedNode linkedNode2 = new LinkedNode();

		linkedNode1.value = 0;
		linkedNode2.value = 6;

		linkedNode.next = linkedNode1;
		linkedNode1.next = linkedNode2;
		return linkedNode;
	}

	private static LinkedNode numB() {
		linkedNode = new LinkedNode();
		linkedNode.value = 1;
		linkedNode.head = linkedNode;

		LinkedNode linkedNode1 = new LinkedNode();
		LinkedNode linkedNode2 = new LinkedNode();

		linkedNode1.value = 0;
		linkedNode2.value = 8;

		linkedNode.next = linkedNode1;
		linkedNode1.next = linkedNode2;
		return linkedNode;
	}

	private static LinkedNode loadLL() {
		linkedNode.value = 10;
		linkedNode.head = linkedNode;

		LinkedNode linkedNode1 = new LinkedNode();
		LinkedNode linkedNode2 = new LinkedNode();
		LinkedNode linkedNode3 = new LinkedNode();
		LinkedNode linkedNode4 = new LinkedNode();
		LinkedNode linkedNode5 = new LinkedNode();

		linkedNode1.value = 12;
		linkedNode2.value = 15;
		linkedNode3.value = 7;
		linkedNode4.value = 5;
		linkedNode5.value = 9;

		linkedNode.next = linkedNode1;
		linkedNode1.next = linkedNode2;
		linkedNode2.next = linkedNode3;
		linkedNode3.next = linkedNode4;
		linkedNode4.next = linkedNode5;

		return linkedNode;
	}

	private static LinkedNode loadLinkedLoop() {
		linkedNode.head = linkedNode;

		LinkedNode linkedNode1 = new LinkedNode();
		LinkedNode linkedNode2 = new LinkedNode();
		LinkedNode linkedNode3 = new LinkedNode();
		LinkedNode linkedNode4 = new LinkedNode();
		LinkedNode linkedNode5 = new LinkedNode();
		LinkedNode linkedNode6 = new LinkedNode();
		LinkedNode linkedNode7 = new LinkedNode();

		linkedNode.value = 10;
		linkedNode1.value = 12;
		linkedNode2.value = 15;
		linkedNode3.value = 7;
		linkedNode4.value = 5;
		linkedNode5.value = 9;
		linkedNode6.value = 3;
		linkedNode7.value = 2;

		linkedNode.next = linkedNode1;
		linkedNode1.next = linkedNode2;
		linkedNode2.next = linkedNode3;
		linkedNode3.next = linkedNode4;
		linkedNode4.next = linkedNode5;
		linkedNode5.next = linkedNode6;
		linkedNode6.next = linkedNode7;
		// Looping
		linkedNode7.next = linkedNode4;

		return linkedNode;
	}

}
