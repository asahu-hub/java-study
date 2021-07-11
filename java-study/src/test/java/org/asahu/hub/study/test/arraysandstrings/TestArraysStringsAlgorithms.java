package org.asahu.hub.study.test.arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.asahu.hub.study.algorithms.arraysandstrings.ArraysStringsAlgorithms;
import org.asahu.hub.study.algorithms.sort.divideconquer.PermutationAndCombination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Unit")
@DisplayName("Testing Arrays and String Algorithms")
public class TestArraysStringsAlgorithms {

	private PermutationAndCombination pnc = new PermutationAndCombination();
	private ArraysStringsAlgorithms asAlgorithms = new ArraysStringsAlgorithms(pnc);

	@Nested
	@DisplayName("int lengthOfLongestSubstring(String s)")
	class lengthOfLongestSubstringTests {

		@Test
		@DisplayName("Input: abcabcbb -> Output: 3 -> Longest Substring = abc")
		public void testLengthOfLongestSubstringTests_with_SingleSubstring() {
			String testString = "abcabcbb";
			assertEquals(3, asAlgorithms.lengthOfLongestSubstring(testString));
		}

		@Test
		@DisplayName("Input: bbbbb -> Output: 1 -> Longest Substring = b")
		public void testLengthOfLongestSubstringTests_with_AllMatchingCharacters() {
			String testString = "bbbbb";
			assertEquals(1, asAlgorithms.lengthOfLongestSubstring(testString));
		}

		@Test
		@DisplayName("Input: pwwkew -> Output: 3 -> Longest Substring = wke")
		public void testLengthOfLongestSubstringTests_with_SubstringAndSubsequence() {
			String testString = "pwwkew";
			assertEquals(3, asAlgorithms.lengthOfLongestSubstring(testString));
		}

		@Test
		@DisplayName("Input:  -> Output: 0 -> Longest Substring =  ")
		public void testLengthOfLongestSubstringTests_with_EmptyString() {
			String testString = "";
			assertEquals(0, asAlgorithms.lengthOfLongestSubstring(testString));
		}
	} // End lengthOfLongestSubstringTests

	@Nested
	@DisplayName("int atoi(String s)")
	class AtoITests {

		@Test
		@DisplayName("Input: '42' -> Output: 42")
		public void testAtoI_With_OnlyIntegers() {
			String testString = "42";
			assertEquals(42, asAlgorithms.atoi(testString));
		}

		@Test
		@DisplayName("Input: '   -42' -> Output: -42")
		public void testAtoI_With_Whitespace_NegativeInteger() {
			String testString = "    -42";
			assertEquals(-42, asAlgorithms.atoi(testString));
		}

		@Test
		@DisplayName("Input: '4193 with words' -> Output: 4193")
		public void testAtoI_With_Integers_And_Text() {
			String testString = "4193 with words";
			assertEquals(4193, asAlgorithms.atoi(testString));
		}

		@Test
		@DisplayName("Input: 'words and 987' -> Output: 0")
		public void testAtoI_With_Text_And_Integers() {
			String testString = "words and 987";
			assertEquals(0, asAlgorithms.atoi(testString));
		}

		@Test
		@DisplayName("Input: '-91283472332' -> Output: -2147483648")
		public void testAtoI_With_Integer_LessThan_LowerBound() {
			String testString = "-91283472332";
			assertEquals(-2147483648, asAlgorithms.atoi(testString));
		}
	}// End AtoITests

	@Nested
	@DisplayName("List<List<Integer>> threeSum(int[] numbers)")
	class ThreeSumTests {

		@Test
		@DisplayName("Input: [-1,0,1,2,-1,-4] -> Output: [[-1,-1,2],[-1,0,1]]")
		public void testThreeSum_With_ValidIntegers() throws Exception {
			int[] testArray = { -1, 0, 1, 2, -1, -4 };
			Object[] fArray = { -1, -1, 2 };
			Object[] sArray = { -1, 0, 1 };
			List<List<Integer>> output = asAlgorithms.threeSum(testArray);
			// System.out.print(output);

			assertTrue(
					Arrays.equals(output.get(0).toArray(), fArray) || Arrays.equals(output.get(0).toArray(), sArray));
		}

		@Test
		@DisplayName("Input: [] -> Output: []")
		public void testThreeSum_With_EmptyIntArray() throws Exception {
			int[] testArray = new int[0];
			List<List<Integer>> output = asAlgorithms.threeSum(testArray);
			assertTrue(output.isEmpty());
		}

		@Test
		@DisplayName("Input: [0] -> Output: []")
		public void testThreeSum_With_ArrayWithZeros() throws Exception {
			int[] testArray = new int[1];
			List<List<Integer>> output = asAlgorithms.threeSum(testArray);
			assertTrue(output.isEmpty());
		}

	} // End ThreeSumTests

	@Nested
	@DisplayName("int inPlaceRemoveDuplicates(int[] nums)")
	class RemoveDuplicatesTests {

		@Test
		@DisplayName("Input: [1,1,2] -> Output: 2")
		public void testInPlaceRemoveDuplicates_With_ValidIntegers() throws Exception {
			int[] testArray = { 1, 1, 2 };
			assertEquals(2, asAlgorithms.inPlaceRemoveDuplicates(testArray));
		}

		@Test
		@DisplayName("Input: [1] -> Output: 1")
		public void testInPlaceRemoveDuplicates_With_OneInteger() throws Exception {
			int[] testArray = { 1 };
			assertEquals(1, asAlgorithms.inPlaceRemoveDuplicates(testArray));
		}

		@Test
		@DisplayName("Input: [] -> Output: 0")
		public void testInPlaceRemoveDuplicates_With_EmptyIntegers() throws Exception {
			int[] testArray = {};
			assertEquals(0, asAlgorithms.inPlaceRemoveDuplicates(testArray));
		}

	} // End RemoveDuplicatesTests

	@Nested
	@DisplayName("String multiply(String num1, String num2)")
	class StringMultiplicationTests {
		@Test
		@DisplayName("Input: '9', '9' -> Output: '81'")
		public void testMultiply_With_ValidIntegers() throws Exception {
			String testValue1 = "6913259244";
			String testValue2 = "71103343";
			String expectedOutputString = "491555843274052692";
			assertEquals(expectedOutputString, asAlgorithms.multiply(testValue1, testValue2));
		}

	} // End StringMultiplicationTests

	@Nested
	@DisplayName("int[] productExceptSelf(int[] nums)")
	class ProductExceptSelfTests {

		@Test
		@DisplayName("Input: [1,2,3,4] -> Output: [24,12,8,6]")
		public void testMultiply_With_PositiveNumbers_1() throws Exception {
			int[] testArray = { 1, 2, 3, 4 };
			int[] expectedArray = { 24, 12, 8, 6 };
			assertTrue(Arrays.equals(expectedArray, asAlgorithms.productExceptSelf(testArray)));
		}

		@Test
		@DisplayName("Input: [-1,1,0,-3,3] -> Output: [0,0,9,0,0]")
		public void testMultiply_With_PositiveNumbers_2() throws Exception {
			int[] testArray = { -1, 1, 0, -3, 3 };
			int[] expectedArray = { 0, 0, 9, 0, 0 };
			assertTrue(Arrays.equals(expectedArray, asAlgorithms.productExceptSelf(testArray)));
		}

	} // End StringMultiplicationTests

	@Nested
	@DisplayName("boolean isPalindrome(String s)")
	class IsPalindromeTests {

		@Test
		@DisplayName("Input: 'A man, a plan, a canal: Panama' -> Output: true")
		public void testIsPalindrome_With_Valid_String() {
			String testString = "A man, a plan, a canal: Panama";
			assertTrue(asAlgorithms.isPalindrome(testString));
		}

		@Test
		@DisplayName("Input: 'race a car' -> Output: false")
		public void testIsPalindrome_With_InValid_String() {
			String testString = "race a car";
			assertFalse(asAlgorithms.isPalindrome(testString));
		}

	} // End StringMultiplicationTests
}
