package ru.job4j;

/**
 * Class Calculator.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 17.11.2016
 */

 public class Calculator {
	/**
	 *This variable stores the result of the calculation.
	 */
	 private double result;

	/**
	 *This method calculates the sum of the two arguments.
	 *@param first It is first argument
	 *@param second It is second argument
	 */

	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	 *This method calculates the difference of the two arguments.
	 *@param first It is first argument
	 *@param second It is second argument
	 */

	public void substruct(double first, double second) {
		this.result = first - second;
	}

	/**
	 *This method calculates the division of the two arguments.
	 *@param first It is first argument
	 *@param second It is second argument
	 */

	public void div(double first, double second) {
		this.result = first / second;
	}

	/**
	 *This method calculates the multiple of the two arguments.
	 *@param first It is first argument
	 *@param second It is second argument
	 */

	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	 *This method returns the result.
	 *@return Return of result
	 */

	public double getResult() {
		return this.result;
	}
 }