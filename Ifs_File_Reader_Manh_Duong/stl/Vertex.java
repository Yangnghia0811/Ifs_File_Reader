package stl;

import java.text.DecimalFormat;
import java.lang.Math;

/**
 * The purpose of Vertex class is to represent a single 3-dimensional vertex.
 * 
 * @author Manh Duong
 * @version 4.14.0
 * @since 1.80_211
 */
public class Vertex {
	private double x, y, z;
	private DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * parameterized constructor that takes 3 co-ordinates and store in Vertex class
	 * 
	 * @param x the x - co-ordinate of the vertex
	 * @param y the y - co-ordinate of the vertex
	 * @param z the z - co-ordinate of the vertex
	 */
	public Vertex(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * toString method helps to print out formatted 3 co-ordinates
	 */
	public String toString() {
		return df.format(x) + " " + df.format(y) + " " + df.format(z);
	}

	/**
	 * calcNormal method calculates normal based on 3 given Vertex
	 * 
	 * @param v1 The first vertex
	 * @param v2 The second vertex
	 * @param v3 The third vertex
	 * @return the normal vertex
	 */
	public static Vertex calcNormal(Vertex v1, Vertex v2, Vertex v3) {
		double[] vector12 = { (v2.x - v1.x), (v2.y - v1.y), (v2.z - v1.z) };
		double[] vector13 = { (v3.x - v1.x), (v3.y - v1.y), (v3.z - v1.z) };
		double a = vector12[1] * vector13[2] - vector12[2] * vector13[1];
		double b = vector12[2] * vector13[0] - vector12[0] * vector13[2];
		double c = vector12[0] * vector13[1] - vector12[1] * vector13[0];
		double root = Math.sqrt(a * a + b * b + c * c);
		return new Vertex(((a) / (root)), ((b) / (root)), ((c) / (root)));
	}

	/**
	 * getX method helps to get the value x
	 * 
	 * @return the x - co-ordinate of the vertex
	 */
	public String getX() {
		return df.format(x);
	}

	/**
	 * getX method helps to get the value y
	 * 
	 * @return the y - co-ordinate of the vertex
	 */
	public String getY() {
		return df.format(y);
	}

	/**
	 * getX method helps to get the value z
	 * 
	 * @return the z - co-ordinate of the vertex
	 */
	public String getZ() {
		return df.format(z);
	}
}
