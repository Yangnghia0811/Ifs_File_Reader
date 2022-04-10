package stl;

/**
 * The purpose of Fcaet class is to stores Vertex values and passes in to Vertex
 * class to calculate normal
 * 
 * @author Manh Duong
 * @version 4.14.0
 * @since 1.80_211
 */
public class Facet {
	private Vertex v1;
	private Vertex v2;
	private Vertex v3;
	private Vertex normal;

	/**
	 * parameterized constructor that takes 3 Vertex and stores in Facet class
	 * 
	 * @param v1 the first vertex
	 * @param v2 the second vertex
	 * @param v3 the third vertex
	 */
	public Facet(Vertex v1, Vertex v2, Vertex v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.normal = Vertex.calcNormal(v1, v2, v3);
	}

	/**
	 * toString method helps to format the solid information
	 * 
	 * @return the formatted list of normal and vertex
	 */
	public String toString() {
		String output = "facet normal  " + normal.getX() + " " + normal.getY() + " " + normal.getZ();
		output += "\n  outer loop";
		output += "\n   vertex " + v1.toString();
		output += "\n   vertex " + v2.toString();
		output += "\n   vertex " + v3.toString();
		output += "\n  endloop";
		output += "\nendfacet\n";
		return output;
	}
}