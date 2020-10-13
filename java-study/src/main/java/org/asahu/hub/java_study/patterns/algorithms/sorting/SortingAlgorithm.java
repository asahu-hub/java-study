package org.asahu.hub.java_study.patterns.algorithms.sorting;

import java.util.LinkedList;
import java.util.List;

public interface SortingAlgorithm<I> {

	public default LinkedList<I> sort(List<I> input) {
		if (input == null || input.isEmpty()) {
			return null;
		}
		return new LinkedList<I>();
	} // End sort
	
	public int sortsize();
	
} // End SortingAlgorithm