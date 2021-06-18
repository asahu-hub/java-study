package org.asahu.hub.study.algorithms;

public interface SortOperations<T> {

	default T[] sort(T[] inputData) {
		return inputData;
	}
}
