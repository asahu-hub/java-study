package org.asahu.hub.study.utils;

import java.time.Duration;
import java.time.Instant;

public class ExecutionTimeCalculator {

	public static long measureExecutionTimeInNanos(Instant startInstant, Instant endInstant) {
		return calculateDurationBetween(startInstant, endInstant).toNanos();
	}

	public static long measureExecutionTimeInMillis(Instant startInstant, Instant endInstant) {
		return calculateDurationBetween(startInstant, endInstant).toMillis();
	}

	private static Duration calculateDurationBetween(Instant startInstant, Instant endInstant) {
		return Duration.between(startInstant, endInstant);
	}
}
