package org.asahu.hub.study.controller;

import java.time.Instant;
import java.util.Arrays;

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
	public SortOperations<Integer> mergeSort;

	@Autowired
	@Qualifier("QuickSort")
	public SortOperations<Integer> quickSort;

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
}
