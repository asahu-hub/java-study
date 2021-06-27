package org.asahu.hub.study.algorithms.sort.divideconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.asahu.hub.study.algorithms.ArrangeOperations;
import org.paukov.combinatorics3.Generator;
import org.paukov.combinatorics3.PermutationGenerator.TreatDuplicatesAs;

public class PermutationAndCombination implements ArrangeOperations<Integer> {

	@Override
	public List<List<Integer>> permutate(Integer[] inputData, int size) throws Exception {
		final List<List<Integer>> allPermutations = new ArrayList<>();
		CompletableFuture.runAsync(() -> {
			Generator.permutation(Arrays.asList(inputData)).simple(TreatDuplicatesAs.IDENTICAL).stream()
					.collect(Collectors.toCollection(() -> allPermutations));
		}).get();
		return allPermutations;
	}

	@Override
	public List<List<Integer>> combine(Integer[] inputData, int size) throws Exception {
		final List<List<Integer>> allCombinations = new ArrayList<>();
		CompletableFuture.runAsync(() -> {
			Generator.combination(Arrays.asList(inputData)).simple(size).stream()
					.collect(Collectors.toCollection(() -> allCombinations));
		}).get();
		return allCombinations;
	}
}
