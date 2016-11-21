package ru.job4j;

/**
 * Class Turn.
 *
 *@author Alexander Vezgin
 *@version 1.0
 *@since 21.11.2016
 */
public class Turn {

	/**
	* This method returns a flattened array.
	*@param array as a parameter takes an array of integer values
	*@return returns the flipped array
	*/
	public int[] back(int[] array) {

		for (int i = 0; i < array.length / 2; i++) {
			int tmp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = tmp;
		}

		return array;
	}
}