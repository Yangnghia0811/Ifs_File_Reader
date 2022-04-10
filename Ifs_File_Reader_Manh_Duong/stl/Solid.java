package stl;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class to represent a StL ASCII Format solid. A 3D object that is composed of
 * multiple Facets
 * 
 * @author Manh Duong
 * @version 4.14.0
 * @since 1.80_211
 */
public class Solid {
	private String name;
	private ArrayList<Facet> facets = new ArrayList<Facet>();

	/**
	 * initial constructor that set name to null if user don't enter the name of
	 * solid
	 */
	public Solid() {
		this.name = "";
	}

	/**
	 * parameterized constructor that takes the name
	 * 
	 * @param name takes the name of the fractals
	 */
	public Solid(String name) {
		this.name = name;
	}

	/**
	 * addFacet method helps to add the facet in the array
	 * 
	 * @param facet take the facet and add it to the facets array
	 * @return the array of facets that contains the facet added by user.
	 */
	public boolean addFacet(Facet facet) {
		facets.add(facet);
		return facets.contains(facet);
	}

	/**
	 * takes an amount of of Vertex to create Facet(s) and adds them to the facets
	 * array
	 * 
	 * @param Vertices ( varargs that holds an unfixed array of Vertex
	 * @return false if there are less than 3 vertex, true if there are more than 3 vertex and facets are added successfully
	 */
	public boolean addFacet(Vertex... Vertices) {
		// If there are less than three Vertex, return false
		if (Vertices.length < 3) {
			return false;
		}
		// For every three Vertex, create one Facet.
		if (Vertices.length == 3) {
			facets.add(new Facet(Vertices[0], Vertices[1], Vertices[2]));
		}
		// If there are more than 3 Vertex, create one Facet with the first 3 Vertex
		if (Vertices.length > 3) {
			facets.add(new Facet(Vertices[0], Vertices[1], Vertices[2]));
			// If there is one leftover Vertex, create a Facet from it and the previous
			// three Vertex
			if (Vertices.length <= 4 && Vertices.length > 3) {
				facets.add(new Facet(Vertices[0], Vertices[2], Vertices[3]));
			}
			// If there are two leftover Vertex, create two Facet
			if (Vertices.length <= 5 && Vertices.length > 4) {
				facets.add(new Facet(Vertices[0], Vertices[3], Vertices[4]));
			}
		}
		return true;
	}

	/**
	 * print method prints the list of vertex,normal and facet into the stl file
	 * 
	 * @param print the direction of file where the printer should pint
	 */
	public void print(PrintWriter print) {
		StringBuilder sb = new StringBuilder();
		// print “solid ” and the Solid name
		sb.append("solid ");
		sb.append(this.name);
		sb.append("\n");
		// print each of the Facets using facet's toString method
		for (int i = 0; i < facets.size(); i++) {
			sb.append(facets.get(i).toString());
		}
		// print “endsolid ” and the Solid name
		sb.append("endsolid ");
		sb.append(this.name);
		// print these string builder into stl file
		print.print(sb.toString());
		// close the print
		print.close();
	}

}
