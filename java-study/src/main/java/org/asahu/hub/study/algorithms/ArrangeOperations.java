package org.asahu.hub.study.algorithms;

import java.util.ArrayList;
import java.util.List;

public interface ArrangeOperations<T> {

	default List<List<Integer>> rearrange(T[] inputData, int size) throws Exception {
		return new ArrayList<>();
	}

	default List<List<Integer>> permutate(T[] inputData, int size) throws Exception {
		return new ArrayList<>();
	}

	default List<List<Integer>> combine(T[] inputData, int size) throws Exception {
		return new ArrayList<>();
	}
}
