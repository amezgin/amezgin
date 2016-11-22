package ru.job4j;

/**
 * Class FlipArray.
 *
 *@author Alexander Vezgin
 *@version 1.0
 *@since 22.11.2016
 */
public class FlipArray {

	/**
	* This method returns an array rotated 90 degrees.
	*@param value as a parameter takes a square array of integers
	*@return return an array of deployed 90 degrees counterclockwise
	*/
	public int[][] flip(int[][] value) {
		/**
		 * It is the dimension of the array.
		 */
		int dimension = value.length;

		for (int i = 0; i < dimension / 2; i++) {
			for (int j = 0; j < dimension - i - 1; j++) {
				int tmp = value[i][j];
				value[i][j] = value[j][dimension - i - 1];
				value[j][dimension - i - 1] = value[dimension - i - 1][dimension - j - 1];
				value[dimension - i - 1][dimension - j - 1] = value[dimension - j - 1][i];
				value[dimension - j - 1][i] = tmp;
			}
		}

		return value;
	}
}