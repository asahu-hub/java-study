/**
 * 
 */
package org.asahu.hub.study.patterns;

/**
 * A class representing a perfect Singleton Object.
 * 
 * @author Akshay Sahu
 */
public class SingletonCalculator {

	/**
	 * 
	 * Steps involved:
	 * 
	 * Step 1: Declare the instance of the class as private static volatile.
	 * Volatile because certain times Compiler while performing code optimization,
	 * could make an object of a Class, before its construction. This is a rare
	 * possibility.
	 */
	private static volatile SingletonCalculator instance;

	/**
	 * Step 2: Declare a private constructor
	 */
	private SingletonCalculator() {

	}

	/**
	 * Step 3: Declaring a public static method that gives an instance of the
	 * Singleton Class.
	 * 
	 * Apply double checked-locking to ensure whether we need synchornization or
	 * not.
	 */
	public static SingletonCalculator getInstance() {
		if (instance == null) {
			synchronized (SingletonCalculator.class) {
				if (instance == null) {
					instance = new SingletonCalculator();
				}
			}
		}
		return instance;
	} // End getInstance method.

	/**
	 * Step 4: Declare any other public methods.
	 */
	public int add(int x, int y) {
		return x + y;
	}

} // End SingletonPatternClass