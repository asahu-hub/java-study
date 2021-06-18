package org.asahu.hub.study.algorithms;

public interface SearchOperations<T> {

	default int indexOf(T[] inputData, T element) {
		return -1;
	}

	default boolean isPresent(T[] inputData, T element) {
		return Boolean.FALSE;
	}
}
