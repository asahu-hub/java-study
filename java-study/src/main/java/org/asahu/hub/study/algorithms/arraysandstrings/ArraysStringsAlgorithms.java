package org.asahu.hub.study.algorithms.arraysandstrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.commons.collections4.map.HashedMap;
import org.asahu.hub.study.algorithms.sort.divideconquer.PermutationAndCombination;
import org.springframework.stereotype.Component;

@Component
public class ArraysStringsAlgorithms {

	private final PermutationAndCombination permutationsAndCombinations;

	public ArraysStringsAlgorithms(PermutationAndCombination permutationsAndCombinations) {
		this.permutationsAndCombinations = permutationsAndCombinations;
	}

	/**
	 * <b> Definitions </b>: <br/>
	 * 1. SubArray:
	 * <p>
	 * A subarray is a contiguous sequence of elements within an array. For
	 * instance, the subarrays of the array {1, 2, 1} would be {1}, {2}, {1, 2}, {2,
	 * 1}, {1, 2, 1}, {}.
	 * </p>
	 * <br/>
	 * 2. SubString:
	 * <p>
	 * A substring is exactly the same thing as a subarray but in the context of
	 * strings. For instance, the substrings of the string "ara" would be "a", "r",
	 * "ar", "ra", "ara", "".
	 * </p>
	 * <br/>
	 * 3. Subsequence:
	 * <p>
	 * Both in mathematics and computer science, a subsequence is a sequence that
	 * can be derived from another sequence by deleting some or no elements without
	 * changing the order of the remaining elements. This means a subsequence is a
	 * generalized subarray, where the rule of contiguity does not apply. For
	 * instance, the subsequences of the sequence <A, B, A> would be <A>, <B>, <A,
	 * B>, <B, A>, <A, A>, <A, B, A>, <>.
	 * </p>
	 * <br/>
	 * 4. Constraints: <br/>
	 * 1. 0 <= s.length <= 5 * 104 <br/>
	 * 2. s consists of English letters, digits, symbols and spaces.
	 * 
	 * @param s The source string
	 * 
	 * @return Length of longest substring from source string.
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 1) {
			return s.length();
		}
		if (!s.isEmpty()) {
			return longestSubstrings(s).descendingKeySet().first();
		}
		return 0;
	}

	public String longestSubstringWithoutRepetitions(String s) {
		if (s.length() == 1) {
			return s;
		}
		if (!s.isEmpty()) {
			return longestSubstrings(s).descendingMap().firstEntry().getValue();
		}
		return s;
	}

	private TreeMap<Integer, String> longestSubstrings(String s) {
		TreeMap<Integer, String> uniqueSubstrings = new TreeMap<>();
		char[] allCharacters = s.toCharArray();
		int index = 0;
		String continuousSubString = "";
		while (index < s.length()) {
			char cChar = allCharacters[index];
			if (continuousSubString.contains("" + cChar)) {
				uniqueSubstrings.put(continuousSubString.length(), continuousSubString);
				continuousSubString = "";
			}
			continuousSubString += cChar;
			++index;
		}
		uniqueSubstrings.put(continuousSubString.length(), continuousSubString);
		return uniqueSubstrings;
	}

	/**
	 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
	 * signed integer (similar to C/C++'s atoi function).
	 * 
	 * The algorithm for myAtoi(string s) is as follows:
	 * 
	 * Read in and ignore any leading whitespace. Check if the next character (if
	 * not already at the end of the string) is '-' or '+'. Read this character in
	 * if it is either. This determines if the final result is negative or positive
	 * respectively. Assume the result is positive if neither is present. Read in
	 * next the characters until the next non-digit charcter or the end of the input
	 * is reached. The rest of the string is ignored. Convert these digits into an
	 * integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the
	 * integer is 0. Change the sign as necessary (from step 2). If the integer is
	 * out of the 32-bit signed integer range [-231, 231 - 1], then clamp the
	 * integer so that it remains in the range. Specifically, integers less than
	 * -231 should be clamped to -231, and integers greater than 231 - 1 should be
	 * clamped to 231 - 1. Return the integer as the final result. Note:
	 * 
	 * Only the space character ' ' is considered a whitespace character. Do not
	 * ignore any characters other than the leading whitespace or the rest of the
	 * string after the digits.
	 * 
	 * <br/>
	 * <b>Constraints</b>: <br/>
	 * 1. 0 <= s.length <= 200 <br/>
	 * 2. s consists of English letters (lower-case and upper-case), digits (0-9), '
	 * ', '+', '-', and '.'. <br/>
	 * 
	 * @param s String to be converted to Integer
	 * 
	 * @return Parsed Integer.
	 */
	public int atoi(String s) {
		int result = 0;
		boolean isNegative = false;
		boolean isSignPresent = false;
		int maxValue = Integer.MAX_VALUE;
		int minValue = Integer.MIN_VALUE;

		Map<String, Integer> DIGITS = new HashedMap<>();
		for (int i = 0; i <= 10; i++) {
			DIGITS.put("" + i, i);
		}

		if (!s.isEmpty()) {
			String strWithoutWhitespaces = s.replaceAll("^\\s+", "").replaceAll("", "");
			char firstChar = strWithoutWhitespaces.charAt(0);
			char[] allCharacters = strWithoutWhitespaces.toCharArray();
			int allCharsLen = allCharacters.length;
			if (firstChar == '-') {
				isNegative = true;
				isSignPresent = true;
			} else if (firstChar == '+') {
				isNegative = false;
				isSignPresent = true;
			}

			int numbersLen = isSignPresent ? allCharsLen - 1 : allCharsLen;
			int j = isSignPresent ? 1 : 0;
			int counter = 0;

			int[] numbers = new int[numbersLen];
			for (; j < allCharsLen; j++) {
				char cChar = allCharacters[j];
				int cNumber = DIGITS.getOrDefault("" + cChar, -1);
				if (cNumber != -1) {
					numbers[counter] = cNumber;
					++counter;
				} else {
					break;
				}
			}

			int totalPositions = numbers.length;
			if (totalPositions > 0) {
				for (int i = 0; i < numbers.length; i++) {
					int cNumber = numbers[i];
					result += cNumber * Math.pow(10, --totalPositions);
				}
			}
		}

		result = isNegative ? -result : result;
		result = result > maxValue ? maxValue : result;
		result = result < minValue ? minValue : result;
		return result;
	}

	/**
	 * 
	 * Given an integer array nums, return all the triplets [nums[i], nums[j],
	 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
	 * nums[k] == 0.
	 * 
	 * Notice that the solution set must not contain duplicate triplets.
	 */
	public List<List<Integer>> threeSum(int[] nums) throws Exception {
		if (nums.length == 0 || nums.length == 1) {
			return Collections.emptyList();
		}

		Integer[] source = Arrays.stream(nums).boxed().toArray(Integer[]::new);
		return permutationsAndCombinations.combine(source, 3).stream()
				.map(a -> a.stream().sorted().collect(Collectors.toList())).filter(combination -> {
					if (combination.stream().mapToInt(a -> a).sum() == 0) {
						return true;
					}
					return false;
				}).collect(Collectors.toSet()).stream().collect(Collectors.toList());
	}

	/**
	 * Given an integer array nums sorted in non-decreasing order, remove the
	 * duplicates in-place such that each unique element appears only once. The
	 * relative order of the elements should be kept the same.
	 * 
	 * Since it is impossible to change the length of the array in some languages,
	 * you must instead have the result be placed in the first part of the array
	 * nums. More formally, if there are k elements after removing the duplicates,
	 * then the first k elements of nums should hold the final result. It does not
	 * matter what you leave beyond the first k elements.
	 * 
	 * Return k after placing the final result in the first k slots of nums.
	 * 
	 * Do not allocate extra space for another array. You must do this by modifying
	 * the input array in-place with O(1) extra memory.
	 */
	public int inPlaceRemoveDuplicates(int[] nums) {
		int numberOfDistinctElements = nums.length;
		if (numberOfDistinctElements == 0 || numberOfDistinctElements == 1) {
			return numberOfDistinctElements;
		}

		int duplicateElementMarker = 200;
		int totalElements = nums.length;
		for (int i = 0; i < totalElements; i++) {
			int cElement = nums[i];
			if (cElement == 200) {
				continue;
			} else {
				for (int j = 0; j < totalElements; j++) {
					int scannedElement = nums[j];
					if (i == j) {
						continue;
					} else {
						if (cElement == scannedElement) {
							numberOfDistinctElements -= 1;
							nums[j] = duplicateElementMarker;
						}
					}
				}
			}
		}
		Arrays.sort(nums);
		return numberOfDistinctElements;
	}

	/**
	 * Given two non-negative integers num1 and num2 represented as strings, return
	 * the product of num1 and num2, also represented as a string.
	 * 
	 * Note: You must not use any built-in BigInteger library or convert the inputs
	 * to integer directly.
	 */
	public String multiply(String num1, String num2) {
		String zero = "0";

		if (num1 == null || num2 == null) {
			return zero;
		}
		num1 = num1.trim();
		num2 = num2.trim();
		if (num1.isEmpty() || num2.isEmpty()) {
			return "";
		} else if (num1.equals(zero) || num2.equals(zero)) {
			return zero;
		}

		long num1_i = atoi2(num1);
		long num2_i = atoi2(num2);
		long product = num1_i * num2_i;

		return "" + product;
	}

	private long atoi2(String s) {
		long result = 0;
		Map<String, Integer> DIGITS = new HashMap<>();
		for (int i = 0; i <= 9; i++) {
			DIGITS.put("" + i, i);
		}
		char[] allCharacters = s.toCharArray();
		int numbersLen = s.length();
		int radix = s.length();
		for (int j = 0; j < numbersLen; j++) {
			char cChar = allCharacters[j];
			int cNumber = DIGITS.get("" + cChar);
			result += cNumber * Math.pow(10, --radix);
		}
		return result;
	}
}