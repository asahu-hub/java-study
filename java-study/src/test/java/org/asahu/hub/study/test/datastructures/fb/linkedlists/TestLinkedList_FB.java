package org.asahu.hub.study.test.datastructures.fb.linkedlists;

import org.asahu.hub.study.datastructures.fb.linkedlists.LinkedList_FB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Unit")
@DisplayName("Testing Linked List Data-structure")
public class TestLinkedList_FB {
	private final LinkedList_FB ll_fb = new LinkedList_FB();

	@Nested
	@DisplayName(" ListNode addTwoNumbers(ListNode l1, ListNode l2)")
	class addTwoNumbersTests {

		@Test
		@DisplayName("Input: [2,4,3], [5,6,4] -> Output: [7,0,8]")
		public void testLinkedListAddition_ValidIntegers() {
			int[] firstList = { 2, 4, 3 };
			int[] secondList = { 5, 6, 4 };
			ll_fb.addTwoNumbers(ll_fb.init(firstList), ll_fb.init(secondList));

		}

		@Test
		@DisplayName("Input: [0], [0] -> Output: [0]")
		public void testLinkedListAddition_ZeroArray() {
			int[] firstList = { 0 };
			int[] secondList = { 0 };
			ll_fb.addTwoNumbers(ll_fb.init(firstList), ll_fb.init(secondList));
		}

		@Test
		@DisplayName("Input: [9,9,9,9,9,9,9], [9,9,9,9] -> Output: [8,9,9,9,0,0,0,1]")
		public void testLinkedListAddition_MismatchingArrayLengths() {
			int[] firstList = { 9, 9, 9, 9, 9, 9, 9 };
			int[] secondList = { 9, 9, 9, 9 };
			ll_fb.addTwoNumbers(ll_fb.init(firstList), ll_fb.init(secondList));
		}

	} // End addTwoNumbersTests

	@Nested
	@DisplayName("ListNode mergeTwoLists(ListNode l1, ListNode l2)")
	class mergeTwoListsTests {

		@Test
		@DisplayName("Input: [1,2,4], [1,3,4] -> Output: [1,1,2,3,4,4]")
		public void testMergeTwoLists_ValidIntegers() {
			int[] firstList = { 1, 2, 4 };
			int[] secondList = { 1, 3, 4 };
			ll_fb.mergeTwoLists(ll_fb.init(firstList), ll_fb.init(secondList));
		}

		@Test
		@DisplayName("Input: [], [] -> Output: []")
		public void testMergeTwoLists_EmptyArray() {
			int[] firstList = {};
			int[] secondList = {};
			ll_fb.mergeTwoLists(ll_fb.init(firstList), ll_fb.init(secondList));
		}

		@Test
		@DisplayName("Input: [], [0] -> Output: [0]")
		public void testMergeTwoLists_OneEmptyArray() {
			int[] firstList = {};
			int[] secondList = { 0 };
			ll_fb.mergeTwoLists(ll_fb.init(firstList), ll_fb.init(secondList));
		}

	} // End mergeTwoListsTests

}
