package org.asahu.hub.study.test.datastructures.fb.graphs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.asahu.hub.study.datastructures.fb.graphs.BinarySearchTree_FB;
import org.asahu.hub.study.datastructures.fb.graphs.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Unit")
@DisplayName("Testing Binary Search Tree Data Structure")
public class TestGraphs_FB {
	private final BinarySearchTree_FB bst_fb = new BinarySearchTree_FB();

	@Nested
	@DisplayName(" boolean isValidBST(TreeNode root)")
	class isValidBSTTests {

		@Test
		@DisplayName("Input: [2,1,3] -> Output: false")
		public void testLinkedListAddition_ValidIntegers() {
			TreeNode rootNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
			assertTrue(bst_fb.isValidBST(rootNode));

		}

		@Test
		@DisplayName("Input: [5,1,4,null,null,3,6] -> Output: false")
		public void testLinkedListAddition_ZeroArray() {
			TreeNode rootNode = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
			assertFalse(bst_fb.isValidBST(rootNode));
		}

		@Test
		@DisplayName("Input: [1, 1] -> Output: false")
		public void testIsValidBST_Duplicates() {
			TreeNode rootNode = new TreeNode(1);
			assertFalse(bst_fb.isValidBST(rootNode));
		}

	} // End isValidBSTTests

}
