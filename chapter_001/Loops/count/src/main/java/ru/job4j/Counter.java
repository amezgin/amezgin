package ru.job4j;

/**
 *
 *class Counter.
 *
 *@author Alexander Mezgin.
 *@version 1
 *@since 20.11.2016
 */
public class Counter {

	/**
	*This method calculates the sums of the even elements.
	*@param start is the beginning of the range
	*@param finish is the end of the range
	*@return return the sums of the even elements
	*/
	public int add(int start, int finish) {
		int sum = 0;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
	return sum;
	}
}