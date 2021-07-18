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

	/**
	 * Merge two sorted linked lists and return it as a sorted list. The list should
	 * be made by splicing together the nodes of the first two lists.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1. The number of nodes in both lists is in the range [0, 50]. <br/>
	 * 2. -100 <= Node.val <= 100 <br/>
	 * 3. Both l1 and l2 are sorted in non-decreasing order.
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		System.out.println("Received List Node 11:" + l1 + "\n List Node l2: " + l2);
		ListNode allMergedNodes = new ListNode();
		ListNode successor = new ListNode();

		boolean flag = true;
		int index = 0;

		ListNode cFNode = l1;
		ListNode cSNode = l2;
		while (flag) {
			int cFValue = cFNode.val;
			int cSValue = cSNode.val;
			ListNode nFNode = cFNode.next;
			ListNode nSNode = cSNode.next;

			if (nFNode == null && nSNode == null) {
				flag = false;
			}

			int cValue = 0;
			if (cFValue >= cSValue) {
				cValue = cFValue;
				cFNode = nFNode;
			} else {
				cValue = cSValue;
				cSNode = nSNode;
			}

			if (index == 0) {
				allMergedNodes = new ListNode(cValue);
				successor = allMergedNodes;
			} else {
				ListNode newNode = new ListNode(cValue);
				successor.next = newNode;
				successor = newNode;
			}

			// Cleanup
			++index;
		}
		System.out.println("Merged Nodes: \n" + allMergedNodes);
		return allMergedNodes;
	}

}
