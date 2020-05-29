/**
 * 
 */
package org.asahu.hub.java_study.patterns;

/**
 * A class representing a perfect Immutable Object.
 * 
 * @author Akshay Sahu
 */
public final class ImmutableCalculator {

	/**
	 * 
	 * Steps involved:
	 * 
	 * 1: Use constructors to set all the properties of the Class. <br/>
	 * 2: Make all of the instance variables Private and Final. <br/>
	 * 3: Don't define any Setter Methods. <br/>
	 * 4: Don't allow referenced mutable objects to be modified or accessed
	 * directly. <br/>
	 * 5: Prevent methods from being overriden. Declare class as Final
	 */

	private final int operand1;
	private final int operand2;

	public ImmutableCalculator(int operand1, int operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	public int getOperand1() {
		return operand1;
	}

	public int getOperand2() {
		return operand2;
	}
	
} // End SingletonPatternClass