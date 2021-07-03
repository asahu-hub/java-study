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
		@DisplayName("Input: abcabcbb -> Output: 3 -> Description: Longest Substring = abc and length = 3")
		public void testLengthOfLongestSubstringTests_with_SingleSubstring() {
			String testString = "abcabcbb";
			assertEquals(3, asAlgorithms.lengthOfLongestSubstring(testString));
			System.out.println(asAlgorithms.longestSubstringWithoutRepetitions(testString));
		}

		@Test
		@DisplayName("Input: bbbbb -> Output: 1 -> Description: Longest Substring = b and length = 1")
		public void testLengthOfLongestSubstringTests_with_AllMatchingCharacters() {
			String testString = "bbbbb";
			assertEquals(1, asAlgorithms.lengthOfLongestSubstring(testString));
			System.out.println(asAlgorithms.longestSubstringWithoutRepetitions(testString));
		}

		@Test
		@DisplayName("Input: pwwkew -> Output: 3 -> Description: Longest Substring = wke and length = 3")
		public void testLengthOfLongestSubstringTests_with_SubstringAndSubsequence() {
			String testString = "pwwkew";
			assertEquals(3, asAlgorithms.lengthOfLongestSubstring(testString));
			System.out.println(asAlgorithms.longestSubstringWithoutRepetitions(testString));
		}

		@Test
		@DisplayName("Input:  -> Output: 0 -> Description: Longest Substring =  and length = 0")
		public void testLengthOfLongestSubstringTests_with_EmptyString() {
			String testString = "";
			assertEquals(0, asAlgorithms.lengthOfLongestSubstring(testString));
			System.out.println(asAlgorithms.longestSubstringWithoutRepetitions(testString));
		}

	}

}
