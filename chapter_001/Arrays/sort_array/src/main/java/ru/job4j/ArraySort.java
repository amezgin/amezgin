package ru.job4j;

/**
 * Class ArraySort.
 *
 *@author Alexander Vezgin
 *@version 1.0
 *@since 21.11.2016
 */
public class ArraySort {
	/**
	* This method returns a sorted array.
	*@param value a parameter takes an array of integer values
	*@return returns the sorted array
	*/
	public int[] bubbleSort(int[] value) {

		for (int i = value.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (value[j] > value[j + 1]) {
					int tmp = value[j];
					value[j] = value[j + 1];
					value[j + 1] = tmp;
				}
			}
		}
		return value;
	}
}