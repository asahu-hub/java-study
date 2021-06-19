/**
 * 
 */
package org.asahu.hub.study.algorithms.sort.divideconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.asahu.hub.study.algorithms.SortOperations;

/**
 * @author Akshay Sahu
 */
public class MergeSort implements SortOperations<Integer> {

	@Override
	public Integer[] sort(Integer[] inputData) {
		return mergeSort(inputData);
	}

	private Integer[] mergeSort(Integer[] iArray) {
		int aLen = iArray.length;
		if (aLen == 1 || aLen == 0) {
			return iArray;
		}

		if (aLen == 2) {
			Integer[] fArray = { iArray[0] };
			Integer[] sArray = { iArray[1] };
			return merge(fArray, sArray);
		}

		int midIndex = iArray.length / 2;
		Integer[] fArray = mergeSort(Arrays.copyOfRange(iArray, 0, midIndex));
		Integer[] sArray = mergeSort(Arrays.copyOfRange(iArray, midIndex, iArray.length));
		return merge(fArray, sArray);
	}

	/**
	 * The method merges elements of two sorted arrays.
	 * 
	 * Runtime -> Worst-Case -> O(n)
	 * 
	 * @return A sorted array
	 */
	private Integer[] merge(Integer[] fArray, Integer[] sArray) {
		int sIndex = 0;
		int nIndex = 0;

		int nArrayCount = (fArray.length + sArray.length);
		Integer[] mergedArray = new Integer[nArrayCount];

		while (nIndex < nArrayCount) {
			int cElement = -1;

			// If second array is empty, then continue adding elements from first array.
			if (sArray.length == 0) {
				cElement = fArray[sIndex];
				fArray = pop(fArray);

			}
			// If first array is empty, then continue adding elements from second array.
			else if (fArray.length == 0) {
				cElement = sArray[sIndex];
				sArray = pop(sArray);
			}
			// Check first elements of both array.

			// If first element of second array is smaller than first element of first
			// array, then add it to new array and remove the element from second array.
			else if (sArray[sIndex] < fArray[sIndex]) {
				cElement = sArray[sIndex];
				sArray = pop(sArray);
			}

			// If first element of first array is smaller than first element of second
			// array, then add it to new array and remove the element from first array.
			else if (fArray[sIndex] < sArray[sIndex]) {
				cElement = fArray[sIndex];
				fArray = pop(fArray);
			}
			mergedArray[nIndex] = cElement;
			++nIndex;
		}
		return mergedArray;
	}

	private Integer[] pop(Integer[] array) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
		list.remove(0);
		return list.toArray(new Integer[array.length - 1]);
	}

}