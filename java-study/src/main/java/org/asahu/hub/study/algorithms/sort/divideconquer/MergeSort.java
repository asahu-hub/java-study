/**
 * 
 */
package org.asahu.hub.study.algorithms.sort.divideconquer;

import org.asahu.hub.study.algorithms.SortOperations;

/**
 * @author Akshay Sahu
 */
public class MergeSort implements SortOperations<Integer> {

	@Override
	public Integer[] sort(Integer[] inputData) {

		return inputData;
	}

	private Integer[] merge(Integer[] firstArray, Integer[] secondArray) {
		int firstArrayStartIndex = 0;
		int firstArrayCount = firstArray.length;

		int secondArrayCount = secondArray.length;
		int secondArrayStartIndex = 0;

		int newarrayCount = firstArrayCount + secondArrayCount;

		Integer[] sortedArray = new Integer[newarrayCount];

		return sortedArray;
	}

}