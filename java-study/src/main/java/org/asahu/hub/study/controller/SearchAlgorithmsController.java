package org.asahu.hub.study.controller;

import java.time.Instant;

import org.asahu.hub.study.algorithms.SearchOperations;
import org.asahu.hub.study.utils.ExecutionTimeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchAlgorithmsController {

	@Autowired
	@Qualifier("BinarySearch")
	public SearchOperations<Integer> binarySearch;

	@GetMapping("/binary-search")
	public ResponseEntity<String> runBinarySearch(@RequestParam(name = "array") Integer[] inputData,
			@RequestParam(name = "searchElement") Integer searchElement) {
		Instant startInstance = Instant.now();
		int indexOfElement = binarySearch.indexOf(inputData, searchElement);
		Instant endInstance = Instant.now();
		long executionTimeDescription = ExecutionTimeCalculator.measureExecutionTimeInNanos(startInstance, endInstance);
		return ResponseEntity.ok(
				"\nElement Index found at: " + indexOfElement + "\nExecution Time (Nanos):" + executionTimeDescription);
	}

}
