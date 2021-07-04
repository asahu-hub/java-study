package org.asahu.hub.study.algorithms.arraysandstrings;

import java.util.TreeMap;

public class ArraysStringsAlgorithms {

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
		if (!s.trim().isEmpty()) {

		}

		return 0;
	}

}
