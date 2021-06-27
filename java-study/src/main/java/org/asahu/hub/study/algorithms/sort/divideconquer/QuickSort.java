/**
 * 
 */
package org.asahu.hub.study.algorithms.sort.divideconquer;

import org.asahu.hub.study.algorithms.SortOperations;

/**
 * A practical algorithm that is better than Merge Sort in terms of Space
 * Complexity.
 * 
 * Runtime Performance: <br/>
 * If N = number of array elements, then <br />
 * 1. Best Case: O(N) <br />
 * 2. Average Case: If pivot is chosen randomly, then O(N * Log N) <br />
 * 3. Worst Case: O (N^2)
 * 
 * Worst Case is defined as the case where the pivot (dividing element) does not
 * partition the array.
 * 
 * @author Akshay Sahu
 */
public class QuickSort implements SortOperations<Integer> {

	@Override
	public Integer[] sort(Integer[] inputData) {
		quickSort(inputData, 0, (inputData.length - 1));
		return inputData;
	}

	private void quickSort(Integer[] inputData, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int pivotElementIndex = getPivotElementIndex(startIndex, endIndex);
			// Sort the array by the pivot key
			partition(inputData, pivotElementIndex);
			// Sort the left side elements of the pivot key
			quickSort(inputData, startIndex, pivotElementIndex);
			// Sort the right side elements of the pivot key
			quickSort(inputData, pivotElementIndex + 1, endIndex);
		}
	}

	private int getPivotElementIndex(int startIndex, int endIndex) {
		return (startIndex + endIndex) / 2;
	}

	/**
	 * The method shall partition the source array, in linear time, as follows:
	 * <br />
	 * 1. It shall move all the elements < targetElement, before targetElementIndex
	 * <br/>
	 * 2. It shall move all the elements > targetElement, after targetElementIndex.
	 * <br/>
	 * 
	 * @param source            Source array to tbe partitioned
	 * @param pivotElementIndex Index of the pivot element.
	 * 
	 */
	private void partition(Integer[] source, int pivotElementIndex) {
		int pivotElement = source[pivotElementIndex];
		for (int i = 0; i < source.length; i++) {
			int currentElement = source[i];
			if (currentElement < pivotElement) {
				swap(source, pivotElementIndex, i);
			} else if (currentElement > pivotElement) {
				swap(source, i, pivotElementIndex);
			}
		}
	}

	private void swap(Integer[] array, int firstElementIndex, int secondElementIndex) {
		int tempElement = array[firstElementIndex];
		array[firstElementIndex] = array[secondElementIndex];
		array[secondElementIndex] = tempElement;
	}

}