package org.asahu.hub.study.configuration;

import org.asahu.hub.study.patterns.algorithms.divideconquer.DivideAndConquerAlgorithm;
import org.asahu.hub.study.patterns.algorithms.divideconquer.search.BinarySearch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlgorithmConfigurations {

	@Bean(name = "BinarySearch")
	public DivideAndConquerAlgorithm<Integer> binarySearch() {
		return new BinarySearch();
	}

}
