package ru.job4j;

/**
 *
 *class Factorial.
 *
 *@author Alexander Mezgin.
 *@version 1
 *@since 20.11.2016
 */
 public class Factorial {

	/**
	*This method calculates the factorial.
	*@param f is the number >= 0
	*@return returns the computed factorial as long
	*@throws IllegalArgumentException - "The argument value must be > 0."
	*/
	public long fact(int f) throws IllegalArgumentException {

		long result = 1L;

		if (f == 0) {
			return result;
		}

		if (f < 0) {
			throw new IllegalArgumentException("The argument value must be > 0.");
		}

		for (int i = 2; i <= f; i++) {
			result *= i;
		}

		return result;
	}
}