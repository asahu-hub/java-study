package org.asahu.hub.study.test.arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.asahu.hub.study.algorithms.arraysandstrings.ArraysStringsAlgorithms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Unit")
@DisplayName("Testing Arrays and String Algorithms")
public class TestArraysStringsAlgorithms {

	private ArraysStringsAlgorithms asAlgorithms = new ArraysStringsAlgorithms();

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
	} // End AtoITests

}
