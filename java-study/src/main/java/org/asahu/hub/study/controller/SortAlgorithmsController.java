package org.asahu.hub.study.controller;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.asahu.hub.study.algorithms.ArrangeOperations;
import org.asahu.hub.study.algorithms.SortOperations;
import org.asahu.hub.study.utils.ExecutionTimeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortAlgorithmsController {

	@Autowired
	@Qualifier("MergeSort")
	private SortOperations<Integer> mergeSort;

	@Autowired
	@Qualifier("QuickSort")
	private SortOperations<Integer> quickSort;

	@Autowired
	@Qualifier("PnC")
	private ArrangeOperations<Integer> permutationAndCombination;

	@GetMapping("/merge-sort")
	public ResponseEntity<String> runMergeSort(@RequestParam(name = "array") Integer[] inputData) {
		int numberOfElementsReceived = inputData.length;
		Instant startInstance = Instant.now();
		Integer[] sortedData = mergeSort.sort(inputData);
		int numberOfElementsSorted = sortedData.length;
		Instant endInstance = Instant.now();
		long executionTimeDescription = ExecutionTimeCalculator.measureExecutionTimeInMillis(startInstance,
				endInstance);
		return ResponseEntity.ok("\nSorted Data: " + Arrays.toString(sortedData) + "\nNumber of Elements received: "
				+ numberOfElementsReceived + "\n Number of Elements Sorted: " + numberOfElementsSorted
				+ "\nTime (Millis):" + executionTimeDescription);
	}

	@GetMapping("/quick-sort")
	public ResponseEntity<String> runQuickSort(@RequestParam(name = "array") Integer[] inputData) {
		int numberOfElementsReceived = inputData.length;
		Instant startInstance = Instant.now();
		Integer[] sortedData = quickSort.sort(inputData);
		int numberOfElementsSorted = sortedData.length;
		Instant endInstance = Instant.now();
		long executionTimeDescription = ExecutionTimeCalculator.measureExecutionTimeInMillis(startInstance,
				endInstance);
		return ResponseEntity.ok("\nSorted Data: " + Arrays.toString(sortedData) + "\nNumber of Elements received: "
				+ numberOfElementsReceived + "\n Number of Elements Sorted: " + numberOfElementsSorted
				+ "\nTime (Millis):" + executionTimeDescription);
	}

	@GetMapping("/permutations")
	public ResponseEntity<String> runPermutations(@RequestParam(name = "array") Integer[] inputData,
			@RequestParam(name = "size", required = false, defaultValue = "0") int size) throws Exception {
		int numberOfElementsReceived = inputData.length;
		Instant startInstance = Instant.now();
		List<List<Integer>> permutatedData = permutationAndCombination.permutate(inputData, size);
		int numberOfPermutations = permutatedData.size();
		Instant endInstance = Instant.now();
		long executionTimeDescription = ExecutionTimeCalculator.measureExecutionTimeInMillis(startInstance,
				endInstance);
		return ResponseEntity.ok("\nAll Permutations: " + permutatedData + "\nNumber of Elements received: "
				+ numberOfElementsReceived + "\n Number of Permutations generated: " + numberOfPermutations
				+ "\nTime (Millis):" + executionTimeDescription);
	}

	@GetMapping("/combinations")
	public ResponseEntity<String> runCombinations(@RequestParam(name = "array") Integer[] inputData,
			@RequestParam(name = "size") int size) throws Exception {
		int numberOfElementsReceived = inputData.length;
		Instant startInstance = Instant.now();
		List<List<Integer>> permutatedData = permutationAndCombination.combine(inputData, size);
		int numberOfPermutations = permutatedData.size();
		Instant endInstance = Instant.now();
		long executionTimeDescription = ExecutionTimeCalculator.measureExecutionTimeInMillis(startInstance,
				endInstance);
		return ResponseEntity.ok("\nAll Combinations: " + permutatedData + " with size: " + size
				+ "\nNumber of Elements received: " + numberOfElementsReceived + "\n Number of Combinations generated: "
				+ numberOfPermutations + "\nTime (Millis):" + executionTimeDescription);
	}
}
