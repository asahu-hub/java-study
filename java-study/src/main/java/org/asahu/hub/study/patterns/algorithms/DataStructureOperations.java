package org.asahu.hub.study.patterns.algorithms;

public interface DataStructureOperations<T> {

	default T[] sort(T[] inputData) {
		return inputData;
	}

	default int indexOf(T[] inputData, T element) {
		return -1;
	}

	default boolean isPresent(T[] inputData, T element) {
		return Boolean.FALSE;
	}
}
