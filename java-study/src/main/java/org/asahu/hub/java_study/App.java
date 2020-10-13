package org.asahu.hub.java_study;

import static java.lang.System.out;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.asahu.hub.java_study.patterns.SingletonCalculator;

public class App {
	App other;

	public static void main(String[] args) {
		App app = new App();
		app.testSingletonPattern();
	}

	private void testSingletonPattern() {
		SingletonCalculator sc = SingletonCalculator.getInstance();
		out.println("" + sc.add(10, 2));
		SingletonCalculator sc1 = SingletonCalculator.getInstance();
		out.println(sc.equals(sc1));
		SingletonCalculator sc2 = SingletonCalculator.getInstance();
		out.println(sc2.equals(sc));
	}

} // End App