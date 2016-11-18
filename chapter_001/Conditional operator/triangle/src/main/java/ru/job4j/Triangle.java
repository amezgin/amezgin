package ru.job4j;

/**
 * Class Triangle.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 18.11.2016
 */
public class Triangle {

	/**
	 *These variable characterize the vertice of the triangle.
	 */
	private Point a;

	/**
	 *These variable characterize the vertice of the triangle.
	 */
	private Point b;

	/**
	 *These variable characterize the vertice of the triangle.
	 */
	private Point c;

	/**
	 *It is constructor for class Triangle.
	 *@param a1 is the first vertex of the triangle
	 *@param b1 is the second vertex of the triangle
	 *@param c1 is the third vertex of the triangle
	 */
	public Triangle(final Point a1, final Point b1, final Point c1) {
		this.a = a1;
		this.b = b1;
		this.c = c1;
	}

	/**
	 *This method returns the vertex of the triangle.
	 *@return Return of the vertex of the triangle
	 */
	public Point getA() {
		return this.a;
	}

	/**
	 *This method returns the vertex of the triangle.
	 *@return Return of the vertex of the triangle
	 */
	public Point getB() {
		return this.b;
	}

	/**
	 *This method returns the vertex of the triangle.
	 *@return Return of the vertex of the triangle
	 */
	public Point getC() {
		return this.c;
	}

	/**
	 *This method calculates the area of a triangle Heron's formula.
	 *@return It is the area of a triangle
	 *@throws Exception - "It is impossible to construct a triangle with these vertices"
	 */
	public double area() throws Exception {
	double sideAB = this.getA().distanceTo(this.getB());
	double sideAC = this.getA().distanceTo(this.getC());
	double sideBC = this.getB().distanceTo(this.getC());

	if ((sideAB >= sideAC + sideBC) && (sideAC >= sideAB + sideBC) && (sideBC >= sideAC + sideAB)) {
		throw new Exception("It is impossible to construct a triangle with these vertices");
	}

	double properiter = (sideAB + sideAC + sideBC) / 2;

	return Math.sqrt(properiter * (properiter - sideAB) * (properiter - sideAC) * (properiter - sideBC));
	}
}