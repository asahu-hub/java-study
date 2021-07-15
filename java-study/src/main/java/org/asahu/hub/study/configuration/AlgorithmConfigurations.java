package org.asahu.hub.study.configuration;

import org.asahu.hub.study.algorithms.ArrangeOperations;
import org.asahu.hub.study.algorithms.SearchOperations;
import org.asahu.hub.study.algorithms.SortOperations;
import org.asahu.hub.study.algorithms.search.divideconquer.BinarySearch;
import org.asahu.hub.study.algorithms.sort.divideconquer.MergeSort;
import org.asahu.hub.study.algorithms.sort.divideconquer.PermutationAndCombination;
import org.asahu.hub.study.algorithms.sort.divideconquer.QuickSort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlgorithmConfigurations {

	@Bean(name = "BinarySearch")
	public SearchOperations<Integer> binarySearch() {
		return new BinarySearch();
	}

	@Bean(name = "MergeSort")
	public SortOperations<Integer> mergeSort() {
		return new MergeSort();
	}

	@Bean(name = "QuickSort")
	public SortOperations<Integer> quickSort() {
		return new QuickSort();
	}

	@Bean(name = "PnC")
	public ArrangeOperations<Integer> permutationAndCombination() {
		return new PermutationAndCombination();
	}
}