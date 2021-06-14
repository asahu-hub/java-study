package org.asahu.hub.study.patterns.algorithms.divideconquer.search;

import java.util.Arrays;

import org.asahu.hub.study.patterns.algorithms.divideconquer.DivideAndConquerAlgorithm;

public class BinarySearch implements DivideAndConquerAlgorithm<Integer> {

	/**
	 * The method performs binary search to determine the index of the searched
	 * element.
	 * 
	 * The worst case runtime of this algorithm is Big-O(log N)
	 * 
	 * @param inputData Sorted data that is to be searched for determining the
	 *                  presence of an element.
	 * @param element   The searched element.
	 * 
	 * @return The index of the searched element. If the element is not found, then
	 */
	@Override
	public int indexOf(Integer[] inputData, Integer element) {
		return binarySearch(inputData, element, 0);
	}

	public int binarySearch(Integer[] inputData, Integer element, int midIndex) {
		int totalElements = inputData.length;
		if (totalElements == 0) {
			return -1;
		}
		int mid = totalElements / 2;
		int midElement = inputData[mid];
		if (midElement == element) {
			return inputData[mid];
		} else if (element < midElement) {
			return binarySearch(Arrays.copyOfRange(inputData, 0, mid), element, mid);
		} else if (element > midElement) {
			return binarySearch(Arrays.copyOfRange(inputData, mid + 1, totalElements), element, mid);
		}
		return -1;
	}

}
