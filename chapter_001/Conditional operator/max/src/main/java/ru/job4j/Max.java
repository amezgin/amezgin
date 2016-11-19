package ru.job4j;

/**
 * Class Max.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 17.11.2016
 */
public class Max {

	/**
	 *This method calculates the maximum value of the two arguments.
	 *@param first It is first argument
	 *@param second It is second argument
	 *@return Return maximum value
	 */
	public int max(int first, int second) {
		if (first > second) {
			return first;
		} else {
			return second;
		}
	}

	/**
	 *This method calculates the maximum value of the Three arguments.
	 *@param first It is first argument
	 *@param second It is second argument
	 *@param third It is third argument
	 *@return Return maximal value
	 */
	public int max(int first, int second, int third) {
		return max(max(first, second), third);
	}
}