package org.asahu.hub.study.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.asahu.hub.study.patterns.algorithms.divideconquer.DivideAndConquerAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DivideAndConquerAlgorithmsController {

	@Autowired
	@Qualifier("BinarySearch")
	public DivideAndConquerAlgorithm<Integer> binarySearch;

	@GetMapping("/binary-search/small")
	public ResponseEntity<String> runBinarySearchForSmallDataset(@RequestParam(name = "array") Integer[] inputData,
			@RequestParam(name = "searchElement") Integer searchElement) {
		Instant startTime = Instant.now();
		int indexOfElement = binarySearch.indexOf(inputData, searchElement);
		String executionTimeDescription = measureExecutionTime(startTime, Instant.now());
		return ResponseEntity.ok("\nElement Index found at: " + indexOfElement + "\n" + executionTimeDescription);
	}

	private String measureExecutionTime(Instant startTime, Instant endTime) {
		return "Execution completed in: " + ChronoUnit.NANOS.between(startTime, endTime) + " nanoseconds.";
	}

}
