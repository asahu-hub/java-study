package org.asahu.hub.study.datastructures.fb.linkedlists;

public class LinkedList_FB {

	/**
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order, and each of their nodes
	 * contains a single digit. Add the two numbers and return the sum as a linked
	 * list.
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// System.out.println("Received\nList Node 1: " + l1 + "\nList Node 2: " + l2);
		int carryOn = 0;
		int index = 0;
		int flag = 0;
		ListNode sumNode = new ListNode();
		ListNode nextNode = new ListNode();
		ListNode fNode = l1;
		ListNode sNode = l2;
		while (flag == 0) {
			int fValue = fNode.val;
			int sValue = sNode.val;
			ListNode fnNode = fNode.next;
			ListNode snNode = sNode.next;

			// If both values are 0, then return 0 and break;
			if (fValue == 0 && sValue == 0 && fnNode == null && snNode == null) {
				sumNode = new ListNode(0);
				flag = -1;
				break;
			}

			int sum = add(fValue, sValue, carryOn);
			carryOn = extractCarryOn(sum);

			int nValue = sum > 9 ? sum - 10 : sum;

			if (index == 0) {
				sumNode = new ListNode(nValue);
				nextNode = sumNode;
			} else {
				ListNode newNode = new ListNode(nValue);
				nextNode.next = newNode;
				nextNode = newNode;
			}

			// Cleanup
			if (fnNode == null && snNode == null) {
				if (carryOn == 0) {
					flag = -1;
				} else {
					fnNode = new ListNode(0);
					snNode = new ListNode(carryOn);
					carryOn = 0;
				}
			} else if (fnNode == null && snNode != null) {
				fnNode = new ListNode(0);
			} else if (fnNode != null && snNode == null) {
				snNode = new ListNode(0);
			}
			++index;
			fNode = fnNode;
			sNode = snNode;
		}
		// System.out.println("Returning\nSum Node : " + sumNode);
		return sumNode;
	}

	private int add(int num1, int num2, int carryOn) {
		return num1 + num2 + carryOn;
	}

	private int extractCarryOn(int sum) {
		if (sum < 10) {
			return 0;
		}
		return 1;
	}

	public ListNode init(int[] values) {
		ListNode successor = new ListNode();
		ListNode firstNode = new ListNode();
		int totalElements = values.length;

		for (int i = 0; i < totalElements; i++) {
			int cValue = values[i];
			if (i == 0) {
				firstNode = new ListNode(cValue);
				successor = firstNode;
			} else {
				ListNode newNode = new ListNode(cValue);
				successor.next = newNode;
				successor = newNode;
			}
		}
		return firstNode;
	}

}
