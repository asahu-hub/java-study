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

}
