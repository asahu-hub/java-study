package org.asahu.hub.study.datastructures.fb.linkedlists;

public class ListNode {
	int val;
	ListNode next;

	public ListNode() {
	}

	public ListNode(int value) {
		this.val = value;
	}

	public ListNode(int value, ListNode nextNode) {
		this.next = nextNode;
		this.val = value;
	}

	@Override
	public String toString() {
		return this.val + " -> " + this.next;
	}

}
