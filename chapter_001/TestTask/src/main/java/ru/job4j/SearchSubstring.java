package ru.job4j;

/**
 * Class SearchSubstring.
 *
 *@author Alexander Vezgin
 *@version 1.0
 *@since 22.11.2016
 */
public class SearchSubstring {

	/**
	* This method returned true if string contains substring and false if not.
	*@param origin is a original string
	*@param sub is a substring
	*@return true if string contains substring and false if not
	*/
	public boolean contains(String origin, String sub) {
		/**
		 * Here the original string is converted to a character array.
		 */
		char[] origChar = origin.toCharArray();

		/**
		 * Here the substring is converted to a character array.
		 */
		char[] subChar = sub.toCharArray();

		for (int i = 0; i <= origChar.length - subChar.length; i++) {
			for (int j = 0; j < subChar.length; j++) {
				if (subChar[j] != origChar[i + j]) {
					break;
				}
				if (j == subChar.length - 1) {
					return true;
				}
			}
		}

		return false;
	}
}