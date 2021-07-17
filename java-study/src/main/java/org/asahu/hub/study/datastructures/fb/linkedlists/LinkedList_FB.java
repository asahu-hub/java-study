package org.asahu.hub.study.datastructures.fb.linkedlists;

import java.util.Map;
import java.util.TreeMap;

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

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	/**
	 * A linked list of length n is given such that each node contains an additional
	 * random pointer, which could point to any node in the list, or null.
	 * 
	 * Construct a deep copy of the list. The deep copy should consist of exactly n
	 * brand new nodes, where each new node has its value set to the value of its
	 * corresponding original node. Both the next and random pointer of the new
	 * nodes should point to new nodes in the copied list such that the pointers in
	 * the original list and copied list represent the same list state. None of the
	 * pointers in the new list should point to nodes in the original list.
	 * 
	 * For example, if there are two nodes X and Y in the original list, where
	 * X.random --> Y, then for the corresponding two nodes x and y in the copied
	 * list, x.random --> y.
	 * 
	 * Return the head of the copied linked list.
	 * 
	 * The linked list is represented in the input/output as a list of n nodes. Each
	 * node is represented as a pair of [val, random_index] where:
	 * 
	 * val: an integer representing Node.val random_index: the index of the node
	 * (range from 0 to n-1) that the random pointer points to, or null if it does
	 * not point to any node. Your code will only be given the head of the original
	 * linked list.
	 * 
	 * Constraints:<br />
	 * 1. 0 <= n <= 1000 <br />
	 * 2. -10000 <= Node.val <= 10000 <br />
	 * 3. Node.random is null or is pointing to some node in the linked list.
	 */

	public Node copyRandomList(Node head) {
		Node deepCopyNode = head;
		Node successor = head;
		Map<Integer, Node> cache = new TreeMap<>();
		boolean flag = true;
		int index = 0;
		while (flag) {
			Node cNode = successor;
			int currentValue = cNode.val;
			Node cNextNode = cNode.next;
			Node cRandomNode = cNode.random;

			// Exit if Next Node is null
			if (cNextNode == null) {
				flag = false;
			}

			Node newNode = new Node(currentValue);

			if (cRandomNode != null) {
				int randomNodeValue = cRandomNode.val;
				if (!cache.containsKey(randomNodeValue)) {
					Node newRandomNode = new Node(randomNodeValue);
					cache.put(randomNodeValue, newRandomNode);
				}
				newNode.random = cache.get(randomNodeValue);
			}

			if (index == 0) {
				deepCopyNode = newNode;
				successor = deepCopyNode;
			} else {
				successor.next = newNode;
				successor = newNode;
			}
			// Cleanup Code
			index++;
		}
		return deepCopyNode;
	}

}
