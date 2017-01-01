package ru.job4j;

/**
 *
 *class Paint.
 *
 *@author Alexander Mezgin.
 *@version 1
 *@since 20.11.2016
 */
 public class Paint {

	/**
	*This method paint the pyramid.
	*@param h is the height of the pyramid
	*@return returns a string that contains the pyramid
	*/
	public String pyramid(int h) {

		int widthPyr = h * 2 + 1;

		StringBuilder pyramid = new StringBuilder();

		if (h <= 0) {
		pyramid.append("You can't build a pyramid with that height!");
		}
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= widthPyr; j++) {
				if (j <= h - i || j >= h + i) {
					pyramid.append(" ");
				} else {
					pyramid.append(" ^");
					j += 1;
				}
			}

			pyramid.append("\n\r");
		}
		return pyramid.toString();
	}
}