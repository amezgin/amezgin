package ru.job4j;

/**
 * Class Point.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 18.11.2016
 */
public class Point {

	/**
	 *This variable stores the value of the point on the x-axis.
	 */
	private double x;
	/**
	 *This variables stores the value of the point on the y-axis.
	 */
	private double y;

	/**
	 *It is constructor for class Point.
	 *@param x1 - variable stores the value of the point on the x-axis
	 *@param y1 - variable stores the value of the point on the y-axis
	 */
	public Point(final double x1, final double y1) {
	this.x = x1;
	this.y = y1;
	}

	/**
	 *This method returns the value point on the x-axis.
	 *@return Return of the value point on the x-axis
	 */
	public double getX() {
		return this.x;
	}

	/**
	 *This method returns the value point on the y-axis.
	 *@return Return of the value point on the y-axis
	 */
	public double getY() {
		return this.y;
	}

	/**
	 *This method calculates the distance between two points.
	 *@param point is passed a point
	 *@return It is return distans between two points
	 */
	public double distanceTo(Point point) {
		return Math.sqrt(Math.pow(this.getX() - point.getX(), 2) + Math.pow(this.getY() - point.getY(), 2));
	}
}